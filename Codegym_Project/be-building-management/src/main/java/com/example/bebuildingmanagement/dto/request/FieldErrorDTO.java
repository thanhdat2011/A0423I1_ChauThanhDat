package com.example.bebuildingmanagement.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class FieldErrorDTO {
    private String field;
    private int code;
    private String message;
}
