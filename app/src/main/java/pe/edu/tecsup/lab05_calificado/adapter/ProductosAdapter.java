package pe.edu.tecsup.lab05_calificado.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.lab05_calificado.R;
import pe.edu.tecsup.lab05_calificado.activities.DetailActivity;
import pe.edu.tecsup.lab05_calificado.models.producto;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Alumno on 5/04/2018.
 */

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolder>{
    private List<producto> product;

    public void setProduct(List<producto> product) {
        this.product = product;
    }



    public class ViewHolder extends RecyclerView.ViewHolder { ///este view holdeer va tener cargado esta clase de biew holder
        private Button go;
        ImageView productImage;
        TextView nameText;
        TextView phoneText;
        TextView direccion;
EditText search;
        TextView descText;

        public ViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            nameText = itemView.findViewById(R.id.product_title);
            phoneText = itemView.findViewById(R.id.phone);
            direccion = itemView.findViewById(R.id.direccion);
search=itemView.findViewById(R.id.busqueda);
            go = itemView.findViewById(R.id.button);

            //   descText = itemView.findViewById(R.id.te);

        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final producto prod = product.get(position);
        final int resId = holder.itemView.getContext().getResources().getIdentifier(prod.getPicture(), "drawable", holder.itemView.getContext().getPackageName()); //busca la imagen mediante el registro del adaptador people
        holder.productImage.setImageResource(resId);
        holder.nameText.setText(prod.getName());
        holder.phoneText.setText(prod.getPhone());
        holder.direccion.setText(prod.getAdress());
        String textobusqueda=holder.search.getText().toString();


        holder.go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

   Intent intent=new Intent(holder.itemView.getContext(), DetailActivity.class);
intent.putExtra("nameText", prod.getPhone() );
                intent.putExtra("nameimg", prod.getName() );
                intent.putExtra("namedis", prod.getDescripcion() );
                intent.putExtra("nameadr", prod.getAdress() );
                intent.putExtra("nameimg2", holder.itemView.getContext().getResources().getIdentifier(prod.getPicture(), "drawable", holder.itemView.getContext().getPackageName()) );
                intent.putExtra("nameweb", prod.getWeb() );


                holder.itemView.getContext().startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return product.size();
    }


    public void updateList(List<producto> list) {
        product=list;
notifyDataSetChanged();
    }
}


