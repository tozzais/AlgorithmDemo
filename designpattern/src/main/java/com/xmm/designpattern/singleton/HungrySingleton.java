package com.xmm.designpattern.singleton;

/**
 * 饿汉式
 */
public class HungrySingleton {

    private HungrySingleton(){}
    // 类加载的时候就实例化，并且创建单例对象
    private static final HungrySingleton hungry=new HungrySingleton();
    public static HungrySingleton getInstance(){
        return hungry;
    }
}
