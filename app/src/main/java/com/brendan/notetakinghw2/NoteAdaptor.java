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
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by Brendan on 10/4/17.
 */

public class NoteAdaptor extends ArrayAdapter<Note> implements Filterable{

    private ArrayList notes = null;
    private ArrayList<Note> arraylist;
    Context mContext;
    LayoutInflater inflater;


    public NoteAdaptor(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Note> notes) {
        super(context, resource, notes);
        mContext = context;
        this.notes = notes;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(notes);

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
            //TextView mentions =  (TextView) convertView.findViewById(R.id.list_note_mentions);
            //TextView topics =  (TextView) convertView.findViewById(R.id.list_note_topics);

            title.setText(note.getnTitle());
            date.setText(note.getDateTimeAsString(getContext()));
            //content.setText(note.getnContent());

            //in case the note is very long, we only preview a substring of that note
            if (note.getnContent().length() > 50){
                content.setText(note.getnContent().substring(0, 50));
            }else{
                content.setText(note.getnContent());
            }

            /**if (note.getnContent().length() > 0) {
                String mentionList = Arrays.toString(note.getnMentions().toArray()).replace("[", "").replace("]", "");
                mentions.setText("Mentions: " + mentionList);
            }

            if (note.getnContent().length() > 0) {
                String topicList = Arrays.toString(note.getnTopics().toArray()).replace("[", "").replace("]", "");
                topics.setText("Topics: " + topicList);
            }**/

        }
        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        notes.clear();
        if (charText.length() == 0) {
            notes.addAll(arraylist);
        } else {
            for (Note note : arraylist) {
                if (note.getnContent().toLowerCase().contains(charText) ||
                        note.getnTitle().toLowerCase().contains(charText)) {
                    notes.add(note);
                }
            }
        }
        notifyDataSetChanged();
    }
}
