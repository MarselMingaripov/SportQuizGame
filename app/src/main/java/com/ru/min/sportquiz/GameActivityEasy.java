package com.ru.min.sportquiz;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.ru.min.sportquiz.database.AddUserActivity;
import com.ru.min.sportquiz.database.AppDatabase;
import com.ru.min.sportquiz.database.DatabaseClient;
import com.ru.min.sportquiz.question.Level;
import com.ru.min.sportquiz.question.Question;
import com.ru.min.sportquiz.question.QuestionPool;
import com.ru.min.sportquiz.user.User;

import java.util.List;
import java.util.Locale;

public class GameActivityEasy extends AppCompatActivity {

    private CountDownTimer mCountDownTimer;
    private long mTimeLeftInMillis;
    private TextView mTextView;

    private String name;

    private QuestionPool questionPool = new QuestionPool();

    private User user;
    private Button button;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;

    private TextView textViewCorrectOrNot;

    public void play() {
        //user = db.userDao().getUserByName("Marsel");
        try {
        Question question = questionPool.getQuestion(Level.EASY);
            TextView textView = findViewById(R.id.textViewQuestion);
            textView.setText(question.getText());

            textViewCorrectOrNot = findViewById(R.id.textViewCorrectOrNot);

            TextView textViewScore = findViewById(R.id.textViewScore);
            textViewScore.setText(user.getScore() + "");
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
                            radioButton2.setClickable(false);
                            radioButton3.setClickable(false);
                            radioButton4.setClickable(false);
                            if (questionPool.checkCorrectAnswer(question, radioButton1.getText().toString())) {
                                textViewCorrectOrNot.setText("Верно!");
                                int score = Integer.parseInt((String) textViewScore.getText());
                                score++;
                                user.setScore(score);
                                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                                        .userDao()
                                        .update(user);
                            } else {
                                textViewCorrectOrNot.setText("Неверно!");
                            }
                            break;
                        case R.id.radioButton4:
                            radioButton2.setClickable(false);
                            radioButton3.setClickable(false);
                            radioButton1.setClickable(false);
                            if (questionPool.checkCorrectAnswer(question, radioButton4.getText().toString())) {
                                textViewCorrectOrNot.setText("Верно!");
                                int score = Integer.parseInt((String) textViewScore.getText());
                                score++;
                                user.setScore(score);
                                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                                        .userDao()
                                        .update(user);
                            } else {
                                textViewCorrectOrNot.setText("Неверно!");
                            }
                            break;
                        case R.id.radioButton2:
                            radioButton1.setClickable(false);
                            radioButton3.setClickable(false);
                            radioButton4.setClickable(false);
                            if (questionPool.checkCorrectAnswer(question, radioButton2.getText().toString())) {
                                textViewCorrectOrNot.setText("Верно!");
                                int score = Integer.parseInt((String) textViewScore.getText());
                                score++;
                                user.setScore(score);
                                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                                        .userDao()
                                        .update(user);
                            } else {
                                textViewCorrectOrNot.setText("Неверно!");
                            }
                            break;
                        case R.id.radioButton3:
                            radioButton1.setClickable(false);
                            radioButton2.setClickable(false);
                            radioButton4.setClickable(false);
                            if (questionPool.checkCorrectAnswer(question, radioButton3.getText().toString())) {
                                textViewCorrectOrNot.setText("Верно!");
                                int score = Integer.parseInt((String) textViewScore.getText());
                                score++;
                                user.setScore(score);
                                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                                        .userDao()
                                        .update(user);
                            } else {
                                textViewCorrectOrNot.setText("Неверно!");
                            }
                            break;
                    }
                }
            });
        } catch (IllegalArgumentException e) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            Toast.makeText(getApplicationContext(), "Вы ответили на все вопросы!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void onClickNext(View view) {
        radioGroup.clearCheck();
        radioButton2.setClickable(true);
        radioButton3.setClickable(true);
        radioButton4.setClickable(true);
        radioButton1.setClickable(true);
        textViewCorrectOrNot.setText("");
        List<User> users = DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                .userDao()
                .getUsers();
        users.stream().forEach(System.out::println);
        play();

    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(getApplicationContext(), "Простите, время вышло", Toast.LENGTH_LONG).show();
            }
        }.start();
    }

    private void updateTimer() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextView = findViewById(R.id.textViewTimer);
        mTextView.setText(timeLeftFormatted);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTimeLeftInMillis = 60000;
        startTimer();
        setContentView(R.layout.activity_game_easy);
        name = getIntent().getExtras().getString("name");
        user = DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                .userDao()
                .getUserByName(name);

            play();

    }
}
