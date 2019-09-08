package 反射.反射与操作类;

import sun.misc.Unsafe;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author : S K Y
 * @version :0.0.1
 */
public class PersonDemo {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;       //获取指定类的class对象
        Package aPackage = personClass.getPackage();    //获取指定类的包定义
        System.out.println("获取包名称: " + aPackage.getName());
        Class<? super Person> superclass = personClass.getSuperclass();     //获取父类
        System.out.println("Person获取父类: " + superclass.getName());
        System.out.println("superclass获取父类: " + superclass.getSuperclass().getName());
        Class<?>[] interfaces = personClass.getInterfaces();        //获取父接口
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println("获取父接口" + (i + 1) + ": " + interfaces[i].getName());
        }
    }
}

class ConstructorDemo {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;       //获取指定类的class对象
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();      //获取全部构造
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("========================");
        constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }
}

class OneConstructorDemo {
    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;       //获取指定类的class对象
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person person = constructor.newInstance("张三", 56);
        System.out.println(person);
    }
}

class MethodDemo {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;       //获取指定类的class对象
        {   //获取全部方法
            Method[] methods = personClass.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
        }
        System.out.println("=========================");
        {   //获取全部方法
            Method[] methods = personClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
        }
    }
}

class MyMethodDemo {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;       //获取指定类的class对象
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            String modifier = Modifier.toString(method.getModifiers());//获取访问修饰符
            String returnType = method.getReturnType().getName();     //获取方法的返回类型
            Class<?>[] parameterTypes = method.getParameterTypes();     //获取参数类型
            StringBuffer buffer = new StringBuffer();
            buffer.append("(");
            for (int i = 0; i < parameterTypes.length; i++) {
                buffer.append(parameterTypes[i].getName());
                buffer.append(" arg").append(i);
                if (i < parameterTypes.length - 1) {
                    buffer.append(",");
                }
            }
            buffer.append(")");
            String parameterType = buffer.toString();
            Class<?>[] exceptionTypes = method.getExceptionTypes();     //获取异常类型
            buffer = new StringBuffer();
            if (exceptionTypes.length > 0) {
                buffer.append(" throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    buffer.append(exceptionTypes[i].getName());
                    buffer.append(" e").append(i);
                    if (i < exceptionTypes.length - 1) {
                        buffer.append(",");
                    }
                }
            }
            String exceptionType = buffer.toString();
            System.out.println(modifier + " " + returnType + " " + method.getName() + parameterType + "" + exceptionType);
        }
    }
}

class GetterAndSetterDemo {
    public static void main(String[] args) throws Exception {
        //在不导入开发包的情况下实现属性的配置
        Class<?> aClass = Class.forName("反射.反射与操作类.Person");//获取指定类的class对象
        String attribute = "name";  //要操作的类属性
        String value = "张三";    //要设置的属性内容
        //1.任何情况写想要调用类中的属性或者调用类中的方法都必须保证存在有实例化对象
        Object obj = aClass.newInstance();      //调用无参构造实例化
        //2.如果想要进行方法的调用,一定要获取方法的名称
        String setMethodName = "setName";
        Method method = aClass.getDeclaredMethod(setMethodName, String.class);
        method.invoke(obj, value);   //等价于 person.setName("小强");
        System.out.println("toString: " + obj);
        String getMethodName = "getName";
        Method getName = aClass.getDeclaredMethod(getMethodName);
        System.out.println("getName: " + getName.invoke(obj));  //等价于 person.getName();
    }
}

class GetFieldDemo {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("反射.反射与操作类.Person");//获取指定类的class对象
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("======================");
        fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }
}

class UseNameDemo {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("反射.反射与操作类.Person");//获取指定类的class对象
        Object obj = aClass.getConstructor().newInstance();
        Field name = aClass.getDeclaredField("name");
        System.out.println(name.getType().getName());   //获取完整类名称
        System.out.println(name.getType().getSimpleName());
    }
}

class GetUnsafeDemo {
    public static void main(String[] args) throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);  //解除封装处理
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);     //static属性不需要传递实例化对象
        Singleton singleton = (Singleton) unsafe.allocateInstance(Singleton.class);
        singleton.print();
    }
}

class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    private Singleton(){
        System.out.println("构造方法");
    }
    public void print() {
        System.out.println("实例化对象输出内容");
    }
}

