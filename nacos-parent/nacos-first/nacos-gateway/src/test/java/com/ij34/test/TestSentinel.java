package com.ij34.test;

import cn.hutool.http.HttpUtil;

/**
 * Description TestSentinel
 * Date 2021/12/18
 * Created by www.ij34.com
 */
public class TestSentinel implements Runnable {
    public static void main(String[] args) {
        TestSentinel t= new TestSentinel();
        for (int i=0;i<30;i++){
            new Thread(t,"1").start();
            new Thread(t,"2").start();
            new Thread(t,"3").start();
            new Thread(t,"4").start();
        }


    }


    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"|"+ HttpUtil.get("http://192.168.31.203:7000/title/"+i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
