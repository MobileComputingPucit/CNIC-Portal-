package com.example.attiq.cnicportal;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csa on 3/1/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public static String DATABASE = "database.db";
    public static String TABLE ="mytable";
    public static final String NAME ="name";
    public static final String FATHERNAME ="fatherName";
    public static final String COUNTRY ="country";
    public static final String GENDER ="gender";
    public static final String RELIGION ="religion";
    public static final String DOB ="dob";


    String br;

    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

         //  br= "CREATE TABLE mytable(name TEXT,company TEXT,city TEXT,country TEXT);";


         br = "CREATE TABLE "+TABLE+"(" +NAME+ " Text, "+FATHERNAME+ " Text, "+GENDER+ " Text, "+COUNTRY+ " Text, "+RELIGION+ " Text, "+DOB+ " Text);";
        db.execSQL(br);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS "+TABLE+" ;");
    }


    public void insertdata(String name,String fatherName ,String gender,String country, String religion, String dob){
        System.out.print("Hello "+br);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();


            contentValues.put(NAME, name);
            contentValues.put(FATHERNAME, fatherName);
            contentValues.put(GENDER, gender);
            contentValues.put(COUNTRY, country);
            contentValues.put(RELIGION, religion);
            contentValues.put(DOB, dob);
            db.insert(TABLE,null,contentValues);


    }

    public boolean delete_row(String email) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE, NAME + "=" + email, null);
        db.close();
        return false;
    }

    public List<DataModel> getdata(){
       // DataModel dataModel = new DataModel();
        List<DataModel> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE+" ;",null);

        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null; 

        while (cursor.moveToNext()) {
            dataModel= new DataModel();

            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String fatherName = cursor.getString(cursor.getColumnIndexOrThrow("fatherName"));
            String gender = cursor.getString(cursor.getColumnIndexOrThrow("gender"));
            String country = cursor.getString(cursor.getColumnIndexOrThrow("country"));
            String religion = cursor.getString(cursor.getColumnIndexOrThrow("religion"));
            String dob = cursor.getString(cursor.getColumnIndexOrThrow("dob"));


            dataModel.setName(name);
            dataModel.setFatherName(fatherName);
            dataModel.setGender(gender);
            dataModel.setCountry(country);
            dataModel.setReligion(religion);
            dataModel.setDOB(dob);

            stringBuffer.append(dataModel);

            // stringBuffer.append(dataModel);
            data.add(dataModel);
        }

        //For Testing Purpose

        for (DataModel mo:data ) {

            Log.i("Hellomo",""+mo.getName());
        }

        //

        return data;
    }

}
