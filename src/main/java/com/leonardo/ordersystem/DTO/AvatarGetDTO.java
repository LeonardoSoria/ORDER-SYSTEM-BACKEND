package com.leonardo.ordersystem.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AvatarGetDTO {

    private Long id;
    private String name;
    private PartDTO faceType;
    private PartDTO hatType;
    private PartDTO eyeType;
    private PartDTO mouthType;
    private PartDTO noseType;
    private PartDTO mustacheType;
    private Long userId;
}
