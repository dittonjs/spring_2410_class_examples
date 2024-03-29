package com.usu.josephditton.journal.viewmodels;

import android.app.Application;

import androidx.databinding.ObservableArrayList;
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
    ObservableArrayList<JournalEntry> entries = new ObservableArrayList<>();
    MutableLiveData<Boolean> saving = new MutableLiveData<>();
    MutableLiveData<JournalEntry> currentEntry = new MutableLiveData<>();
    AppDatabase db;
    public JournalEntriesViewModel(Application app) {
        super(app);
        saving.setValue(false);
        db = Room.databaseBuilder(app, AppDatabase.class, "journal-database").build();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            entries.addAll(db.getJournalEntryDao().getAll());
        }).start();
    }

    public void setCurrentEntry(JournalEntry entry) {
        currentEntry.postValue(entry);
    }

    public MutableLiveData<JournalEntry> getCurrentEntry() {
        return currentEntry;
    }

    public MutableLiveData<Boolean> getSaving() {
        return saving;
    }

    public ObservableArrayList<JournalEntry> getEntries() {
        return entries;
    }

    public void saveJournalEntry(String title, String body) {
        saving.setValue(true);
        new Thread(() -> {
            if (currentEntry.getValue() != null) {
                JournalEntry current = currentEntry.getValue();
                current.title = title;
                current.body = body;
                db.getJournalEntryDao().update(current);
                int index = entries.indexOf(current);
                entries.set(index, current);
            } else {
                JournalEntry newEntry = new JournalEntry();
                newEntry.title = title;
                newEntry.body = body;
                newEntry.entryDate = System.currentTimeMillis();
                newEntry.id = db.getJournalEntryDao().insert(newEntry);
                entries.add(newEntry);
            }

            saving.postValue(false);
        }).start();
    }

    public void deleteEntry(JournalEntry entry) {
        new Thread(() -> {
            db.getJournalEntryDao().delete(entry);
            entries.remove(entry);
        }).start();
    }
}
