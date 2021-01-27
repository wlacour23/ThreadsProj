package com.tts.threads;

// what is synchronization?
// synchronization is the tool we utilize to avoid thread interference
// and memory consistency errors
// one things to note, sync can also cause thread contention
// this is when two or more threads try to access the same resource simultaneously
// resource being same variable/memory location/what-have-you
// this is synchronization as in "working together"
public class SynchronizedCounter {

    private int c = 0;

    public synchronized void increment() {
        c++;

    }
    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}
