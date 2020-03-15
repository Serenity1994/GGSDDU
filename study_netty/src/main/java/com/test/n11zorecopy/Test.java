package com.test.n11zorecopy;

public class Test {
    volatile int anInt = 1;
    public static void main(String[] args) {
        Integer a = 127;

        Integer b = a;
        System.out.println(a+b);
    }

    public void fun(){
        anInt = anInt + 1;
    }
}
