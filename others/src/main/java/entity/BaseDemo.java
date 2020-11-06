/**
 * Author:   80303990
 * Date:     2020/10/30 16:41
 * Description: 用于演示获取泛型参数的Base类
 */
package entity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseDemo<T> {
    private Class<T> clazz;
    private T t;

    //构造方法初始化，为clazz赋值：即获取实际的泛型参数类型
    public BaseDemo() {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType ptype = (ParameterizedType) type;
        Type[] actualTypeArguments = ptype.getActualTypeArguments();
        clazz = (Class<T>) actualTypeArguments[0];
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}