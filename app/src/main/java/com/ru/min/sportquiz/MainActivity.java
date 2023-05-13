package com.ru.min.sportquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ru.min.sportquiz.database.AddUserActivity;
import com.ru.min.sportquiz.database.DatabaseClient;
import com.ru.min.sportquiz.user.CurrentUser;
import com.ru.min.sportquiz.user.User;

public class MainActivity extends AppCompatActivity {

    //String name = "";
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
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_add_user);
        //name = getIntent().getExtras().getString("name");
    }



    /*public void onClickStartGameEasy(View view) {
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra("level", "easy");
        intent.putExtra("name", name);
        startActivity(intent);
    }

    public void onClickStartGameMedium(View view) {
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra("level", "medium");
        intent.putExtra("name", name);
        startActivity(intent);
    }

    public void onClickStartGameHard(View view) {
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra("level", "hard");
        intent.putExtra("name", name);
        startActivity(intent);
    }*/
}
