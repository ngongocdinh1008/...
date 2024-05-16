package com.example.ceramicjbw.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {
    @JsonProperty("fullname")
    private String userName;

    @JsonProperty("phone_number")
    @NotBlank(message = "Yêu cầu nhập Số điện thoại!!")
    private String phoneNumber;

    @NotBlank(message = "Yêu cầu nhập mật khẩu!!")
    private String password;

    @NotBlank(message = "Yêu cầu nhập lại Mật khẩu!!")
    private String retypePassword;

    @JsonProperty("facebook_account_id")
    private int FacebookAccountId;

    @JsonProperty("google_account_id")
    private int GoogleAccountId;

    @JsonProperty("role_id")
    private Long roleId;
}
