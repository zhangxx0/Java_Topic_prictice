package annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 内置注解
 * @author zqzx
 */
public class Demo01 {

	@Override
	public String toString() {
		return "111";
	}
	
	@Deprecated
	public static void test001() {
	}
	
	@SuppressWarnings("all")
	public static void test002() {
		List list = new ArrayList();
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		date.parse(""); // @Deprecated
		
		test001();
		
	}
}
