package com.mixer;

public class TimeTracker {
    private static final double SECOND_IN_NANO = 1000000000;

    private long startTime = 0;

    public TimeTracker() {
        reset();
    }

    public TimeTracker(long startTime) {
        this.startTime = startTime;
    }

    public void reset() {
        startTime = System.nanoTime();
    }

    public double startTime() {
        return startTime / SECOND_IN_NANO;
    }

    public double time() {
        return (System.nanoTime() - startTime) / SECOND_IN_NANO;
    }

    @Override
    public String toString() {
        return String.format("%1.4f seconds", time());
    }

}
