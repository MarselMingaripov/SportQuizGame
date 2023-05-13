package com.ru.min.sportquiz.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ru.min.sportquiz.database.AddUserActivity;
import com.ru.min.sportquiz.user.CurrentUser;
import com.ru.min.sportquiz.user.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User currentUser = CurrentUser.getInstance().getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(MainActivity.this, ChooseLevelActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
            startActivity(intent);
        }
    }
}
