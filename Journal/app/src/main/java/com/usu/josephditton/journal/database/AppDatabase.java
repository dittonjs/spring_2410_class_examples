package com.usu.josephditton.journal.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.usu.josephditton.journal.models.JournalEntry;

@Database(entities = {JournalEntry.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract JournalEntryDao getJournalEntryDao();
}

