package com.ru.min.sportquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.ru.min.sportquiz.database.AppDatabase;
import com.ru.min.sportquiz.user.User;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db = Room.databaseBuilder(getApplicationContext(),
            AppDatabase.class, "users").build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db.userDao().insert(new User("Marsel"));
    }
    /*public void onClick(View view){
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }*/

    public void onClickStartGameEasy(View view) {
        Intent intent = new Intent(MainActivity.this, GameActivityEasy.class);
        startActivity(intent);
    }

    public void onClickStartGameMedium(View view) {
        Intent intent = new Intent(MainActivity.this, GameActivityMedium.class);
        startActivity(intent);
    }

    public void onClickStartGameHard(View view) {
        Intent intent = new Intent(MainActivity.this, GameActivityHard.class);
        startActivity(intent);
    }
}
