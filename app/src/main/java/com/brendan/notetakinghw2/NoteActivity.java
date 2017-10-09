package com.brendan.notetakinghw2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {

    private EditText mEtTitle;
    private EditText mEtContent;

    private String nNoteFileName;
    private Note nLoadedNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        //finding the indivual title and content and saving them
        mEtTitle = (EditText) findViewById(R.id.noteTitle);
        mEtContent = (EditText) findViewById(R.id.noteContent);

        nNoteFileName = getIntent().getStringExtra("NOTE_FILE");
        if(nNoteFileName != null && !nNoteFileName.isEmpty()){
            nLoadedNote = Utilities.getNoteByName(this, nNoteFileName);

            if(nLoadedNote != null){
                mEtTitle.setText(nLoadedNote.getnTitle());
                mEtContent.setText(nLoadedNote.getnContent());
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
            note = new Note(System.currentTimeMillis(), mEtTitle.getText().toString(), mEtContent.getText().toString()
                    , Utilities.sortMarks("@", mEtContent.getText().toString()), Utilities.sortMarks("#", mEtContent.getText().toString()));
        }else{
            note = new Note(nLoadedNote.getnDateTime(), mEtTitle.getText().toString(), mEtContent.getText().toString()
                    , Utilities.sortMarks("@", mEtContent.getText().toString()), Utilities.sortMarks("#", mEtContent.getText().toString()));

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

