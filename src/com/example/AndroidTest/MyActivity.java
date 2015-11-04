package com.example.AndroidTest;

import android.app.Activity;
import android.os.Bundle;
import com.example.AndroidTest.SQLConnection.SQLConnection;

import java.sql.SQLException;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        dataBaseTest();
    }


    public void dataBaseTest () {
        SQLConnection sqlConnection = new SQLConnection(MyActivity.this);
        try {
            sqlConnection.createDatabaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
