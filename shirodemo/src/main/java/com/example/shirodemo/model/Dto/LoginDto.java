package com.example.shirodemo.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author kn
 * @ Description
 * @ Date 2019/7/23 15:19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String nickname;
    private String password;
    private Integer id;
}
