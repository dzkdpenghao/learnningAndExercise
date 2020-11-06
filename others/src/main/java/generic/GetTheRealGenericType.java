/**
 * Author:   80303990
 * Date:     2020/11/6 14:20
 * Description: 获取实际的泛型参数
 */
package generic;

import entity.BaseDemo;
import entity.SubDemo;
import org.junit.Test;

public class GetTheRealGenericType {

    @Test
    public void testM1() {
        //这样不会报错
        BaseDemo s = new SubDemo();
        System.out.println(s.getClazz());
    }

    @Test
    public void testM2() {
        //这样使用会报错：
        // java.lang.ClassCastException:
        //java.lang.Class cannot be cast to java.lang.reflect.ParameterizedType
        //所以，泛型应该在编译时就指定（如testM1()中所示），而不是运行时
        BaseDemo s = new BaseDemo<Integer>();
        System.out.println(s.getClazz());
    }

}