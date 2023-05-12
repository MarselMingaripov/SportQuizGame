package com.ru.min.sportquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.ru.min.sportquiz.database.AddUserActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStartGameEasy(View view) {
        Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
        intent.putExtra("com.ru.min.sportquiz.level", "GameActivityEasy");
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

    /*public void onClickAddName(View view) {
        Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
        startActivity(intent);
    }*/
}
