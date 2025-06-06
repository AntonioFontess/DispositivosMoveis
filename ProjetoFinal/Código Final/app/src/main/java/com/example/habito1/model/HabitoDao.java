package com.example.habito1.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HabitoDao {

    @Insert
    void insert(Habito habito);

    @Update
    void update(Habito habito);

    @Delete
    void delete(Habito habito);

    @Query("SELECT * FROM Habito ORDER BY nome ASC")
    List<Habito> getAll();

    @Query("SELECT * FROM Habito WHERE id = :id LIMIT 1")
    Habito findById(int id);
}
