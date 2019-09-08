package 多线程.lock;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Dog {
    synchronized void say(Cat cat) {
        System.out.println("此路是我开,要想从此过,给我十块钱!");
        cat.get();
    }

    synchronized void get() {
        System.out.println("小狗拿到了10块钱,可以去买饭吃了");
    }
}

class Cat {
    synchronized void say(Dog dog) {
        System.out.println("让我先过去,我就给你钱!");
        dog.get();
    }

    synchronized void get() {
        System.out.println("逃过了一劫,可以不用付过路费了!");
    }
}

public class DeadLock implements Runnable {
    private Dog dog = new Dog();
    private Cat cat = new Cat();

    private DeadLock() {
        new Thread(this).start();
        Thread.yield();
        dog.say(cat);
    }

    @Override
    public void run() {
        cat.say(dog);
    }

    public static void main(String[] args) {
        new DeadLock();
    }
}
