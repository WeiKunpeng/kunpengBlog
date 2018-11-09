package com.wei.KunPengBlog;

/**
 * Created by weikunpeng on 2018/11/8.
 */
public class Test implements Runnable {


    private String num;

    public Test(int num){

        this.num=num+"";
    }


    public static void main(String[] args) {
        int [] a={1,2,3,4,111,1111,2222};

        for (int i=0;i<a.length;i++){
            new Thread(new Test(a[i])).start();;
        }
    }
    @Override
    public void run() {
        try {
            Thread.sleep(Integer.parseInt(num));
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
