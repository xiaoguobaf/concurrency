package cn.xiaoguobaf.dataRaceAndRaceCondition;

/**
 * Created by guo on 4/26/17.
 */
public class Test1 {

    static class Thread1 extends Thread{
        public volatile SingletonWithVolatile instance;
        @Override
        public void run() {
            Test1.shortWait(1000);//等待１毫秒
            instance = SingletonWithVolatile.getInstance();
        }
    }

    static class Thread2 extends Thread{
        public volatile SingletonWithVolatile instance;
        @Override
        public void run() {
            instance = SingletonWithVolatile.getInstance();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        int i=0;
        while(true) {
            i++;
            Thread1 th1 = new Thread1();
            Thread2 th2 = new Thread2();
            th1.start();
            th2.start();
            th1.join();
            th2.join();
            if(th1.instance.equals(th2.instance)){
                System.out.println(i+" Thread1 :" + th1.instance + ", Thread2 :" + th2.instance);
            }else{
                //创建的对象不等时退出循环
                System.err.println(i+" Thread1 :" + th1.instance + ", Thread2 :" + th2.instance);
                break;
            }
        }
    }

    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while (start+interval>=end);
    }
}
