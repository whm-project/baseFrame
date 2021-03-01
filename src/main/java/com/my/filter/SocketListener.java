package com.my.filter;

import com.my.utils.SocketServerThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SocketListener implements ServletContextListener {

    private SocketServerThread socketThread;

    /**
     * 销毁 当Servlet容器终止Web应用时调用该方法
     * @param arg0
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        if(null!=socketThread && !socketThread.isInterrupted()) {
            // 关闭线程
            socketThread.closeSocketServer();
            // 中断线程
            socketThread.interrupt();
        }
    }

    /**
     * 初始化 当servlet容器启动Web应用时调用该方法
     * @param arg0
     */
    public void contextInitialized(ServletContextEvent arg0) {
        if(null==socketThread)
        {
            //新建线程类
            socketThread=new SocketServerThread();
            //启动线程
            socketThread.start();
        }
    }
}
