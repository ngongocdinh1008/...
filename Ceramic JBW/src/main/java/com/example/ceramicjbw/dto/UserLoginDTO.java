package com.example.ceramicjbw.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    @JsonProperty("phone_number")
    @NotBlank(message = "Yêu cầu nhập Số điện thoại!!")
    private int phoneNumber;

    @NotBlank(message = "Yêu cầu nhập Mật khẩu!! ")
    private String password;

}
