package 多线程.computer;

/**
 * @author : S K Y
 * @version :0.0.1
 * 设计一个生产电脑和搬运电脑类,要求生产出一台电脑就搬走一台电脑,如果没有新的电脑生产出来,
 * 搬电脑的要等到电脑生产出来,如果生产出的电脑没有搬走,则要等待电脑搬走之后再生产,
 * 并统计出生产的电脑数量
 * <p>
 * 在本程序之中实现的就是一个标准的生产者与消费者的处理模型
 */
class Computer {
    private static int count = 0;      //生产的个数
    private String name;
    private double price;

    public Computer(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        count++;
        return  Thread.currentThread().getName() +" [第" + count + "台电脑]" + " 电脑名字: " + this.name + " 价格: " + this.price;
    }
}

class Resource {
    private Computer computer;

    public synchronized void procedure() throws InterruptedException {
        if (computer != null) {     //此时已经生产出电脑
            super.wait();
        }
        Thread.sleep(100);
        this.computer = new Computer("My牌电脑", 1.1);
        super.notifyAll();
    }

    public synchronized void get() throws InterruptedException {
        if (computer == null) {     //此时还没有生产出电脑
            super.wait();
        }
        Thread.sleep(10);
        System.out.println(this.computer);
        this.computer = null;
        this.notifyAll();
    }
}
class Procedure implements Runnable{
    private Resource resource;

    public Procedure(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.procedure();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Customer implements Runnable{
    private Resource resource;

    public Customer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class MyComputer {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Procedure procedure = new Procedure(resource);
        Customer customer = new Customer(resource);
        new Thread(procedure,"生产者A").start();
//        new Thread(多线程.procedure,"生产者B").start();
        new Thread(customer,"搬运者A").start();
//        new Thread(customer,"搬运者B").start();
    }
}
