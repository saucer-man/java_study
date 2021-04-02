package class1;

import java.util.Arrays;
import java.util.List;

public class ExecProcessBuilder {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("java.lang.ProcessBuilder");
       ((ProcessBuilder)clazz.getConstructor(List.class).newInstance(Arrays.asList("fsearch"))).start();

       // or
      clazz.getMethod("start").invoke(clazz.getConstructor(List.class).newInstance(
                Arrays.asList("fsearch")));
    }

}
