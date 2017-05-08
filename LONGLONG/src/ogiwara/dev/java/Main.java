package ogiwara.dev.java;

public class Main {

    private static final int REPEAT = 500000000;

    private static Long a = new Long(0);

    public static void main(String[] args) throws InterruptedException{

        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i <REPEAT; i++){
                    synchronized (a){
                        a = new Long(1);
                        check();
                    }
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i <REPEAT; i++){
                    synchronized (a) {
                        a = new Long(-1);
                        check();
                    }
                }
            }
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println("FINISHED!");
    }

    private static void check(){
        if(a != 1 && a != -1){
            System.out.println("LONG VALUE HAS BROKEN!");
        }
    }
}
