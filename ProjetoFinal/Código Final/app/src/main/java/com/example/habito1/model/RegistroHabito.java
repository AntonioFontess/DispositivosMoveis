package com.example.habito1.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.time.LocalDate;

@Entity(
        foreignKeys = @ForeignKey(
                entity = Habito.class,
                parentColumns = "id",
                childColumns = "habitoId",
                onDelete = ForeignKey.CASCADE
        )
)
@TypeConverters({LocalDateConverter.class})
public class RegistroHabito implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int habitoId;
    private LocalDate data;
    private boolean status;

    public RegistroHabito(int habitoId, LocalDate data, boolean status) {
        this.habitoId = habitoId;
        this.data = data;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHabitoId() {
        return habitoId;
    }

    public void setHabitoId(int habitoId) {
        this.habitoId = habitoId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
