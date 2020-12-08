package com.example.funds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class donor_signin extends AppCompatActivity {
    SQLiteDatabase db;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_sign_in);
        db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
        Button btInsert = (Button) findViewById(R.id.button6);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f2();
            }
        });
    }
    private void f2()
    {
        final Dialog d = new Dialog(this);
        d.setContentView(R.layout.activity_donor_sign_in);
        EditText user = (EditText) findViewById(R.id.username);
        EditText pass = (EditText) findViewById(R.id.password);
        String username = user.getText().toString().trim();
        String password = pass.getText().toString().trim();
        String username1=username;
        Cursor c = db.rawQuery("SELECT * FROM Donors1 where email='"+username+"' and password1='"+password+"'", null);
        result=c.getCount();
        if (result>0)
        {
            Intent intent2= new Intent(this,donarDashboard.class);
            intent2.putExtra("user_id",username1);
            startActivity(intent2);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Invalid Username or Password",Toast.LENGTH_SHORT).show();
        }
    }
    public void dSignup(View view) {

        final Dialog d = new Dialog(this);
        createDB();
        createTable();
        d.setContentView(R.layout.layout_donar_signup);
        d.setTitle("Insert Data");
        final EditText firstname = (EditText) d.findViewById(R.id.fname);
        final EditText lastname = (EditText) d.findViewById(R.id.lname);
        final EditText demailadd = (EditText) d.findViewById(R.id.demail);
        final EditText dmobile = (EditText) d.findViewById(R.id.dmob);
        final EditText daddress = (EditText) d.findViewById(R.id.dadd);
        final EditText dpassword1 = (EditText) d.findViewById(R.id.pass1);
        final EditText dpassword2 = (EditText) d.findViewById(R.id.pass2);
        Button dsignup = (Button) d.findViewById(R.id.dsignup);

        dsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = firstname.getText().toString().trim();
                String lname = lastname.getText().toString().trim();
                String dmob = dmobile.getText().toString().trim();
                String demail = demailadd.getText().toString().trim();
                String dadd = daddress.getText().toString().trim();
                String pass1 = dpassword1.getText().toString().trim();
                String pass2 = dpassword2.getText().toString().trim();

                if (fname.length() == 0 || lname.length() == 0 || dadd.length() == 0 || pass1.length() == 0 || pass2.length() == 0 || dadd.length()==0||dmob.length()==0) {

                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(!fname.matches("[A-Z][a-zA-Z]*" )&&!fname.matches("[a-z][a-za-z]*" ))
                {
                    Toast.makeText(getApplicationContext(), "Invalid First Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(!lname.matches("[A-Z][a-zA-Z]*" )&&!lname.matches("[a-z][a-za-z]*" ))
                {
                    Toast.makeText(getApplicationContext(), "Invalid Last Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(!demail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
                {
                    Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(dmob.length()!=10)
                {
                    Toast.makeText(getApplicationContext(), "Mobile Number should be 10 digits", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(pass1.length()<6)
                {
                    Toast.makeText(getApplicationContext(), "Password should be 6 digit or more", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (!pass1.contentEquals(pass2)) {
                    Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {

                    Cursor c = db.rawQuery("SELECT * FROM Donors1 where email='"+demail+"'", null);
                    int result1 = c.getCount();
                    if (result1 > 0) {
                        Toast.makeText(getBaseContext(), "This Email is already registered with us", Toast.LENGTH_SHORT).show();
                        return;
                    } else {


                        String query = "INSERT INTO Donors1 values('" + fname + "','" + lname + "','" + dmob + "','" + demail + "','" + dadd + "','" + pass1 + "','" + pass2 + "')";

                        db.execSQL(query);

                        Toast.makeText(getBaseContext(), "Registration Completed! Please Sign In", Toast.LENGTH_SHORT).show();
                        d.dismiss();
                    }
                }
            }
        });
        d.show();
    }

    private void createTable() {
        db.execSQL("CREATE TABLE IF NOT EXISTS Donors1(firstname varchar, lastname varchar, mobile varchar, email varchar, address varchar, password1 varchar, password2 varchar)");

    }

    public void f30(View view)
    {
        Intent intent = new Intent(this, forgot_password.class);
        startActivity(intent);
    }
    private void createDB() {
        db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
    }
}