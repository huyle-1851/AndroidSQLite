package com.example.learnsqlite;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    // Khai bao bien giao dien
    Button createDb, delDb, createTbl, delTbl, insRow, delRow, updateRow, queryData, insStd, querySV;
    EditText delTable, insertStudent;
    ListView lv;
    DataBase database;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDb = findViewById(R.id.createDb);
        delDb = findViewById(R.id.delDb);
        createTbl = findViewById(R.id.createTbl);
        delTbl = findViewById(R.id.delTbl);
        delTable = findViewById(R.id.delTable);
        insRow = findViewById(R.id.insRow);
        delRow = findViewById(R.id.delRow);
        updateRow = findViewById(R.id.updateRow);
        queryData = findViewById(R.id.queryData);
        insStd = findViewById(R.id.insStd);
        querySV = findViewById(R.id.querySV);
        delTable = findViewById(R.id.delTable);
        insertStudent = findViewById(R.id.insStudent);
//Tao database
        createDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.doCreateDb();
            }
        });
        delDb.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         database.doDeleteDb();
                                     }
                                 }
        );
        createTbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.doCreateLopTable();
                database.doCreateSinhvienTable();
            }
        });
        delTable.getText();
        delTbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
}
        });
        insRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.doInsertRecord();
            }
        });
        updateRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.updateLopName(null,null);
            }
        });
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.loadAllLop();
            }
        });
        delTable.getText();
        delTbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.deleteSpecificRow();
            }
        });
    }
}