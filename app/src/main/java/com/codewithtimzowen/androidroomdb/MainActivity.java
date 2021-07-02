package com.codewithtimzowen.androidroomdb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.codewithtimzowen.androidroomdb.database.AppDatabase;
import com.codewithtimzowen.androidroomdb.database.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private USerListAdapter uSerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAddUser = findViewById(R.id.btnAddNewUSer);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AddNewUserActivity.class));
            }
        });

        initRecyclerView();

        loadUserList();
    }

    public void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration decoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);

        uSerListAdapter = new USerListAdapter(this);
        recyclerView.setAdapter(uSerListAdapter);


    }

    public void loadUserList(){

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<User> userList = db.userDao().getAllUsers();
        uSerListAdapter.setUserList(userList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 100){
            loadUserList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}