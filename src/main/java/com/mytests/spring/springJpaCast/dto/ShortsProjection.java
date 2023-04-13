package com.mytests.spring.springJpaCast.dto;


public class ShortsProjection {
    short arg1;
    Short arg2;

    public ShortsProjection(short arg1, Short arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public String toString() {
        return "ShortsProjection{" +
                "arg1=" + arg1 +
                ", arg2=" + arg2 +
                '}';
    }
}
