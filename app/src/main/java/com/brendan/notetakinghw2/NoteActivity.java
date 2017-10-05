package com.brendan.notetakinghw2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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

           //loaded note is the same activity as a created note. you are simply putting the title
            //and content back into this newly loaded view of the note.
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


    private void saveNote(){
        Note note;
        //creating a new note using the three parameters from the constructor
        //chekcing to see if its a new note or a loaded note
        if(nLoadedNote == null) {
             note = new Note(System.currentTimeMillis(), mEtTitle.getText().toString(), mEtContent.getText().toString());
        }else{
            //use the dateTime of the old note so the file name will be in sync
             note = new Note(nLoadedNote.getnDateTime(), mEtTitle.getText().toString(), mEtContent.getText().toString());
        }
       if(Utilities.saveNote(this, note)){
           Toast.makeText(this, "Your note is saved", Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(this, "Cannot save, please make sure there is enough space on your device", Toast.LENGTH_SHORT).show();
       }
       finish();
    }

    private void deleteNote() {
        if (nLoadedNote == null){
            finish();
        }else{
            //set up an alert dialog box to warn the user about deleting the file
            AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                    .setTitle("Delete")
                    .setMessage("You are about to delete " + mEtTitle.getText().toString() + ", are you sure?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Utilities.deleteNote(getApplicationContext(), nLoadedNote.getnDateTime() + Utilities.FILE_EXTENSION);
                            Toast.makeText(getApplicationContext(), "Note was deleted", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    })
                    //if the user selects no, we do not want to do any activity...hence the null
                    .setNegativeButton("No", null)
                    //does not allow the user to click out of the dialog box to cancle action
                    .setCancelable(false);

                dialog.show();
        }
    }
}
