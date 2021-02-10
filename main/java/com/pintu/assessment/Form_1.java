package com.pintu.assessment;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.pintu.assessment.R.layout.activity_list_item;


public class Form_1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText firstName, lastName, phoneNo, email,edGender;
    TextView tv,tvGender,tvGenderEr,tvStatusEr;
    RadioButton male,female,emp,unemp;
    RadioGroup rdgGender,rdgStatus;
    Button btn ;
    Spinner high_Qualification;

    String first_name;
    String last_Name;
    String phone_No;
    String e_mail ;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String gender;
    String status;
    String high_Qualify;
    String str;
    String rdg_Gender, rdg_Status;
    boolean checked = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
       // String quali [] = {"","M-Tech" , "B-Tech" ,"ME", "BE", "Diploma", "!2th", "10th"};

        firstName = (EditText)findViewById(R.id.firstName);
        lastName = (EditText)findViewById(R.id.lastName);
        phoneNo = (EditText)findViewById(R.id.phoneNo);
        email = (EditText)findViewById(R.id.email);
       // edGender = (EditText)findViewById(R.id.edgender);
        male = (RadioButton)findViewById(R.id.male);
        female = (RadioButton)findViewById(R.id.female);
        emp = (RadioButton)findViewById(R.id.employeable);
        unemp = (RadioButton)findViewById(R.id.Unemployabale);
        rdgGender = (RadioGroup)findViewById(R.id.rdgGender);
        rdgStatus = (RadioGroup)findViewById(R.id.rdgStatus);
        btn = (Button)findViewById(R.id.submit);

        tv = (TextView)findViewById(R.id.result);
        tvGender =(TextView)findViewById(R.id.tvgender);
        tvGenderEr =(TextView)findViewById(R.id.tvgender_er);
        tvStatusEr =(TextView)findViewById(R.id.tvstatus_er);

        high_Qualification = (Spinner)findViewById(R.id.highestQuali) ;

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.spinners_value));
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        high_Qualification.setAdapter(aa);
        high_Qualification.setOnItemSelectedListener(this);

        final Intent intent = getIntent();
        final int posti = intent.getIntExtra("posi",0);
        System.out.println("-------------------------------------------------------");
        System.out.println(posti);
        if(intent != null){
            checked = true;
            String s1 = intent.getStringExtra("fn");
            String s2 = intent.getStringExtra("ln");
            String s3 = intent.getStringExtra("gen");
            System.out.println("------------------------------------------");
            System.out.println("Gender "+s3);

            String s4 = intent.getStringExtra("stat");
            System.out.println(s4);
            String s5 = intent.getStringExtra("quali");
            String s6 = intent.getStringExtra("ema");
            String s7 = intent.getStringExtra("mob");
            if(intent.hasExtra("fn")){
                firstName.setText(s1);
            }
            if(intent.hasExtra("ln")){
                lastName.setText(s2);
            }
            if(intent.hasExtra("gen")){
                if(s3.equals("Male")){
                    male.setChecked(true);
                }else if(s3.equals("Female")){
                    female.setChecked(true);
                }
            }
//            if(intent.hasExtra("gem") && s4 == "Male"){
//                male.setChecked(true);
//            }else if(intent.hasExtra("gen") && s4 == "FeMale"){
//                female.setChecked(true);
//            }
            if(intent.hasExtra("stat") && s4.equals("Employe")){
                emp.setChecked(true);
            }
            if(intent.hasExtra("stat") && s4.equals("UnEmploy")){
                unemp.setChecked(true);
            }
            if(intent.hasExtra("quali")){
                System.out.println("--------------"+s5+"-------------------------");
                if (s5 != null) {
                    int spinnerPosition = aa.getPosition(s5);
                    System.out.println("--------------"+s5+"-------------------------");
                    high_Qualification.setSelection(spinnerPosition);
                }
            }
            if(intent.hasExtra("ema")){
                email.setText(s6);
            }
            if(intent.hasExtra("mob")){
                phoneNo.setText(s7);
            }

//            AppConstant.mydatas.set(posti,new MyData(firstName.getText().toString(),lastName.getText().toString(),phoneNo.getText().toString(),email.getText().toString()));
//            finish();
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first_name = firstName.getText().toString();
                last_Name = lastName.getText().toString();
                phone_No = phoneNo.getText().toString();
                e_mail = email.getText().toString().trim();
                int isSelected_Gender =  rdgGender.getCheckedRadioButtonId();
                int isSelected_Status = rdgStatus.getCheckedRadioButtonId();
                class Radio_check implements  CompoundButton.OnCheckedChangeListener {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (male.isChecked()) {
                            tvGenderEr.setVisibility(View.GONE);
                            tvGenderEr.setError(null);
                            gender = male.getText().toString();
                            System.out.println(gender);
                        } else if (female.isChecked()) {
                            tvGenderEr.setVisibility(View.GONE);
                            tvGenderEr.setError(null);
                            gender = female.getText().toString();
                        }
                        if(emp.isChecked()){
                            tvStatusEr.setVisibility(View.GONE);
                            tvStatusEr.setError(null);
                            status = emp.getText().toString();
                        }else if(unemp.isChecked()){
                            tvStatusEr.setVisibility(View.GONE);
                            tvStatusEr.setError(null);
                            status = unemp.getText().toString();
                        }
                    }
                }

                if (first_name.length() == 0 || last_Name.length() == 0 || phone_No.length() == 0 || e_mail.length() == 0 || isSelected_Gender == -1 || isSelected_Status == -1 || high_Qualification.getSelectedItemPosition() == 0 || !first_name.matches("[a-zA-Z ]+") || !last_Name.matches("[a-zA-Z ]+") || phone_No.length()!=10 || !e_mail.matches(emailPattern)) {
                    if (first_name.length() == 0) {
                        firstName.requestFocus();
                        firstName.setError("FIELD CANNOT BE EMPTY");
                    } else if (first_name.length() != 0 && !first_name.matches("[a-zA-Z]+")) {
                        firstName.requestFocus();
                        firstName.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                    }
                    if (last_Name.length() == 0) {
                        lastName.requestFocus();
                        lastName.setError("FIELD CANNOT BE EMPTY");
                    } else if (last_Name.length() != 0 && !last_Name.matches("[a-zA-Z ]+")) {
                        lastName.requestFocus();
                        lastName.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                    }
                    if (phone_No.length() == 0) {
                        phoneNo.requestFocus();
                        phoneNo.setError("FIELD CANNOT BE EMPTY");
                    } else if (phone_No.length() != 10) {
                        phoneNo.requestFocus();
                        phoneNo.setError("ENTER 10 DIGIT PHONE NO");
                    }
                    if (e_mail.length() == 0) {
                        email.requestFocus();
                        email.setError("FIELD CANNOT BE EMPTY");
                    } else if (!e_mail.matches(emailPattern) && e_mail.length() > 0) {
                        email.requestFocus();
                        email.setError("ENTER VALID EMAIL");
                    }
                    if (isSelected_Gender == -1) {
                        tvGenderEr.setVisibility(View.VISIBLE);
                        tvGenderEr.setError("SELECT GENDER");
                        male.setOnCheckedChangeListener(new Radio_check());
//                        female.setOnCheckedChangeListener(new Radio_check());

                    }
                    if (isSelected_Gender == -1) {
                        tvGenderEr.setVisibility(View.VISIBLE);
                        tvGenderEr.setError("SELECT GENDER");
//                        male.setOnCheckedChangeListener(new Radio_check());
                        female.setOnCheckedChangeListener(new Radio_check());

                    }
                    if (isSelected_Status == -1) {
                        tvStatusEr.setVisibility(View.VISIBLE);
                        tvStatusEr.setError("SELECT STATUS");
                        emp.setOnCheckedChangeListener(new Radio_check());
//                        unemp.setOnCheckedChangeListener(new Radio_check());
                    }
                    if (isSelected_Status == -1) {
                        tvStatusEr.setVisibility(View.VISIBLE);
                        tvStatusEr.setError("SELECT STATUS");
//                        emp.setOnCheckedChangeListener(new Radio_check());
                        unemp.setOnCheckedChangeListener(new Radio_check());
                    }
                    if (high_Qualification.getSelectedItemPosition() > 0) {
                        // get selected item value
                        String itemvalue = String.valueOf(high_Qualification.getSelectedItem());
                    } else {
                        // set error message on spinner
                        TextView errorTextview = (TextView) high_Qualification.getSelectedView();
                        errorTextview.setError("Select Qualification");
                    }
                } else {
                    if (male.isChecked()) {
                        gender = male.getText().toString();
                        System.out.println(gender);
                    } else if (female.isChecked()) {
                        gender = female.getText().toString();
                    }
                    if (emp.isChecked()) {
                        status = emp.getText().toString();
                    } else if (unemp.isChecked()) {
                        status = unemp.getText().toString();
                    }
                /*
                    str = ("First Name      " + first_name + "\n" + "Last Name      " + last_Name + "\n" + "Gender            " + gender + "\n" + "Status             " + status + " \n" + "Qualification  " + high_Qualify + " \n" + "Moile No        " + phone_No + " \n" + "Email              " + e_mail);
                    tv.setText(gender);
                    System.out.println(gender+" "+status+" "+high_Qualify);
                */
//                    MyData myData = new MyData(first_name,last_Name,gender,status,high_Qualify,phone_No,e_mail);
                /*
                    Bundle bundle = new Bundle();
                    bundle.putString("First Name",first_name);
                    bundle.putString("Last Name",last_Name);
                    bundle.putString("Gender",gender);
                    bundle.putString("Status",status);
                    bundle.putString("Qualification",high_Qualify );
                    bundle.putString("Mobile No",phone_No);
                    bundle.putString("Email",e_mail);
                    Intent intent = new Intent(getApplicationContext(), List.class);
                    intent.putExtras(bundle);

//                    intent.putExtra("MyData", myData);
                    startActivity(intent);
                 */
                    if(getIntent().getExtras() != null ) {
                        if (male.isChecked()) {
                            gender = male.getText().toString();
                            System.out.println(gender);
                        } else if (female.isChecked()) {
                            gender = female.getText().toString();
                        }
                        if (emp.isChecked()) {
                            status = emp.getText().toString();
                        } else if (unemp.isChecked()) {
                            status = unemp.getText().toString();
                        }

                        System.out.println("-----------HEllo------------");
                        System.out.println(posti);
                        System.out.println(AppConstant.mydatas.size());

                        MyData data = new MyData(firstName.getText().toString(),lastName.getText().toString(),gender,status,high_Qualify,phoneNo.getText().toString(),email.getText().toString());
                        AppConstant.mydatas.set(posti,data);
                        finish();
                    } else {
                        AppConstant.mydatas.add(new MyData(first_name, last_Name,gender,status,high_Qualify,phone_No, e_mail));
                        finish();
                   }
                }
            }

//                str = ("First Name      "+first_name+"\n" +"Last Name      "+last_Name+"\n"+"Gender            "+gender+"\n"+"Status             "+status+" \n"+"Qualification  "+high_Qualify+" \n"+"Moile No        "+phone_No+" \n"+"Email              "+e_mail);
//                tv.setText(str);
//
//                Intent intent = new Intent(getApplicationContext(),Display.class);
//                intent.putExtra("message_key",str);
//                startActivity(intent);


        });
    }
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    high_Qualify = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
