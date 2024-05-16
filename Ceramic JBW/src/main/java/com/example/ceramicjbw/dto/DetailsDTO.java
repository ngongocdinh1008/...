package com.example.ceramicjbw.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailsDTO {
    private int id;

    @NotBlank(message = "Yêu cầu nhập Tiêu đề!!")
    private String title;

    @NotBlank(message = "Yêu cầu nhập Thông Tin!!")
    private String information;
}
