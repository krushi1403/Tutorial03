package com.example.intentsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText etn1,etn2 ;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn1 = findViewById(R.id.num1);
        etn2 = findViewById(R.id.num2);
        btn = findViewById(R.id.btn_ok);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //make test is a static method , context = 'where -one to another application or to one to anther function'
               /* Toast toast = Toast .makeText(getApplicationContext(),"sending message..." , Toast.LENGTH_LONG);
                toast.show();

                toast.setGravity(Gravity.TOP|Gravity.CENTER, 0,0);*/


                //Creating the LayoutInflater instance
                LayoutInflater li = getLayoutInflater();
                //Getting the View object as defined in the customtoast.xml file
                View layout = li.inflate(R.layout.layoutcustom, (ViewGroup)
                        findViewById(R.id.custom_toast_layout));
                //Creating the Toast object
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(layout);//setting the view of custom toast layout
                toast.show();


                String n1 = etn1.getText().toString();
                String n2 = etn2.getText().toString();

                Intent i = new Intent(MainActivity.this , SecondActivity.class);

                i.putExtra("EXTRA_1" , n1);
                i.putExtra("EXTRA_2" , n2);

                startActivity(i);
            }
        });
    }
}