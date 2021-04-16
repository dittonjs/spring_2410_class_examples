package com.usu.josephditton.journal.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.usu.josephditton.journal.database.AppDatabase;
import com.usu.josephditton.journal.fragments.JournalEntriesFragment;
import com.usu.josephditton.journal.models.JournalEntry;

import java.util.ArrayList;

public class JournalEntriesViewModel extends AndroidViewModel {
    ArrayList<JournalEntry> entries = new ArrayList<>();
    MutableLiveData<Boolean> saving = new MutableLiveData<>();
    AppDatabase db;
    public JournalEntriesViewModel(Application app) {
        super(app);
        saving.setValue(false);
        db = Room.databaseBuilder(app, AppDatabase.class, "journal-database").build();
    }

    public MutableLiveData<Boolean> getSaving() {
        return saving;
    }

    public ArrayList<JournalEntry> getEntries() {
        return entries;
    }

    public void saveJournalEntry(String title, String body) {
        saving.setValue(true);
        new Thread(() -> {
            JournalEntry newEntry = new JournalEntry();
            newEntry.title = title;
            newEntry.body = body;
            newEntry.entryDate = System.currentTimeMillis();
            newEntry.id = db.getJournalEntryDao().insert(newEntry);
            entries.add(newEntry);
            saving.postValue(false);
        }).start();
    }
}
