package gof.builder;

public class TicketTest {

	public static void main(String[] args) {
		TicketHelper helper = new TicketHelper();
		helper.builderAdult("成人票");
		helper.builderSoldier("军人票");
		
		Object ticket = TicketBuilder.builder(helper);
		
	}
}
