package com.chiachen.mementopractice;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private NoteEditText mNoteEditText;
    private TextView mRedo;
    private TextView mUndo;
    private TextView mSave;

    private NoteCareTaker mNoteCareTaker = new NoteCareTaker();

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.redo_btn: {
                    mNoteEditText.restoreText(mNoteCareTaker.getNextMemento());
                    makeToast("Restore: ");
                    break;
                }
                case R.id.undo_btn: {
                    mNoteEditText.restoreText(mNoteCareTaker.getPrevMemento());
                    makeToast("Undo: ");
                    break;
                }
                case R.id.save_btn: {
                    mNoteCareTaker.saveMemento(mNoteEditText.createMemento());
                    makeToast("Save: ");
                    break;
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mNoteEditText = (NoteEditText) findViewById(R.id.note_edittext);
        mRedo = (TextView) findViewById(R.id.redo_btn);
        mSave = (TextView) findViewById(R.id.save_btn);
        mUndo = (TextView) findViewById(R.id.undo_btn);

        mRedo.setOnClickListener(mOnClickListener);
        mSave.setOnClickListener(mOnClickListener);
        mUndo.setOnClickListener(mOnClickListener);
    }

    public void makeToast(String msg) {
        Toast.makeText(this, msg + mNoteEditText.getText() + " ,Cursor locate at " + mNoteEditText.getSelectionStart(), Toast.LENGTH_SHORT).show();
    }
}
