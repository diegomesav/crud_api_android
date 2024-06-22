package com.dam.crud_api_admin;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Adapter  extends ArrayAdapter<Usuarios> {


    Context context;
    List<Usuarios>usuariosList;
    ArrayList<Usuarios> usuariosListOriginal;

    public Adapter(@NonNull Context context, List<Usuarios>UsuariosList) {
        super(context,R.layout.list_usuarios,UsuariosList);
        this.context=context;
        this.usuariosList=UsuariosList;
        //Modificaciones para el search
        usuariosListOriginal = new ArrayList<>();
        usuariosListOriginal.addAll(usuariosList);

    }

    public View getView( int position, @NonNull View context, ViewGroup resource) {
       View view= LayoutInflater.from(resource.getContext()).inflate(R.layout.list_usuarios,null,true);
        TextView tvid=view.findViewById(R.id.txt_id);
        TextView tvnombre=view.findViewById(R.id.txt_name);

        tvid.setText(usuariosList.get(position).getId());
        tvnombre.setText(usuariosList.get(position).getNombre());

        return view;
    }
    //------------------------------------filtrar
    public int filtrado(String buscar){

        int longitud = buscar.length();
        if (longitud == 0){
            usuariosList.clear();
            usuariosList.addAll(usuariosListOriginal);
            return 0;
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                List<Usuarios> collection = usuariosList.stream()
                        .filter(i -> i.getNombre().toLowerCase().contains(buscar.toLowerCase()))
                        .collect(Collectors.toList());
                usuariosList.clear();
                usuariosList.addAll(collection);
            }
            else {
                usuariosList.clear();
                for(Usuarios c: usuariosListOriginal){
                    if(c.getNombre().toLowerCase().contains(buscar.toLowerCase())){
                        usuariosList.add(c);
                    }
                }
            }

        }
        notifyDataSetChanged();
        return 1;

    }




}
