package com.usu.mvvmcounter.models;

import androidx.lifecycle.MutableLiveData;

public class Counter {
    private MutableLiveData<Integer> count;
    public Counter() {
        count = new MutableLiveData<>();
        count.setValue(0);
    }
    public void incrementCount(int amount) {

        count.setValue(count.getValue() + amount);

    }

    public void decrementCount(int amount) {
        count.setValue(count.getValue()  - amount);
    }

    public MutableLiveData<Integer> getCount() {
        return count;
    }
}
