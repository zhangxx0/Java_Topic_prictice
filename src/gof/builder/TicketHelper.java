package gof.builder;

/**
 * 建造者模式
 * 配置类
 * @author xinxin
 * @date 2017年11月2日21:51:13
 */
public class TicketHelper {

	public void builderAdult(String info) {
		System.out.println("构建成人票逻辑：" + info);
	} 
	
	public void builderSoldier(String info) {
		System.out.println("构建军人票逻辑：" + info);
	} 
}

