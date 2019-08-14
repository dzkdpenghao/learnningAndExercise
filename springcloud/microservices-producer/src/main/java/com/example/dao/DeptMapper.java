package com.example.dao;

import com.example.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈部门mapper接口〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/14  14:32
 */

@Mapper
public interface DeptMapper {
    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
