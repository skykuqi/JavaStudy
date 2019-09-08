    package 反射.认识反射机制.entity;

    /**
     * @author : S K Y
     * @version :0.0.1
     */
    public class Person {
        public Person() {   //任何情况下只要实例化对象则一定要调用类中的构造方法
            System.out.println("Person对象实例化了");
        }

        @Override
        public String toString() {
            return "我是一个好人";
        }
    }
