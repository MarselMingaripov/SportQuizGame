package com.ru.min.sportquiz;

import static com.ru.min.sportquiz.R.drawable.back1;
import static com.ru.min.sportquiz.R.drawable.back2;
import static com.ru.min.sportquiz.R.drawable.back3;
import static com.ru.min.sportquiz.R.drawable.back4;
import static com.ru.min.sportquiz.R.drawable.back5;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ru.min.sportquiz.database.DatabaseClient;
import com.ru.min.sportquiz.user.CurrentUser;
import com.ru.min.sportquiz.user.User;

public class ShopActivity extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    TextView textView;
    int resourceId1 = back1;
    int resourceId2 = back2;
    int resourceId3 = back3;
    int resourceId4 = back4;
    int resourceId5 = back5;
    private User user;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        user = CurrentUser.getInstance().getCurrentUser();
        imageView1 = findViewById(R.id.wallpaper1);
        imageView2 = findViewById(R.id.wallpaper2);
        imageView3 = findViewById(R.id.wallpaper3);
        imageView4 = findViewById(R.id.wallpaper4);
        imageView5 = findViewById(R.id.wallpaper5);

        textView = findViewById(R.id.textViewScoreInShop);
        textView.setText(user.getScore() + "");
        System.out.println(user.toString());

        Glide.with(this)
                .load(resourceId1)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(back1)
                .into(imageView1);
        Glide.with(this)
                .load(resourceId2)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(back2)
                .into(imageView2);
        Glide.with(this)
                .load(resourceId3)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(back3)
                .into(imageView3);
        Glide.with(this)
                .load(resourceId4)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(back4)
                .into(imageView4);
        Glide.with(this)
                .load(resourceId5)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(back5)
                .into(imageView5);
    }

    @Override
    protected void onResume() {
        super.onResume();
        User user = CurrentUser.getInstance().getCurrentUser();
        textView = findViewById(R.id.textViewScoreInShop);
        textView.setText(user.getScore() + "");
    }


    public void change_01(View view) {
        if (user.getScore() > 9){
        /*FragmentManager fm = getSupportFragmentManager();
        ShopDialogFragment dialogFragment = new ShopDialogFragment();
        dialogFragment.show(fm, "dialog");*/
            showMyDialog(1);
        } else {
            Toast.makeText(getApplicationContext(), "Покупка стоит 10 очков", Toast.LENGTH_LONG).show();
        }
    }

    public void change_02(View view) {
        if (user.getScore() > 9){
        /*FragmentManager fm = getSupportFragmentManager();
        ShopDialogFragment dialogFragment = new ShopDialogFragment();
        dialogFragment.show(fm, "dialog");*/
            showMyDialog(2);
        } else {
            Toast.makeText(getApplicationContext(), "Покупка стоит 10 очков", Toast.LENGTH_LONG).show();
        }
    }

    public void change_03(View view) {
        if (user.getScore() > 9){
        /*FragmentManager fm = getSupportFragmentManager();
        ShopDialogFragment dialogFragment = new ShopDialogFragment();
        dialogFragment.show(fm, "dialog");*/
            showMyDialog(3);
        } else {
            Toast.makeText(getApplicationContext(), "Покупка стоит 10 очков", Toast.LENGTH_LONG).show();
        }
    }

    public void change_04(View view) {
        if (user.getScore() > 9){
        /*FragmentManager fm = getSupportFragmentManager();
        ShopDialogFragment dialogFragment = new ShopDialogFragment();
        dialogFragment.show(fm, "dialog");*/
            showMyDialog(4);
        } else {
            Toast.makeText(getApplicationContext(), "Покупка стоит 10 очков", Toast.LENGTH_LONG).show();
        }
    }

    public void change_05(View view) {
        if (user.getScore() > 9){
        /*FragmentManager fm = getSupportFragmentManager();
        ShopDialogFragment dialogFragment = new ShopDialogFragment();
        dialogFragment.show(fm, "dialog");*/
            showMyDialog(5);
        } else {
            Toast.makeText(getApplicationContext(), "Покупка стоит 10 очков", Toast.LENGTH_LONG).show();
        }
    }

    private void showMyDialog(int wallpaperId){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Покупка и установка обоев");
        builder.setMessage("Купить выбранные обои за 10 очков?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        user.setScore(user.getScore() - 10);
                        user.setActualWallpaper(wallpaperId);
                        CurrentUser.getInstance().setCurrentUser(user);
                        DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                                .userDao()
                                .update(user);
                        dialog.dismiss();
                        textView.setText(user.getScore() + "");
                        Toast.makeText(getApplicationContext(), "Оплачено)", Toast.LENGTH_LONG).show();
                        //startActivity(new Intent(this, ChooseLevelActivity.class));
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
