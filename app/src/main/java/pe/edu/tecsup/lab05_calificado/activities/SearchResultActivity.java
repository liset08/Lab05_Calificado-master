package pe.edu.tecsup.lab05_calificado.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.lab05_calificado.R;
import pe.edu.tecsup.lab05_calificado.adapter.ProductosAdapter;
import pe.edu.tecsup.lab05_calificado.models.producto;
import pe.edu.tecsup.lab05_calificado.repositories.ProductoRepository;

public class SearchResultActivity extends AppCompatActivity {
    private List<producto> productolista= ProductoRepository.getList();

    RecyclerView recyclerView;
    EditText editText;

    ProductosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));  //de que manera se van a alinear los item de forma lineal

        adapter = new ProductosAdapter();
        adapter.setProduct(ProductoRepository.getList());

        recyclerView.setAdapter(adapter);

        editText=(EditText) findViewById(R.id.buscar1);
        Bundle bundle=getIntent().getExtras();
        String dato=bundle.getString("text").toString();
        editText.setText(dato);

editText.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence s, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        filter(s.toString());

    }
});

    }


//metodo para os

    private void filter(String s) {

        ArrayList<producto> filteredList = new ArrayList<>();

        for (producto item : productolista) {
            if (item.getName().toLowerCase().contains(s.toLowerCase())) {filteredList.add(item);}
        }
        adapter.filterList(filteredList);

    }


}
