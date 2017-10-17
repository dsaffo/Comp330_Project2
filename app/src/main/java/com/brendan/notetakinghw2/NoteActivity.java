package com.brendan.notetakinghw2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class NoteActivity extends AppCompatActivity {

    private EditText mEtTitle;
    private EditText mEtContent;
    private TextView mEtMentions;
    private TextView mEtTopics;
    private TextView mEtIdentifiers;
    private TextView mEtRefrences;


    private String nNoteFileName;
    private Note nLoadedNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        //finding the indivual title and content and saving them
        mEtTitle = (EditText) findViewById(R.id.noteTitle);
        mEtContent = (EditText) findViewById(R.id.noteContent);
        mEtMentions = (TextView) findViewById(R.id.mentions);
        mEtTopics = (TextView) findViewById(R.id.topics);
        mEtIdentifiers = (TextView) findViewById(R.id.identifiers);
        mEtRefrences = (TextView) findViewById(R.id.refrences);

        nNoteFileName = getIntent().getStringExtra("NOTE_FILE");
        if(nNoteFileName != null && !nNoteFileName.isEmpty()){
            nLoadedNote = Utilities.getNoteByName(this, nNoteFileName);

            if(nLoadedNote != null){
                mEtTitle.setText(nLoadedNote.getnTitle());
                mEtContent.setText(nLoadedNote.getnContent());
                mEtMentions.setText("Mentions: " + Arrays.toString(nLoadedNote.getnMentions().toArray()).replace("[", "").replace("]", ""));
                mEtTopics.setText("Topics: " + Arrays.toString(nLoadedNote.getnTopics().toArray()).replace("[", "").replace("]", ""));
                mEtIdentifiers.setText("Identifiers: " + Arrays.toString(nLoadedNote.getnIDs().toArray()).replace("[", "").replace("]", ""));
                mEtRefrences.setText("Refrences: " + Arrays.toString(nLoadedNote.getnRefs().toArray()).replace("[", "").replace("]", ""));
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note_new, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_note_save:
                saveNote();
                break;

            case R.id.action_note_delete:
                deleteNote();

        }

        return true;
    }


    private void saveNote() {

        Note note;



        if(mEtTitle.getText().toString().trim().isEmpty() || mEtContent.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Please enter a title and content", Toast.LENGTH_SHORT).show();
            return ;
        }

        //creating a new note using the three parameters from the constructor
       /* Note note = new Note(System.currentTimeMillis(), mEtTitle.getText().toString(), mEtContent.getText().toString()
                , Utilities.sortMarks("@", mEtContent.getText().toString()), Utilities.sortMarks("#", mEtContent.getText().toString()));
        */

        if(nLoadedNote == null){
            Long time = System.currentTimeMillis();
            String title = mEtTitle.getText().toString();
            String content = mEtContent.getText().toString();
            ArrayList<String> mentions = Utilities.sortMarks("@", content);
            ArrayList<String> topics = Utilities.sortMarks("#", content);
            ArrayList<String> Ids = Utilities.checkIdentifiers(Utilities.getAllSavedNotes(getApplicationContext()),content,
                    false, getApplicationContext(), "nan");
            ArrayList<String> Refs = Utilities.sortMarks("^", content);
            Log.d("is null?", "yes");
            note = new Note(time,title,content,mentions,topics,Ids,Refs);
            //Utilities.createEvent(mCredential);
        }else{
            Long time = System.currentTimeMillis();
            String title = mEtTitle.getText().toString();
            String content = mEtContent.getText().toString();
            ArrayList<String> mentions = Utilities.sortMarks("@", content);
            ArrayList<String> topics = Utilities.sortMarks("#", content);
            ArrayList<String> IdsEdit = Utilities.checkIdentifiers(Utilities.getAllSavedNotes(getApplicationContext()),content,
                    true, getApplicationContext(), nLoadedNote.getnDateTime()+ Utilities.FILE_EXTENSION);
            ArrayList<String> Refs = Utilities.sortMarks("^", content);
            Utilities.deleteNote(getApplicationContext(), nLoadedNote.getnDateTime()+ Utilities.FILE_EXTENSION);
            note = new Note(time,title,content,mentions,topics,IdsEdit,Refs);

        }

        if (Utilities.saveNote(this, note)) {

            Toast.makeText(this, "Your note is saved", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Cannot save, please make sure there is enough space on your device", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

       private void deleteNote(){
            if(nLoadedNote == null){
                finish();
            }else{

                AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                        .setTitle("Are you sure")
                        .setMessage("You are about to delete the note")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Utilities.deleteNote(getApplicationContext(), nLoadedNote.getnDateTime()+ Utilities.FILE_EXTENSION);
                                Toast.makeText(getApplicationContext(), "Note was deleted", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        })
                        .setNegativeButton("No", null)
                        .setCancelable(false);

                dialog.show();
            }
    }


}

