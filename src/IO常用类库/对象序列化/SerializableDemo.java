package IO常用类库.对象序列化;

import java.io.*;

/**
 * @author : S K Y
 * @version :0.0.1
 */
class Person implements Serializable {       //这样就表示这个类可以被序列化
    private transient String name;      //在进行序列化处理的时候name属性的内容将不会被保存下来
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class SerializableDemo {
    public static final File SAVE_FILE =
            new File("D:" + File.separator + "java-test" + File.separator + "person.save");

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("张三", 22);
        saveObject(person);
        Person readPerson = (Person) loadObject();
        System.out.println(readPerson);
    }

    public static void saveObject(Object obj) throws IOException {
        if (!SAVE_FILE.getParentFile().exists()) {
            SAVE_FILE.getParentFile().mkdirs();
        }
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
        outputStream.writeObject(obj);      //序列化
        outputStream.close();
    }

    public static Object loadObject() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(SAVE_FILE));
        Object object = inputStream.readObject();       //反序列化
        inputStream.close();
        return object;
    }

}
