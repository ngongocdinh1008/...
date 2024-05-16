package com.example.ceramicjbw.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiseasesDTO {
    @NotBlank(message = "Yêu cầu nhập Tên Bệnh!!")
    private String name;

    @NotBlank(message = "Yêu cầu nhập Thông tin Bệnh!!")
    private String information;

    @NotBlank(message = "Yêu cầu nhập Nguyên nhân về Bệnh!!")
    private String cause;

    @NotBlank(message = "Yêu cầu nhập Triệu chứng về Bệnh!!")
    private String symptoms;

    @NotBlank(message = "Yêu cầu nhập Đối tượng thường gặp")
    private String object;

    @NotBlank(message = "Yêu cầu nhập Biện pháp phòng ngừa Bệnh!!")
    private String preventionMeasures;

    @NotBlank(message = "Yêu cầu nhập Loại!!")
    private String kind;

    // ảnh
}
