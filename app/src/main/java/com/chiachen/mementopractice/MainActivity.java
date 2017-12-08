package com.chiachen.mementopractice;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int MAX_RECORD = 30;
    private EditText mEditText;
    private TextView mRedo;
    private TextView mUndo;
    private TextView mSave;

    List<Memento> mMementos = new ArrayList<>(MAX_RECORD);
    int mIndex = 0;

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.redo_btn: {
                    restoreText(getNextMemento());
                    makeToast("restore");
                    break;
                }
                case R.id.undo_btn: {
                    restoreText(getPrevMemento());
                    makeToast("undo");
                    break;
                }
                case R.id.save_btn: {
                    saveMemento(createMementoFromEditText());
                    makeToast("save");
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
        mEditText = (EditText) findViewById(R.id.note_edittext);
        mRedo = (TextView) findViewById(R.id.redo_btn);
        mSave = (TextView) findViewById(R.id.save_btn);
        mUndo = (TextView) findViewById(R.id.undo_btn);

        mRedo.setOnClickListener(mOnClickListener);
        mSave.setOnClickListener(mOnClickListener);
        mUndo.setOnClickListener(mOnClickListener);
    }

    public void makeToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void restoreText(Memento memento) {
    }

    public Memento getPrevMemento() {
        return null;
    }

    public Memento getNextMemento() {
        return null;
    }

    private Memento createMementoFromEditText() {
        return null;
    }

    private void saveMemento(Memento memento) {
    }
}
