package pe.edu.tecsup.lab05_calificado.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import pe.edu.tecsup.lab05_calificado.R;
import pe.edu.tecsup.lab05_calificado.adapter.ProductosAdapter;
import pe.edu.tecsup.lab05_calificado.repositories.ProductoRepository;

public class SearchResultActivity extends AppCompatActivity {

    RecyclerView listproducts;
    ProductosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        listproducts = (RecyclerView) findViewById(R.id.RecyclerView);


        listproducts.setLayoutManager(new LinearLayoutManager(this));  //de que manera se van a alinear los item de forma lineal

        adapter = new ProductosAdapter();
        adapter.setProduct(ProductoRepository.getList());

        listproducts.setAdapter(adapter);


    }
}
