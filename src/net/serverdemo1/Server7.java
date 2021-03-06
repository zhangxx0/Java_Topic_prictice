package net.serverdemo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import net.tcp.socket.CloseUtil;

/**
 * 创建服务器，并启动
 * 
 * 1、请求
 * 2、响应
 * @author Administrator
 *
 */
public class Server7 {
	private ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	
	private boolean isShutDown= false;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Server7 server = new Server7();
		server.start();
		
		
	}
	/**
	 * 启动方法
	 */
	public void start(){		
		start(8888);
	
	}
	/**
	 * 指定端口的启动方法
	 */
	public void start(int port){		
		try {
			server = new ServerSocket(port);
			this.receive();
		} catch (IOException e) {
			//e.printStackTrace();
			stop();
		}
	
	}
	/**
	 * 接收客户端
	 */
	private void receive(){
		try {
			while(!isShutDown){
				new Thread(new Dispatcher(server.accept())).start();
			}
		} catch (IOException e) {
			//e.printStackTrace();
			stop();
		}
		
	}
	
	/**
	 * 停止服务器
	 */
	public void stop(){
		isShutDown=true;
		CloseUtil.closeSocket(server);
	}
	
	
}
