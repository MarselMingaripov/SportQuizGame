package com.ru.min.sportquiz.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ru.min.sportquiz.ChooseLevelActivity;
import com.ru.min.sportquiz.GameActivity;
import com.ru.min.sportquiz.MainActivity;
import com.ru.min.sportquiz.R;
import com.ru.min.sportquiz.user.CurrentUser;
import com.ru.min.sportquiz.user.User;

public class AddUserActivity extends AppCompatActivity {

    private EditText editText;
    private User user;
    //private String level;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        //level = getIntent().getExtras().getString("com.ru.min.sportquiz.level");
        editText = findViewById(R.id.editTextName);

        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser();

            }
        });
    }

    private void saveUser() {
        final String NAME = editText.getText().toString().trim();

        if (NAME.isEmpty()) {
            return;
        }

        @SuppressLint("StaticFieldLeak")
        class SaveUser extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                if (DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .userDao()
                        .getUserByName(NAME) != null) {
                    user = DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                            .userDao()
                            .getUserByName(NAME);
                    CurrentUser.getInstance().setCurrentUser(user);
                } else {
                    user = new User(NAME);
                    DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                            .userDao()
                            .insert(user);
                    CurrentUser.getInstance().setCurrentUser(user);
                    return null;
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                //finish();
                //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(getApplicationContext(), "Вход", Toast.LENGTH_LONG).show();
            }
        }

        SaveUser su = new SaveUser();
        su.execute();
        Intent intent = new Intent(AddUserActivity.this, ChooseLevelActivity.class);
        intent.putExtra("name", NAME);
        startActivity(intent);
        /*switch (level) {
            case ("GameActivityEasy"): {
                Intent intent = new Intent(AddUserActivity.this, GameActivity.class);
                intent.putExtra("name", NAME);
                intent.putExtra("level", "easy");
                startActivity(intent);
                break;
            }
            case ("GameActivityMedium"): {
                Intent intent = new Intent(AddUserActivity.this, GameActivity.class);
                intent.putExtra("name", NAME);
                intent.putExtra("level", "medium");
                startActivity(intent);
                break;
            }
            case ("GameActivityHard"): {
                Intent intent = new Intent(AddUserActivity.this, GameActivity.class);
                intent.putExtra("name", NAME);
                intent.putExtra("level", "hard");
                startActivity(intent);
                break;
            }
        }*/
    }
}
