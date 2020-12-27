package com.example.demo.utils;

import lombok.SneakyThrows;

public class ThreadTest implements Runnable{


    String s = "";
    public ThreadTest (String s){
        this.s=s;
    };
    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(100);
        System.out.println(s);
    }
}
