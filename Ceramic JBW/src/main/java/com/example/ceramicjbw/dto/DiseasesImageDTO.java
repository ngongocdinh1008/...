package com.example.ceramicjbw.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiseasesImageDTO {
    private int id;

    @JsonProperty("image_url")
    private String urlImage;

    // Diseases_id

}
