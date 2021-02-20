package com.shaoteemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo.pojo
 *
 * @author Smart-T
 * @since 2020/12/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Integer userId;

    private String userName;

}
