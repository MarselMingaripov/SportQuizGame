package com.ru.min.sportquiz.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.ru.min.sportquiz.user.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

    @Update
    void update(User user);

    @Query("SELECT * from users")
    List<User> getUsers();

    @Query("SELECT * from users where name=:name")
    User getUserByName(String name);

    @Query("DELETE from users")
    void deleteAll();
}
