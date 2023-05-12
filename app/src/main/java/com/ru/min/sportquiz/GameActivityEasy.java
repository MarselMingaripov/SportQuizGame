package com.ru.min.sportquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.ru.min.sportquiz.database.AppDatabase;
import com.ru.min.sportquiz.question.Level;
import com.ru.min.sportquiz.question.Question;
import com.ru.min.sportquiz.question.QuestionPool;
import com.ru.min.sportquiz.user.User;

public class GameActivityEasy extends AppCompatActivity {

    /*private AppDatabase db = Room.databaseBuilder(getApplicationContext(),
            AppDatabase.class, "users").build();*/
    private User user;

    private QuestionPool questionPool = new QuestionPool();


    private Button button;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;

    public void play() {
        //user = db.userDao().getUserByName("Marsel");
        Question question = questionPool.getQuestion(Level.EASY);

        TextView textView = findViewById(R.id.textViewQuestion);
        textView.setText(question.getText());

        TextView textViewCorrectOrNot = findViewById(R.id.textViewCorrectOrNot);

        TextView textViewScore = findViewById(R.id.textViewScore);
        textViewScore.setText("0");
        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton1.setText(question.getWrongAnswerOne());
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton2.setText(question.getWrongAnswerTwo());
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton3.setText(question.getWrongAnswerThree());
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton4.setText(question.getWrongAnswerFour());

        button = findViewById(R.id.buttonNext);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        if (questionPool.checkCorrectAnswer(question, radioButton1.getText().toString())) {
                            textViewCorrectOrNot.setText("Верно!");
                            int score = Integer.parseInt((String) textViewScore.getText());
                            score++;
                            /*user.setScore(score);
                            userDAO.insertUser(user);*/
                            textViewScore.setText(score + "");
                        } else {
                            textViewCorrectOrNot.setText("Неверно!");
                        }
                        break;
                    case R.id.radioButton4:
                        if (questionPool.checkCorrectAnswer(question, radioButton4.getText().toString())) {
                            textViewCorrectOrNot.setText("Верно!");
                            int score = Integer.parseInt((String) textViewScore.getText());
                            /*user.setScore(score);
                            userDAO.insertUser(user);*/
                            score++;
                            textViewScore.setText(score + "");
                        } else {
                            textViewCorrectOrNot.setText("Неверно!");
                        }
                        break;
                    case R.id.radioButton2:
                        if (questionPool.checkCorrectAnswer(question, radioButton2.getText().toString())) {
                            textViewCorrectOrNot.setText("Верно!");
                            int score = Integer.parseInt((String) textViewScore.getText());
                            /*user.setScore(score);
                            userDAO.insertUser(user);*/
                            score++;
                            textViewScore.setText(score + "");
                        } else {
                            textViewCorrectOrNot.setText("Неверно!");
                        }
                        break;
                    case R.id.radioButton3:
                        if (questionPool.checkCorrectAnswer(question, radioButton3.getText().toString())) {
                            textViewCorrectOrNot.setText("Верно!");
                            int score = Integer.parseInt((String) textViewScore.getText());
                            /*user.setScore(score);
                            userDAO.insertUser(user);*/
                            score++;
                            textViewScore.setText(score + "");
                        } else {
                            textViewCorrectOrNot.setText("Неверно!");
                        }
                        break;
                }
            }
        });
    }

    public void onClickNext(View view) {
        Intent intent = new Intent(GameActivityEasy.this, GameActivityEasy.class);
        startActivity(intent);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_easy);
        play();

    }
}
