package com.ru.min.sportquiz.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ru.min.sportquiz.database.dao.UserDao;
import com.ru.min.sportquiz.user.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
