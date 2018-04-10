package pe.edu.tecsup.lab05_calificado.activities;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import pe.edu.tecsup.lab05_calificado.R;

public class DetailActivity extends AppCompatActivity {
    Button send;

    //correo electronico



    Button enviar;
    Session session;

    //
    private Button volver;
    private static final int numero=985184554;
    private static final int PERMISSIONS_REQUEST=100;
    final int SEND_SMS_PERMISSION_REQUEST_CODE= 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //mensajes permisos
         send= (Button) findViewById(R.id.buttonSend);

        volver = (Button)findViewById(R.id.brnvolver);

        getIncomingIntent();


    }
//boton de volver

    public void volver(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);


    }


    public void getIncomingIntent(){

        if (getIntent().hasExtra("nameText")&& getIntent().hasExtra("nameimg")&& getIntent().hasExtra("namedis")&& getIntent().hasExtra("nameadr")&& getIntent().hasExtra("nameimg2")){
           String im=getIntent().getStringExtra("nameText");

            String img=getIntent().getStringExtra("nameimg");
            String imgdes=getIntent().getStringExtra("namedis");
            String adress=getIntent().getStringExtra("nameadr");
            Integer img2=getIntent().getIntExtra("nameimg2",2);

            settext(im,img,imgdes,adress,img2);
        }
    }
    public void settext(String im, String img, String imgdes, String adress,Integer img2){
        TextView name=findViewById(R.id.textView2);
        name.setText(img);
        TextView name2=findViewById(R.id.text);
        name2.setText(im);
        TextView name3=findViewById(R.id.textInformation);
        name3.setText(imgdes);
        TextView name4=findViewById(R.id.txtdireccion);
        name4.setText(adress);
        ImageView name5=findViewById(R.id.imagedetalle);
name5.setImageResource(img2);


    }
//metodo para os permispoos de llamada

    public void call(View view){

        // Check permission (Api 22 check in Manifest, Api 23 check by requestPermissions)
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // Dont have permission => request one or many permissions (String[])
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST);
        }else {
            // Have permission

            openCallApplication();
                 }
    }


    // On request permissions result
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        switch (requestCode) {
            case PERMISSIONS_REQUEST: {
                if (permissions[0].equals(Manifest.permission.CALL_PHONE)) {
                    if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        openCallApplication();
                    }else{
                        Toast.makeText(this, "CALL_PHONE permissions declined!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
    public void openCallApplication(){
        String numero=getIntent().getStringExtra("nameText");

        if(numero.isEmpty()){
            Toast.makeText(this, "Phone number required!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+numero));

        // Is necesary to check permission again before startActivity
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
            startActivity(intent);
    }


//llamada del enlace de la web
public void callurl(View view){
    // Check permission (Api 22 check in Manifest, Api 23 check by requestPermissions)
    if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
        // Dont have permission => request one or many permissions (String[])
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST);
    }else {
        // Have permission

        openWeb();        }
}



    public void openWeb(){
        String urltext=getIntent().getStringExtra("nameweb");
        if(urltext.isEmpty()){
            Toast.makeText(this, "Direccion es requerida", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://"+urltext));


        // Is necesary to check permission again before startActivity
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
            startActivity(intent);
    }


    //DIALOGO PARA EL MENSAJE DE TEXTO

    public void showDialog(View view){

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        // Custom Android Allert Dialog Title
        dialog.setTitle("Enviar Mensaje");

        Button dialogButtonCancel;
        Button dialogButtonOk;
        final EditText message;

        message = (EditText) dialog.findViewById(R.id.inputMessage);

        dialogButtonCancel = (Button) dialog.findViewById(R.id.customDialogCancel);
        dialogButtonOk = (Button) dialog.findViewById(R.id.buttonSend);

        // Click cancel to dismiss android custom dialog box
        dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cancel process!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
dialogButtonOk.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String imnum=getIntent().getStringExtra("nameText");
        String smsMessage=message.getText().toString();



        if (imnum == null || imnum.length()==0 || smsMessage==null || smsMessage.length()==0){
            return;
        }
        if (checkPermission(Manifest.permission.SEND_SMS)){
            SmsManager smsManager= SmsManager.getDefault();
            smsManager.sendTextMessage(imnum, null,smsMessage, null, null);
            Toast.makeText(getApplicationContext(),"Mensaje enviado", Toast.LENGTH_SHORT).show();
            dialog.dismiss();


        }else {
            Toast.makeText(getApplicationContext(), "Permiso denegado", Toast.LENGTH_SHORT).show();
            dialog.dismiss();

        }

    }
});
        // Your android custom dialog ok action
        // Action for custom dialog ok button click


        dialog.show();

    }

//permisos para enviar mensaje
    public boolean checkPermission(String permission){
        int check = ContextCompat.checkSelfPermission(this,permission);
        return (check== PackageManager.PERMISSION_GRANTED);
    }

//metodo par enviar correo electronico

    public void showDialogEmail(View view){

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.correo_dialog);
        // Custom Android Allert Dialog Title
        dialog.setTitle("Enviar E-mail");

        Button dialogButtonCancel;
        Button dialogButtonOk;
       final EditText mensaje;
        final EditText password;
        final EditText adress;

        mensaje = (EditText) dialog.findViewById(R.id.inputMensaje);
        password = (EditText) dialog.findViewById(R.id.inputContra);
        adress = (EditText) dialog.findViewById(R.id.inputCorreo);


        dialogButtonCancel = (Button) dialog.findViewById(R.id.customDialogCancel);
        dialogButtonOk = (Button) dialog.findViewById(R.id.buttonSendEmail);

        // Click cancel to dismiss android custom dialog box
        dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cancel process!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialogButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String txtMessage=mensaje.getText().toString();
                final String correo=adress.getText().toString();
                final String contraseña=password.getText().toString();


                StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Properties properties=new Properties();
                properties.put("mail.smtp.host", "smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");


                try {
                    session=Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo,contraseña
                            );
                        }
                    });

                    if (session!=null){
                        Message message= new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("Envios dede la Aplicacion Movil");
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("liset.amaro57@gmail.com"));
                        message.setContent(txtMessage, "text/html; charset=utf-8");
                        Transport.send(message);

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }




            }
        });


        dialog.show();

    }

}

