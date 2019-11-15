package com.itheima.demo01.FunctionalInterface;
/*
    函数式接口的使用:一般可以作为: 方法的参数 和 返回值类型
 */
public class Demo {

    //定义一个方法,参数使用函数式接口MyFunctionalInterface
    public static void show(MyFunctionalInterface myInter){
        myInter.method();
    }

    public static void main(String[] args) {

        //1: 传递接口的实现类对象
        //调用show方法，方法的参数是一个接口，所以可以传递接口的实现类对象
        show(new MyFunctionalInterfaceImpl());

        //调用show方法，方法的参数是一个接口，所以我们可以传递接口的匿名内部类
        show(new MyFunctionalInterface() {

            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }

        });

        //2: 使用Lambda表达式
        //调用show方法，方法的参数是一个函数式接口，所以我们可以用Lambda表达式
        // ()代表函数式接口里面的抽象方法，因抽象方法method()没有参数，所以这里为()
        show(()->{
            System.out.println("使用Lambda表达式重写接口中的抽象方法");
        });

        //简化Lambda表达式
        // 条件：
        //      当只有一行代码时，如下面这样!
        // 省略：俩{} 和 该行代码后面的“;”  若该行代码还有return的话也可以省略！
        show(()-> System.out.println("使用Lambda表达式重写接口中的抽象方法"));


        // 小结：
        //一： 2中show()方法中的lambda表达式 可以 看成1中show()方法里 匿名内部类的 “语法糖”，看似一样的代码执行结果效果，实际底层原理是不一样的。
        //二： 2中show()方法中的lambda表达式不会出现 Demo$1.class；  而 1中show()方法里匿名内部类会产生该 匿名内部类的Demo$1.class class文件。
        //三： 所以利用lambda表达式 重写函数式接口的抽象方法 更节省内存空间 效率更高！
    }
}
