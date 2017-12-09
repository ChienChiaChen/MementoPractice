package com.chiachen.mementopractice;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Created by jianjiacheng on 09/12/2017.
 */

public class NoteEditText extends AppCompatEditText {

    public NoteEditText(Context context) {
        super(context);
    }

    public NoteEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoteEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Memento createMemento() {
        Memento memento = new Memento();
        memento.text = getText().toString();
        memento.cursor = getSelectionStart();
        return memento;
    }

    public void restoreText(Memento memento) {
        setText(memento.text);
        setSelection(memento.cursor);
    }

}
