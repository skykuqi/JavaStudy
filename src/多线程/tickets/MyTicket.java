package 多线程.tickets;

/**
 * @author : S K Y
 * @version :0.0.1
 */

class TicketThread implements Runnable {
    private int ticket = 10;        //总票数为10张

    private synchronized boolean sale() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票,ticket = " + ticket--);
            return true;
        } else {
            System.out.println("票已经卖光了");
            return false;
        }
    }

    @Override
    public void run() {
        while (sale());
    }
}

public class MyTicket {
    public static void main(String[] args) {
        TicketThread ticketThread = new TicketThread();
        new Thread(ticketThread, "售票员A").start();
        new Thread(ticketThread, "售票员B").start();
        new Thread(ticketThread, "售票员C").start();
    }
}
