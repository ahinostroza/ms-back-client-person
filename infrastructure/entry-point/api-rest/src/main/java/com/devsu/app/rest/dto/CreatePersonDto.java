package com.devsu.app.rest.dto;

import com.devsu.app.rest.config.ValidationConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePersonDto {
    @NotNull(message = "DVV001")
    @NotBlank(message = "DVV002")
    @Pattern(regexp = ValidationConstants.ALPHANUMERIC)
    @Size(max = 50)
    private String name;

    @NotNull(message = "DVV003")
    @NotBlank(message = "DVV004")
    private String gender;

    @NotNull(message = "DVV005")
    private Integer age;

    @NotNull(message = "DVV006")
    @NotBlank(message = "DVV007")
    private String document;

    @NotNull(message = "DVV008")
    @NotBlank(message = "DVV009")
    private String address;

    @NotNull(message = "DVV010")
    @NotBlank(message = "DVV011")
    @Pattern(regexp = "^[0-9+-]*$", message = "DVV012")
    private String phone;
}
