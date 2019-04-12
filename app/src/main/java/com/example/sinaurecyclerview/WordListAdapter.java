package com.example.sinaurecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class WordListAdapter<context> extends RecyclerView.Adapter<WordListAdapter.ViewHolder>{
    private LayoutInflater mInflater;
    private List<String>mwordlist;
    private Context context;

    public WordListAdapter(Context context, List<String> wordList) {
        this.mInflater= LayoutInflater.from(context);
        this.mwordlist= wordList;
    }
    @NonNull
    @Override
    public WordListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        // Inflate an item view.
        View view= mInflater.inflate(R.layout.item_word,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.ViewHolder viewHolder, int i) {
        String mCurrent = mwordlist.get(i);
        viewHolder.titleText.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mwordlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.Word_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context,titleText.getText(), Toast.LENGTH_SHORT)
            .show();
        }
    }
}
