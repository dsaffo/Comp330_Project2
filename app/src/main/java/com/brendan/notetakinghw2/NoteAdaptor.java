package com.brendan.notetakinghw2;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Brendan on 10/4/17.
 */

public class NoteAdaptor extends ArrayAdapter<Note> {


    public NoteAdaptor(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Note> notes) {
        super(context, resource, notes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // return super.getView(position, convertView, parent);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_note, null);
        }

        Note note = getItem(position);

        if (note!= null){
            TextView title =  (TextView) convertView.findViewById(R.id.list_note_title);
            TextView date =  (TextView) convertView.findViewById(R.id.list_note_date);
            TextView content =  (TextView) convertView.findViewById(R.id.list_note_content);

            title.setText(note.getnTitle());
            date.setText(note.getDateTimeAsString(getContext()));
            //content.setText(note.getnContent());

            //in case the note is very long, we only preview a substring of that note
            if (note.getnContent().length() > 50){
                content.setText(note.getnContent().substring(0, 50));
            }else{
                content.setText(note.getnContent());
            }

        }
        return convertView;
    }
}
