package com.ru.min.sportquiz.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.ru.min.sportquiz.R;
import com.ru.min.sportquiz.database.DatabaseClient;
import com.ru.min.sportquiz.user.CurrentUser;
import com.ru.min.sportquiz.user.User;

public class ChooseLevelActivity extends AppCompatActivity {

    String name = "";
    TextView textViewScore;

    ConstraintLayout back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);
        back = findViewById(R.id.back);
        User user = CurrentUser.getInstance().getCurrentUser();
        System.out.println(DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                .userDao()
                .getUserByName(CurrentUser.getInstance().getCurrentUser().getName()));
        switch (user.getActualWallpaper()){
            case 1:{
                back.setBackgroundResource(R.drawable.back1);
                break;
            }
            case 2:{
                back.setBackgroundResource(R.drawable.back2);
                break;
            }
            case 3:{
                back.setBackgroundResource(R.drawable.back3);
                break;
            }
            case 4:{
                back.setBackgroundResource(R.drawable.back4);
                break;
            }
            case 5:{
                back.setBackgroundResource(R.drawable.back5);
                break;
            }
        }
        name = user.getName();
        textViewScore = findViewById(R.id.textViewScore);
        textViewScore.setText(user.getScore() + "");
    }

    @Override
    protected void onResume() {
        super.onResume();
        User user = CurrentUser.getInstance().getCurrentUser();
        textViewScore = findViewById(R.id.textViewScore);
        textViewScore.setText(user.getScore() + "");
        back = findViewById(R.id.back);
        switch (user.getActualWallpaper()){
            case 1:{
                back.setBackgroundResource(R.drawable.back1);
                break;
            }
            case 2:{
                back.setBackgroundResource(R.drawable.back2);
                break;
            }
            case 3:{
                back.setBackgroundResource(R.drawable.back3);
                break;
            }
            case 4:{
                back.setBackgroundResource(R.drawable.back4);
                break;
            }
            case 5:{
                back.setBackgroundResource(R.drawable.back5);
                break;
            }
        }
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


    public void onClickBuy(View view) {
        Intent intent = new Intent(ChooseLevelActivity.this, ShopActivity.class);
        startActivity(intent);
    }
}
