package pe.edu.tecsup.lab05_calificado.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.tecsup.lab05_calificado.R;

public class DetailActivity extends AppCompatActivity {
    private Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        volver = (Button)findViewById(R.id.brnvolver);

        getIncomingIntent();


    }

    public void volver(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);


    }


    private void getIncomingIntent(){

        if (getIntent().hasExtra("nameText")&& getIntent().hasExtra("nameimg")&& getIntent().hasExtra("namedis")&& getIntent().hasExtra("nameadr")){
           String im=getIntent().getStringExtra("nameText");

            String img=getIntent().getStringExtra("nameimg");
            String imgdes=getIntent().getStringExtra("namedis");
            String adress=getIntent().getStringExtra("nameadr");

            settext(im,img,imgdes,adress);
        }
    }

    private void settext(String im, String img, String imgdes, String adress){
        TextView name=findViewById(R.id.textView2);
        name.setText(img);
        TextView name2=findViewById(R.id.text);
        name2.setText(im);
        TextView name3=findViewById(R.id.textInformation);
        name3.setText(imgdes);
        TextView name4=findViewById(R.id.txtdireccion);
        name4.setText(adress);

    }}

