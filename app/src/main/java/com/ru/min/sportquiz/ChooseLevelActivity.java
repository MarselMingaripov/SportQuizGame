package com.ru.min.sportquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ru.min.sportquiz.database.DatabaseClient;
import com.ru.min.sportquiz.user.CurrentUser;
import com.ru.min.sportquiz.user.User;

public class ChooseLevelActivity extends AppCompatActivity {

    String name = "";
    TextView textViewScore;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User user = CurrentUser.getInstance().getCurrentUser();
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_choose_level);
        //name = getIntent().getExtras().getString("name");
        name = user.getName();
        textViewScore = findViewById(R.id.textViewScore);
        textViewScore.setText(user.getScore() + "");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // получаем объект пользователя из базы данных
        User user = DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                .userDao()
                .getUserByName(CurrentUser.getInstance().getCurrentUser().getName());
        // обновляем TextView
        textViewScore = findViewById(R.id.textViewScore);
        textViewScore.setText(user.getScore() + "");
    }

    public void onClickStartGameEasy(View view) {
        Intent intent = new Intent(ChooseLevelActivity.this, GameActivity.class);
        intent.putExtra("level", "easy");
        intent.putExtra("name", name);
        startActivity(intent);
    }

    public void onClickStartGameMedium(View view) {
        Intent intent = new Intent(ChooseLevelActivity.this, GameActivity.class);
        intent.putExtra("level", "medium");
        intent.putExtra("name", name);
        startActivity(intent);
    }

    public void onClickStartGameHard(View view) {
        Intent intent = new Intent(ChooseLevelActivity.this, GameActivity.class);
        intent.putExtra("level", "hard");
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
