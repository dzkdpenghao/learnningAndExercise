package com.example.service;

import com.example.entity.Dept;

import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈部门service接口〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/14  14:46
 */

public interface DeptService {
    boolean add(Dept dept);
    Dept    get(Long id);
    List<Dept> list();
}
