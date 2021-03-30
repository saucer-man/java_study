package class1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Revoke {
    public static void main(String[] args) {

        try{
            execute("class1.TrainPrint","Print");
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            ref("class1.TouchFile");
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("end");
    }
    public static void execute(String className, String methodName) throws Exception {
        // 1. 获取反射中的Class对象
        Class clz = Class.forName(className); // 获取类的 Class 对象实例

        // 2. 通过反射创建类对象
        Constructor constructor = clz.getConstructor(); // 根据 Class 对象实例获取 Constructor 对象
        Object object = constructor.newInstance(); //使onstructor 对象的 newInstance 方法获取反射类对象

        // 3. 通过反射获取类属性、方法、构造器
        Method method = clz.getMethod(methodName);

        // 4. 利用 invoke 方法调用方法
        method.invoke(object);
    }
    public static void ref(String name) throws Exception {
        Class.forName(name);
    }
}


