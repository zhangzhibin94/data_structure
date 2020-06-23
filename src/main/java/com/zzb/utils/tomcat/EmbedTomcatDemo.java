package com.zzb.utils.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;

/**
 * @author 张志斌
 * @date 19:53 2020/6/3
 * 嵌入式tomcat 启动demo,其实就是调用tomcat这个类的api
 */
public class EmbedTomcatDemo {
    private static void startTomcat(){
        // 1.获取当前目录的绝对路径
        String classpath = System.getProperty("user.dir");
        System.out.println(classpath);
        // 2.启动tomcat
        Tomcat tomcat = new Tomcat();
        try {
            // 设置connect
            Connector connector = tomcat.getConnector();
            connector.setPort(9090);
            // 设置host
            Host host = tomcat.getHost();
            host.setName("localhost");
            host.setAppBase("webapps");

            // 把class加载进来 把启动的工程加入进来
            Context context = tomcat.addContext(host,"/abc", classpath);
            if(context instanceof StandardContext){
                StandardContext standardContext = (StandardContext) context;
                standardContext.setDefaultContextXml("F:/tomcat/apache-tomcat-9.0.21/conf/web.xml");
                // 把servlet设置进去
                Wrapper wrapper = tomcat.addServlet("/abc", "DemoServlet", new ServletDemo());

                wrapper.addMapping("/map");
            }

            tomcat.start();
            // 强制server等待 避免main线程关闭
            Runtime.getRuntime().addShutdownHook(new Thread(()->{
                System.out.println("tomcat 关闭了");
            }));
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        startTomcat();
    }
}
