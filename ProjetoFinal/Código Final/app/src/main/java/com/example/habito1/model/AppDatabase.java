package com.example.habito1.model;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Habito.class, RegistroHabito.class}, version = 1)
@TypeConverters({LocalDateConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract HabitoDao habitoDao();
    public abstract RegistroHabitoDao registroHabitoDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "habitos.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
