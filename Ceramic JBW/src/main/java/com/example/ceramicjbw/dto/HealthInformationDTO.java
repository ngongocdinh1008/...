package com.example.ceramicjbw.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HealthInformationDTO {

    @NotBlank(message = "Yêu cầu nhập Tên!!")
    private String name;

    @NotBlank(message = "Yêu cầu nhập Thông tin!!")
    private String information;

    @NotBlank(message = "Yêu cầu nhập Danh mục!!")
    private String category;

    private byte[] image;

    private List<String> keyword;
    private List<DetailsDTO> details;
}
