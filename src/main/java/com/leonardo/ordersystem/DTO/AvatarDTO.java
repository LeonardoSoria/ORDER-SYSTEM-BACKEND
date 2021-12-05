package com.leonardo.ordersystem.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AvatarDTO {

    private Long id;
    private String name;
    private Long faceId;
    private Long hatId;
    private Long eyeId;
    private Long mouthId;
    private Long noseId;
    private Long mustacheId;
    private Long userId;
}
