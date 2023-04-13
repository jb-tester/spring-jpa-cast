package com.mytests.spring.springJpaCast.dto;


public class LongsProjection {

    Long arg1;
    long arg2;


    public LongsProjection(Long arg1, long arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public String toString() {
        return "LongsProjection{" +
                "arg1=" + arg1 +
                ", arg2=" + arg2 +
                '}';
    }
}
