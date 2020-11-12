/**
 * Author:   80303990
 * Date:     2020/11/11 14:16
 * Description:
 */
package stream;

import entity.Student;
import org.junit.Test;

import java.util.*;

public class TestClass {

    @Test
    public void testM1() {
        Map<String, Student> studentMap = new HashMap<>();

        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student s = new Student(i, new Random().nextInt(25), "stu****" + i);
            studentList.add(s);
        }

        studentList.parallelStream().forEach(student ->
                studentMap.put(student.getId().toString(), student));

        System.out.println(studentMap);
    }

    @Test
    public void testM2() {

//        variableParam(new int[]{1,2,3,4});
        variableParamStr("qqq", "aaa", "sss");
    }


    public void variableParam(int... nums) {
        int res = 0;
        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                res += nums[i];
            }
        }
        System.out.println(res);
    }

    public void variableParamStr(String... strs) {
        List<String> list = Arrays.asList(strs);
        System.out.println(list.contains("sss"));
    }

}