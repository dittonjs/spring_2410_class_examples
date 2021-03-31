package com.usu.mvvmcounter.viewmodels;

import androidx.lifecycle.MutableLiveData;

import com.usu.mvvmcounter.models.Counter;

public class CounterViewModel {
    Counter counter;

    public CounterViewModel() {
        counter = new Counter();
    }

    public MutableLiveData<Integer> getCount() {
        return counter.getCount();
    }

    public void increment() {
        counter.incrementCount(1);
    }

    public void decrement() {
        counter.decrementCount(1);
    }
}
