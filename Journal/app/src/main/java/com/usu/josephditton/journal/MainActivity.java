package com.usu.josephditton.journal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.usu.josephditton.journal.fragments.JournalEntriesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_view, JournalEntriesFragment.class, null)
                    .setReorderingAllowed(true)
                    .commit();
        }
    }
}