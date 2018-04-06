package pe.edu.tecsup.lab05_calificado.activities;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.tecsup.lab05_calificado.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getIncomingIntent();


    }

    private void getIncomingIntent(){

        if (getIntent().hasExtra("nameText")&& getIntent().hasExtra("nameimg")&& getIntent().hasExtra("picture")){
           String im=getIntent().getStringExtra("nameText");

            String img=getIntent().getStringExtra("nameimg");



            settext(im,img);
        }
    }

    private void settext(String im, String img){
        TextView name=findViewById(R.id.textView2);
        name.setText(img);
        TextView name2=findViewById(R.id.text);
        name2.setText(im);


    }}

