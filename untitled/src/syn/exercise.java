package syn;

/**
 * @author ZhouHeng
 **/
public class exercise {
    public static void main(String[] args) {
        T t = new T();

        Thread thread1 = new Thread(t);
        thread1.setName("t1");
        Thread thread2 = new Thread(t);
        thread2.setName("t2");

        thread1.start();
        thread2.start();
    }
}

class T implements Runnable{
    private int money = 10000;
    @Override
    public void run() {
        while (true){

            //实现线程同步
            synchronized (this) {
                //判断余额是否足够
                if (money < 1000) {
                    System.out.println("余额不足");
                    break;
                }

                money -= 1000;
                System.out.println(Thread.currentThread().getName() + " 取出了1000，当前余额=" + money);
            }
            //休眠1S
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}