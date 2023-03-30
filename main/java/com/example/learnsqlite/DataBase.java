package com.example.learnsqlite;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.deleteDatabase;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;

public class DataBase extends SQLiteOpenHelper {
    SQLiteDatabase database;

    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void doCreateDb() {
        database = openOrCreateDatabase("qlsinhvien.db",MODE_PRIVATE,null);
        database = SQLiteDatabase.openDatabase("qlsinhvien.db", null, SQLiteDatabase.CREATE_IF_NECESSARY);
    }


    public void doDeleteDb() {
        String msg = "";
        if (deleteDatabase(new File("qlsinhvien.db")) == true) {
            msg = "Delete Database [qlsinhvien.db] is succesful";
        } else {
            msg = "Delete Database [qlsinhvien.db] is failed";
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void doCreateLopTable() {
        String sql = "CREATE TABLE tbllop (";
        sql += "malop TEXT primary key,";
        sql += "tenlop TEXT,";
        sql += "siso INTEGER)";
        database.execSQL(sql);
    }

    public void doCreateSinhvienTable() {
        String sql = "CREATE TABLE tblsinhvien (" + "masv TEXT primary key," + "tensv TEXT," + "malop TEXT NOT NULL CONSTRAINT malop" + "REFERENCES tbllop (malop) ON DELETE CASCADE";
        database.execSQL(sql);
    }

    public void doInsertRecord() {
        ContentValues values = new ContentValues();
        values.put("malop", "DHTH7C");
        values.put("tenlop", "Dai Hoc 7C");
        values.put("siso", 30);
        String msg = "";
        if (database.insert("tbllop", null, values) == -1) {
            msg = "Failed to insert record";
        } else {
            msg = "Inserted record successful";
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void updateLopName(String malop, String new_tenlop) {
        ContentValues values = new ContentValues();
        values.put("tenlop", new_tenlop);
        int ret = database.update("tbllop", values, "malop=?", new String[]{malop});
        if (ret == 0) {
            //failed
        } else {
            //ok
        }
    }

    public void deleteAllRow() {
        database.delete("tbllop", null, null);
    }

    public void deleteSpecificRow() {
        String malop = new String(String.valueOf(System.in));
        database.delete("tbllop", "malop=?", new String[]{malop});
    }

    public void loadAllLop() {
        Cursor c = database.query("tbllop", null, null, null, null, null, null);
        c.moveToFirst();
        String data = "";
        while (c.isAfterLast() == false) {
            data += c.getString(0) + "-" + c.getString(1) + "-" + c.getString(2);
            data += "\n";
            c.moveToNext();
        }
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        c.close();
    }
}

