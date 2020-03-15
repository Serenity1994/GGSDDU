package com.study.jdkproxy;

public class Test {
    public static void main(String[] args) {
        CustomerDao customerDao = MyBeanFactory.getBean();
        customerDao.add();
    }
}
