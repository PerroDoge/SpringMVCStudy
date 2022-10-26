package com.mws.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Player {
    private Integer id;
    private String name;
    private String password;
    private String nickname;
    private String icon;
    private String filetype;
}
