package com.dam.crud_api_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    TextView ednombre,edcorreo,eddireccion,edParentezco;

    private  int position;

    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        this.window = getWindow();
        window.setStatusBarColor(Color.parseColor("#00BCD4"));

        ednombre=findViewById(R.id.ednombre);
        edcorreo=findViewById(R.id.edcorreo);
        eddireccion=findViewById(R.id.eddireccion);

        edParentezco=findViewById(R.id.edParentezco);


        Intent intent=getIntent();
        position=intent.getExtras().getInt("position");


        ednombre.setText(MainActivity.usuariosArrayList.get(position).getNombre());
        edcorreo.setText(MainActivity.usuariosArrayList.get(position).getCorreo());
        eddireccion.setText(MainActivity.usuariosArrayList.get(position).getDireccion());
        edParentezco.setText(MainActivity.usuariosArrayList.get(position).getParentezco());
}
}