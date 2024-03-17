package com.kh.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Member {
    private String id;
    private String passwd;
    private String name;
    private String phone;
}
