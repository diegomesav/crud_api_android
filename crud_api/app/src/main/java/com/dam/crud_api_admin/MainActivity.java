package com.dam.crud_api_admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListView listView;
    Adapter adapter;
    public static ArrayList<Usuarios>usuariosArrayList =new ArrayList<>();
    //modificaciones
    //SwipeRefreshLayout swipeRefreshLayout;
    private Window window;
    SearchView tvSearch;

    Usuarios usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =findViewById(R.id.list);
        adapter=new Adapter(this,usuariosArrayList);
        listView.setAdapter(adapter);

        //swipeRefreshLayout = findViewById(R.id.suipeRefresh);
        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#00BCD4"));


        tvSearch = findViewById(R.id.tvSearch);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
               // ProgressDialog progressDialog=new ProgressDialog(view.getContext());

                CharSequence[]dialogo={"VER DATOS","EDITAR DATOS","ELIMINAR DATOS"};

                builder.setTitle(usuariosArrayList.get(position).getNombre());

                builder.setItems(dialogo, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                               switch (i){

                                   case 0:
                                       startActivity(new Intent(getApplicationContext(),Detalles.class).putExtra("position",position));
                                       break;
                                   case 1:
                                       startActivity(new Intent(getApplicationContext(), Editar.class).putExtra("position",position));
                                       break;
                                   case 2:
                                     Eliminar(usuariosArrayList.get(position).getId());
                                       break;
                               }
                    }
                });
                builder.show();

            }
        });

        ListarDatos();
        /*
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ListarDatos();
                swipeRefreshLayout.setRefreshing(false);
            }
        });*/

        tvSearch.setOnQueryTextListener(this);


    }
    public  void agregar(View view){
        Intent intent=new Intent(MainActivity.this,Agregar.class);
        startActivity(intent);
    }

    public void refrescar(View view){
        ListarDatos();
    }


    public void ListarDatos(){

        StringRequest request =new StringRequest(Request.Method.POST, "https://ejemploscursodesarrolloipi.000webhostapp.com//web-service-php/mostrar_.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        usuariosArrayList.clear();
                        try {
                            JSONObject jsonObject =new JSONObject(response);
                            String exito=jsonObject.getString("exito");
                            JSONArray jsonArray =jsonObject.getJSONArray("datos");

                            if (exito.equals("1")){
                                for (int i=0;i<jsonArray.length();i++){
                                  JSONObject object=jsonArray.getJSONObject(i);
                                    String id=object.getString("id");
                                    String nombre=object.getString("nombre");
                                    String correo=object.getString("correo");
                                    String direccion=object.getString("direccion");
                                    String parentezco=object.getString("parentezco");

                                    usuarios =new Usuarios(id,nombre,correo,direccion,parentezco);
                                    usuariosArrayList.add(usuarios);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
        ){


        };
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }

    public  void Eliminar(final  String id){
        StringRequest request =new StringRequest(Request.Method.POST, "https://ejemploscursodesarrolloipi.000webhostapp.com/web-service-php/eliminar_.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("datos eliminados")) {
                            Toast.makeText(MainActivity.this, "elimino correctamente", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "Error no se puede registrar", Toast.LENGTH_SHORT).show();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        }
        ){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String>params=new HashMap<>();
                params.put("id",id);


                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        if(adapter.filtrado(s)==0){
            ListarDatos();
        };
        return false;
    }
}