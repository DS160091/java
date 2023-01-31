package com.shiro.ds.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountUser implements Serializable {

    private int id;
    private String name;
    private String pwd;
    private String role;

}
