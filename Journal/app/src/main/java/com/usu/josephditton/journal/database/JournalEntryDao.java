package com.usu.josephditton.journal.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.usu.josephditton.journal.models.JournalEntry;

import java.util.List;

@Dao
public interface JournalEntryDao {

    @Query("SELECT * FROM journalentry")
    List<JournalEntry> getAll();

    @Query("SELECT * FROM journalentry WHERE id = :id LIMIT 1")
    JournalEntry findById(long id);

    @Insert
    long insert(JournalEntry entry);

    @Update
    void update(JournalEntry entry);

    @Delete
    void delete(JournalEntry entry);
}
