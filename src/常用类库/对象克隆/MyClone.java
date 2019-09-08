package 常用类库.对象克隆;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

/**
 * @author : S K Y
 * @version :0.0.1
 *
 */
class CloneDemo implements Cloneable{
    private String name;
    private int age;
    private CloneChild cloneChild;

    public CloneDemo(String name, int age, CloneChild cloneChild) {
        this.name = name;
        this.age = age;
        this.cloneChild = cloneChild;
    }

    @Override
    public String toString() {
        return super.toString() + " CloneDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cloneChild=" + cloneChild +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();       //采用父类中提供的克隆方法
    }
}
class CloneChild implements Cloneable{
    private String title;

    public CloneChild(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return super.toString() + " CloneChild{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();       //采用父类中提供的克隆方法
    }
}
public class MyClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneDemo cloneDemo = new CloneDemo("老王", 50, new CloneChild("你是谁"));
        CloneDemo demo = (CloneDemo) cloneDemo.clone();
        System.out.println(cloneDemo);
        System.out.println(demo);
    }
}
