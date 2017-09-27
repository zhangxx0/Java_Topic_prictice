package net.tcp.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import sun.text.normalizer.UTF16;

/**
 * 创建客户端: 发送数据+接收数据 写出数据：输出流 读取数据：输入流
 * 
 * 输入流 与输出流 在同一个线程内 应该 独立处理，彼此独立
 * 
 */

public class Client2 {
	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	/*public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost", 9999);
		// 控制台输入流
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		DataInputStream dis = new DataInputStream(client.getInputStream());
		while (true) {
			String info = console.readLine();
			// 输出流
			dos.writeUTF(info);
			dos.flush();
			// 输入流
			String msg = dis.readUTF();
			System.out.println(msg);
		}
	}*/
	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",9999);
		new Thread(new Send(client)).start(); //一条路径
		new Thread(new Receive(client)).start(); //一条路径
		
	}

}
