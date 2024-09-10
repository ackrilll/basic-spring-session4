package com.sparta.basicspringsession4.dto;

import lombok.Getter;

@Getter
public class MemberGetResponseDto {
    private final String name;

    public MemberGetResponseDto(String name) {
        this.name = name;
    }
}
