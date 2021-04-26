package com.usu.josephditton.journal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.usu.josephditton.journal.models.JournalEntry;

public class JournalEntriesAdapter extends RecyclerView.Adapter<JournalEntriesAdapter.ViewHolder> {
    ObservableArrayList<JournalEntry> entries;
    OnJournalEntryClicked listener;
    OnJournalEntryClicked deleteListener;
    public interface OnJournalEntryClicked {
        public void onClick(JournalEntry entry);
    }
    public JournalEntriesAdapter(ObservableArrayList<JournalEntry> entries, OnJournalEntryClicked listener, OnJournalEntryClicked deleteListener) {
        this.entries = entries;
        this.listener = listener;
        this.deleteListener = deleteListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.journal_entry_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JournalEntry entry = entries.get(position);
        TextView title = holder.itemView.findViewById(R.id.entry_title);
        TextView date = holder.itemView.findViewById(R.id.entry_date);
        MaterialButton readButton = holder.itemView.findViewById(R.id.read_button);
        readButton.setOnClickListener(view -> {
            if (listener == null) return;
            listener.onClick(entry);
        });
        holder.itemView.findViewById(R.id.delete_button).setOnClickListener(view -> {
            if (deleteListener == null) return;
            deleteListener.onClick(entry);
        });
        title.setText(entry.title);
        date.setText(entry.entryDate + "");
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
