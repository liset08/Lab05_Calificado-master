package pe.edu.tecsup.lab05_calificado.activities;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.lab05_calificado.R;
import pe.edu.tecsup.lab05_calificado.adapter.ProductosAdapter;
import pe.edu.tecsup.lab05_calificado.models.producto;
import pe.edu.tecsup.lab05_calificado.repositories.ProductoRepository;

import static pe.edu.tecsup.lab05_calificado.repositories.ProductoRepository.productlista;

public class MainActivity extends AppCompatActivity {

    RecyclerView listproducts;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

listproducts=(RecyclerView) findViewById(R.id.RecyclerView);


        listproducts.setLayoutManager(new LinearLayoutManager(this));  //de que manera se van a alinear los item de forma lineal

        final ProductosAdapter personAdapter = new ProductosAdapter();
        personAdapter.setProduct(ProductoRepository.getList());

        listproducts.setAdapter(personAdapter);




    }

}
