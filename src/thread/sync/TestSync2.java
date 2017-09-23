package thread.sync;

public class TestSync2 implements Runnable{
    public void run() {
        bc.getMoney(Thread.currentThread().getName(), 2000);
    }
    
    public BankCard bc = new BankCard();
    public static void main(String[] args) {
        TestSync2 test = new TestSync2();
        Thread wife = new Thread(test);
        Thread husband = new Thread(test);
        wife.setName("wife");
        husband.setName("husband");
        wife.start();
        husband.start();
    }
}
class BankCard{
    private static int money = 3000;//模拟账户余额
    public synchronized void getMoney(String name,int m){
        //synchronized(this){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(money > m){
                System.out.println(name+"取走了"+m+"元");
                money = money - m;
            }else{
                System.out.println("对不起，您的余额不足！");
            }
        //}
    }
}
