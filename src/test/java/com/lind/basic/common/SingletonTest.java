package com.lind.basic.common;

import org.junit.Test;

public class SingletonTest {
    @Test
    public void test() {
        A.Instance.getInstance().print();
    }

}

/**
 * 枚举实现的单例.
 */
enum A {
    Instance;

    Do getInstance() {
        return new Do();
    }

    class Do {
        public void print() {
            System.out.print("print a message");
        }
    }
}

/**
 * 饿汉式(线程安全，调用效率高，但是不能延时加载).
 */
class ImageLoader {
    private static ImageLoader instance = new ImageLoader();

    private ImageLoader() {
    }

    public static ImageLoader getInstance() {
        return instance;
    }
}

/**
 * 静态内部类实现模式（线程安全，调用效率高，可以延时加载）.
 */
class SingletonDemo3 {

    private static class SingletonClassInstance {
        private static final SingletonDemo3 instance = new SingletonDemo3();
    }

    private SingletonDemo3() {
    }

    public static SingletonDemo3 getInstance() {
        return SingletonClassInstance.instance;
    }

}