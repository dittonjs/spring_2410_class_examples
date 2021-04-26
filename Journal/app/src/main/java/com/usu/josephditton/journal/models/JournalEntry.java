package com.usu.josephditton.journal.models;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class JournalEntry implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "body")
    public String body;

    @ColumnInfo(name="entry_date")
    public long entryDate;

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof JournalEntry) {
            JournalEntry other = (JournalEntry) obj;
            return other.id == this.id;
        }
        return false;
    }
}
