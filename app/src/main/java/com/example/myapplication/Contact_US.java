package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contact_US extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__u_s);

//        ya send button py lagaya hai jo srif email used krskta hai


        final EditText edit1=(EditText)findViewById(R.id.EditText1);
        //final EditText edit2=(EditText)findViewById(R.id.EditText2);
        final EditText edit3=(EditText) findViewById(R.id.EditText3);
        final EditText edit4=(EditText) findViewById(R.id.EditText4);
        Button btn=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("message/html");
                i.putExtra(Intent.EXTRA_EMAIL,new String("xyz@gmail.com"));
                i.putExtra(Intent.EXTRA_SUBJECT,"Feedback From App");
                i.putExtra(Intent.EXTRA_TEXT,"Name:"+edit1.getText()+"\n Phone Number:"+edit3.getText()+"\n Message:"+edit4.getText());
                try {
                    startActivity(Intent.createChooser(i,"Please Select Email"));
                }
                catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(Contact_US.this,"There are no email",Toast.LENGTH_SHORT).show();
                }
            }
        });
//        or yaha end hora hai
 //       form this  line you can new code

    }
}