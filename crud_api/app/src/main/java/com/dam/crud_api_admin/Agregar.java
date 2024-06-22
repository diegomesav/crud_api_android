package com.dam.crud_api_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Agregar extends AppCompatActivity {
 EditText ednombre,edcorreo,eddireccion;
 Button btnregistrar;

 //Para la lista desplegable

 String [] parentezcos = {"Abuelo","Padre","Hermano","hijo"};
 String parentezco;
 AutoCompleteTextView autoComplete;
 ArrayAdapter<String> adapterParentezco;

 //----------------------------------------------------------


    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#00BCD4"));

        ednombre=findViewById(R.id.ednombre);
        edcorreo=findViewById(R.id.edcorreo);
        eddireccion=findViewById(R.id.eddireccion);
        btnregistrar=findViewById(R.id.button);

        //Para la lista desplegable
        autoComplete = findViewById(R.id.selec_edParentezco);
        adapterParentezco = new ArrayAdapter<String>(this,R.layout.list_parentezco,parentezcos);
        autoComplete.setAdapter(adapterParentezco);
        autoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                parentezco = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(),"Parentezco: "+parentezco,Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------------------------------


        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarDatos();
            }
        });
    }

    private void registrarDatos() {

        String nombre=ednombre.getText().toString().trim();
        String correo=edcorreo.getText().toString().trim();
        String direccion=eddireccion.getText().toString().trim();

        ProgressDialog progressDialog =new ProgressDialog(this);
        progressDialog.setMessage("cargando");


        if (nombre.isEmpty()){
            Toast.makeText(this,"ingrese nombre",Toast.LENGTH_SHORT).show();
        }else if (correo.isEmpty()){
            Toast.makeText(this,"ingrese correo",Toast.LENGTH_SHORT).show();
        }else if (direccion.isEmpty()){
            Toast.makeText(this,"ingrese direccion",Toast.LENGTH_SHORT).show();
        }else {
            progressDialog.show();
            StringRequest request =new StringRequest(Request.Method.POST, "https://ejemploscursodesarrolloipi.000webhostapp.com/web-service-php/insertar_.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equalsIgnoreCase("datas insertados")) {
                                Toast.makeText(Agregar.this, "registrado correctamente", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(Agregar.this, "Error no se puede registrar", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Agregar.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            ){

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String>params=new HashMap<>();
                    params.put("nombre",nombre);
                    params.put("correo",correo);
                    params.put("direccion",direccion);
                    params.put("parentezco",parentezco);

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(Agregar.this);
            requestQueue.add(request);
        }
    }
}