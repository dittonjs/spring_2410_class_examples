package com.usu.josephditton.journal.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class JournalEntry {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "body")
    public String body;

    @ColumnInfo(name="entry_date")
    public long entryDate;
}
