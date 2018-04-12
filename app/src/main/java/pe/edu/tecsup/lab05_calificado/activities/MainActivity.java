package pe.edu.tecsup.lab05_calificado.activities;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


import java.util.ArrayList;
import java.util.List;
import pe.edu.tecsup.lab05_calificado.adapter.ProductosAdapter;

import pe.edu.tecsup.lab05_calificado.R;
import pe.edu.tecsup.lab05_calificado.models.producto;
import pe.edu.tecsup.lab05_calificado.repositories.ProductoRepository;

import static pe.edu.tecsup.lab05_calificado.repositories.ProductoRepository.productlista;

public class MainActivity extends AppCompatActivity {

   ImageButton buscar;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buscar=(ImageButton) findViewById(R.id.button_search);
        editText2 = findViewById(R.id.buscar);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =  new Intent(MainActivity.this, SearchResultActivity.class);
                intent.putExtra("text", editText2.getText().toString());
                startActivity(intent);
            }
        });

    }




    }


