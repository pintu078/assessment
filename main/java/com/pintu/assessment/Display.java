package com.pintu.assessment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Display extends AppCompatActivity {
    TextView receiver_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        receiver_msg = (TextView)findViewById(R.id.received_value_idd);
       // MyData myData = (MyData) getIntent().getSerializableExtra("MyData");
      //  receiver_msg.setText("First Name      " +myData.fNameC +"\n"+"Last Name      "+myData.lNameC+"\n"+"Gender            " +myData.genderC+"\n"+"Status             " +myData.statusC+"\n"+"Qualification  " + myData.qualifC+"\n"+"Moile No        " +myData.mobileC+"\n"+"Email              " +myData.emailC);
//        Intent intent  = getIntent();
//
//        String str = intent.getStringExtra("message_key");
//        receiver_msg.setText(str);
//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null) {
//            String fname_D = bundle.getString("First Name");
//            String lname_D = bundle.getString("Last Name");
//            String gender_D = bundle.getString("Gender");
//            String status_D = bundle.getString("Status");
//            String qualify_D = bundle.getString("Qualification");
//            String phone_D = bundle.getString("Moile No");
//            String email_D = bundle.getString("Email");
//
//
//            TextView  fnameD = findViewById(R.id.first_Name_idd);
//            TextView lnameD = findViewById(R.id.last_Name_idd);
//            TextView genderD = findViewById(R.id.gender_idd);
//            TextView statusD = findViewById(R.id.status_idd);
//            TextView qualifyD = findViewById(R.id.qualify_idd);
//            TextView phoneNoD = findViewById(R.id.phoneNo_idd);
//            TextView emailD = findViewById(R.id.email_idd);
//
//            fnameD.setText(fname_D);
//            lnameD.setText(lname_D);
//            genderD.setText(gender_D);
//            statusD.setText(status_D);
//            qualifyD.setText(qualify_D);
//            phoneNoD.setText(phone_D);
//            emailD.setText(email_D);


    }

}
