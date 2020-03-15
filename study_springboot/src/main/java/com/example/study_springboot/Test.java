package com.example.study_springboot;

import java.lang.reflect.Proxy;
import java.util.Observable;
import java.util.Observer;

public class Test {
    public static void main(String[] args) {
        OilFutures oilFutures = new OilFutures();
        oilFutures.addObserver(new Bull());
        oilFutures.addObserver(new Bear());
        oilFutures.setPrice(1);
        oilFutures.setPrice(3);
    }

    //具体目标类：原油期货
    static class OilFutures extends Observable
    {
        private float price;
        public float getPrice()
        {
            return this.price;
        }
        public void setPrice(float price)
        {
            super.setChanged() ;  //设置内部标志位，注明数据发生变化
            super.notifyObservers(price);    //通知观察者价格改变了
            this.price=price ;
        }
    }
    //具体观察者类：多方
    static class Bull implements Observer
    {
        public void update(Observable o,Object arg)
        {
            Float price=((Float)arg).floatValue();
            if(price>0)
            {
                System.out.println("油价上涨"+price+"元，多方高兴了！");
            }
            else
            {
                System.out.println("油价下跌"+(-price)+"元，多方伤心了！");
            }
        }
    }
    //具体观察者类：空方
    static class Bear implements Observer
    {
        public void update(Observable o,Object arg)
        {
            Float price=((Float)arg).floatValue();
            if(price>0)
            {
                System.out.println("油价上涨"+price+"元，空方伤心了！");
            }
            else
            {
                System.out.println("油价下跌"+(-price)+"元，空方高兴了！");
            }
        }
    }
}
