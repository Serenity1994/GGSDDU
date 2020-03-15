package com.study.cglibproxy;

public class Test {
    public static void main(String[] args) {
        GoodsDao goodsDao = MyBeanFactory.getBean();
        goodsDao.add();
    }
}
