package com.zzb.DesignPatterns.proxy.writeproxy;

import java.lang.reflect.Method;

/**
 * @Author by 张志斌 .
 * @Date 12:42 2019/4/17
 * 自己实现JDK动态代理类
 */
public class ZProxy {
    private static String ln = "\r\n";
    public static Object newProxyInstance(ZClassLoader loader,
                                          Class<?>[] interfaces,
                                          ZInvocationHandler h)
            throws IllegalArgumentException{
        //1.生成源代码
        String proxySrc = generateSrc(interfaces[0]);
        //2.将生成的源代码输出到磁盘，保存为.java文件

        //3.编译源代码并且生成.class文件
        //4.将class文件中的内容动态加载到jvm中来
        //5.返回被代理后的代理对象
        return null;
    }

    private static String generateSrc( Class<?> interfaces){
        StringBuilder src = new StringBuilder();
        src.append("package com.zzb.DesignPatterns.proxy.writeproxy;" + ln)
                .append("import java.lang.reflect.Method;" + ln)
                .append("import com.zzb.DesignPatterns.proxy.Person;" + ln)
                .append("public  class $Proxy0 extends ZProxy implements" + interfaces.getName() + "{" + ln)
                .append("ZInvocationHandler h;" + ln)
                .append("public $Proxy0(ZInvocationHandler h) {" + ln)
                .append("this.h = h;")
                .append("}" + ln);
        for (Method method : interfaces.getMethods()) {
            src.append("public " + method.getReturnType() + " " + method.getName()+"() throws Exception");
        }
                src.append("}");
        return  "";
    }
}
