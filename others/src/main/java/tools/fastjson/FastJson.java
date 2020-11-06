/**
 * Author:   80303990
 * Date:     2020/11/6 11:12
 * Description: fastJson的用法
 */
package tools.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import entity.Album;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FastJson {
    @Test
    public void testM() {

        Map<String, Map<String, Album>> originMap1 = new HashMap();
        Map<String, Album> oringinMap2 = new HashMap();
        Album a1 = new Album();
        a1.setAlbumName("哈哈哈");
        a1.setCreatedAt(12345);
        Album a2 = new Album();
        a2.setAlbumName("嘻嘻嘻");
        a2.setCreatedAt(54321);

        oringinMap2.put("field1", a1);
        oringinMap2.put("field2", a2);
        originMap1.put("key", oringinMap2);


        String jsonStr = JSON.toJSONString(originMap1);
        System.out.println(jsonStr);
        Map<String, Map<String, Album>> getMapFromFJ = JSON.parseObject(jsonStr, new TypeReference<Map<String, Map<String, Album>>>() {
        });
        System.out.println(getMapFromFJ.getClass());
        System.out.println(getMapFromFJ.get("key"));
        System.out.println(getMapFromFJ.get("key").get("field1").getActor());
    }
}