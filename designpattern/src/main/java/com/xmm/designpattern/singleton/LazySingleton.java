package com.xmm.designpattern.singleton;

/**
 * 懒汉式
 */
public class LazySingleton {

    //默认不会实例化，什么时候用什么时候new
    private static LazySingleton lazy=null;

    public static synchronized LazySingleton getInstance(){
        if(lazy==null){
            lazy=new LazySingleton();
        }
        return lazy;
    }
}
