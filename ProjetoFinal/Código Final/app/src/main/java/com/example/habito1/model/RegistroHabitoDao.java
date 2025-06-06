package com.example.habito1.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface RegistroHabitoDao {

    @Insert
    void insert(RegistroHabito registro);

    @Query("SELECT * FROM RegistroHabito WHERE habitoId = :habitoId")
    List<RegistroHabito> findByHabito(int habitoId);
}
