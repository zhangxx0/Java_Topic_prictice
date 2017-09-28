package net.reflect;

import net.serverdemo1.Servlet;

/**
 * 创建实例  调用空构造
 * @author Administrator
 *
 */
public class Demo02 {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz =Class.forName("net.serverdemo1.Servlet");
		// 调用空构造 确保空构造存在
		Servlet ser=(Servlet)clz.newInstance(); 
		System.out.println(ser);
		//retrun ser;
	}

}
