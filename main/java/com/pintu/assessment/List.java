package com.pintu.assessment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class List extends AppCompatActivity {



    private EditText txtInput;
    ListView listView;
    Button Refresh;
    FloatingActionButton fab;
    String fname_D,lname_D,gender_D,status_D,qualify_D,email_D,phone_D;

    ArrayList<MyData> arrayList = new ArrayList<MyData>();
    CustomAdapter customAdapter;
    ArrayAdapter<MyData> aAdapter;



    public void onCreate(Bundle savedInstanceState) {

       // TextView txtitemL;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView = (ListView)findViewById(R.id.listv);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        Refresh = (Button)findViewById(R.id.btnRefresh);
      //  txtitemL =(TextView)findViewById(R.id.txtitem);

        Refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customAdapter == null){
                    customAdapter=new CustomAdapter(AppConstant.mydatas,List.this);
                    listView.setAdapter(customAdapter);
                }else{
                    listView.setAdapter(customAdapter);
                    //arrayList.notifyDataSetChanged();
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Form_1.class));
//                String newItem = character.getClass().toString();
//                arrayList.add(newItem);

            }
        });
        /*
            Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
             fname_D = bundle.getString("First Name");
             lname_D = bundle.getString("Last Name");
             gender_D = bundle.getString("Gender");
             status_D = bundle.getString("Status");
             qualify_D = bundle.getString("Qualification");
             phone_D = bundle.getString("Mobile No");
             email_D = bundle.getString("Email");
        }


            AppConstant.mydatas.add(new MyData(fname_D,lname_D,gender_D,status_D,qualify_D,phone_D,email_D));

         */

        if(AppConstant.mydatas.size()>0)
        {

            customAdapter=new CustomAdapter(AppConstant.mydatas,this);
            listView.setAdapter(customAdapter);
        }
        /*
            System.out.println(gender_D+"  "+status_D+" "+qualify_D);
            CustomAdapter customAdapter =new CustomAdapter(AppConstant.mydatas, this);
            listView.setAdapter((ListAdapter)customAdapter);
         */

    }
}
