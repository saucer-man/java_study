package class1;

public class ExecRuntime {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("java.lang.Runtime");
        clazz.getMethod("exec",
                String.class).invoke(clazz.getMethod("getRuntime").invoke(clazz),
                "fsearch");
    }
}
