package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉:
 * 〈部门实体类,使用lombok〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/14  10:40
 */

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long id;//主键
    private String deptName;//部门名称
    private String dbSource;//使用的数据库名称

}
