package com.mycompany.primeproducer;

import java.io.*;

public class buffer {
    private int bufferSize;
    private int store[];
    private int in = 0;
    private int out = 0;
    private String file;
    private semaphore spaces;
    private semaphore items;
    private int totalPrimes = 0;
    private int LargestPrime = 0;
    private int numberOfOutPut = 0;
     long startTime;
     long endTime;


   private boolean isFinished = false;


    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public void increase() {
        totalPrimes++;
    }

    public void increaseInFile() {
        numberOfOutPut++;
    }


    public buffer(int bufferSize) {
        this.bufferSize = bufferSize;
        store = new int[bufferSize];
        spaces = new semaphore(bufferSize);
        items = new semaphore(0);
    }

    public int getTotalPrimes() {
        return totalPrimes;
    }

    public int getOutInFile() {
        return numberOfOutPut;
    }

    public int getLargestPrime() {
        return LargestPrime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void put(int item) {
        spaces.P();
        store[in] = item;
        in = (in + 1) % bufferSize;
        items.V();
    }

    public synchronized int get() {
        items.P();
        int item = store[out];

        //System.out.println(item);

        out = (out + 1) % bufferSize;
        spaces.V();
        return item;
    }


}






