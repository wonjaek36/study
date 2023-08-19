package com.example.firstproject.dto;

import com.example.firstproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {

    private String username;
    private String password;

    public Member toEntity() {
        return new Member(null, username, password);
    }
}
