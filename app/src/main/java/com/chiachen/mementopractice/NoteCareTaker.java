package com.chiachen.mementopractice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianjiacheng on 09/12/2017.
 */

public class NoteCareTaker {
    public static final int MAX_RECORD = 4;
    private List<Memento> mMementos = new ArrayList<>(MAX_RECORD);
    private int mIndex = 0;

    public Memento getPrevMemento() {
        mIndex = mIndex > 0 ? --mIndex : mIndex;
        return mMementos.get(mIndex);
    }

    public Memento getNextMemento() {
        mIndex = mIndex < mMementos.size() - 1 ? ++mIndex : mIndex;
        return mMementos.get(mIndex);
    }

    public void saveMemento(Memento memento) {
        // If max(10) < size of list
        // Remove first element.
        if (MAX_RECORD < mMementos.size()) {
            mMementos.remove(0);
        }
        // Add element to tail
        mMementos.add(memento);
        mIndex = mMementos.size() - 1;
    }
}
