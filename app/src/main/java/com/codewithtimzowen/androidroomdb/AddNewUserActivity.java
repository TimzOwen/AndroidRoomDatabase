package com.codewithtimzowen.androidroomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codewithtimzowen.androidroomdb.database.AppDatabase;
import com.codewithtimzowen.androidroomdb.database.User;

public class AddNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        final EditText first_name = findViewById(R.id.etFName);
        final EditText last_name = findViewById(R.id.etLName);
        Button btnSave = findViewById(R.id.btnSaveUser);

        btnSave.setOnClickListener(v -> {

            saveNewUser(first_name.getText().toString(), last_name.getText().toString());

        });
    }

    //save data to the database
    public void saveNewUser(String first_name, String last_name){

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.firstName = first_name;
        user.lastName = last_name;

        db.userDao().insertUser();
        finish();
    }
}