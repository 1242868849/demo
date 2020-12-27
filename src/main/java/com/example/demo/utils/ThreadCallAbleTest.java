package com.example.demo.utils;

import lombok.SneakyThrows;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class ThreadCallAbleTest<T> implements Callable{


    T s ;
    public ThreadCallAbleTest (T s){
        this.s=s;
    };
    @SneakyThrows

    @Override
    public T call() throws Exception {
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName());
        return s;
    }
}
