package com.example.attiq.cnicportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by attiq on 1/26/2018.
 */

public class Register extends Activity {

    Button done;
    DatabaseHelper databaseHelper;

    EditText etName,etFname,etGender,etCoutry, etReligion, etDOB;
    String name, fName, gender, country, religion, dob ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        etName = (EditText) findViewById(R.id.etName);
        etFname = (EditText) findViewById(R.id.etFname);
        etGender = (EditText) findViewById(R.id.etGender);
        etCoutry = (EditText) findViewById(R.id.etCountry);
        etReligion = (EditText) findViewById(R.id.etReligion);
        etDOB = (EditText)findViewById(R.id.etDOB);

        done = (Button) findViewById(R.id.btnDone);

        databaseHelper = new DatabaseHelper(this);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                fName = etFname.getText().toString();
                gender = etGender.getText().toString();
                country = etCoutry.getText().toString();
                religion = etReligion.getText().toString();
                dob = etDOB.getText().toString();

                //Toast.makeText(MainActivity.this,name, Toast.LENGTH_SHORT).show();

                if (name.isEmpty() && fName.isEmpty() && gender.isEmpty() && country.isEmpty() && religion.isEmpty()
                        && dob.isEmpty()) {

                    Toast.makeText(Register.this, "please fill details", Toast.LENGTH_SHORT).show();
                } else {

                    databaseHelper.insertdata(name, fName, gender, country, religion, dob);
                    etName.setText("");
                    etFname.setText("");
                    etGender.setText("");
                    etCoutry.setText("");
                    etReligion.setText("");
                    etDOB.setText("");

                    Intent intent = new Intent(Register.this, ViewAll.class);
                    startActivity(intent);

                }

            }
        });

    }
}
