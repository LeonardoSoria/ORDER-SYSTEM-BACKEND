package com.leonardo.ordersystem.service;

import com.leonardo.ordersystem.DTO.AvatarDTO;
import com.leonardo.ordersystem.DTO.AvatarGetDTO;
import com.leonardo.ordersystem.DTO.PartDTO;
import com.leonardo.customavatar.entity.*;
import com.leonardo.customavatar.repository.*;
import com.leonardo.ordersystem.entity.*;
import com.leonardo.ordersystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvatarService {

    @Autowired
    private AvatarRepository avatarRepository;
    @Autowired
    private MouthRepository mouthRepository;
    @Autowired
    private EyeRepository eyeRepository;
    @Autowired
    private HatRepository hatRepository;
    @Autowired
    private NoseRepository noseRepository;
    @Autowired
    private FaceRepository faceRepository;
    @Autowired
    private MustacheRepository mustacheRepository;

    public List<AvatarGetDTO> getAvatarByUserId(Long userId) {
        List<Avatar> avatarList = avatarRepository.findAvatarByUserId(userId);
        return avatarList.stream().map(avatar -> mapAvatarEntityToAvatarDTO(avatar))
                .collect(Collectors.toList());
    }

    public Avatar createAvatar(AvatarDTO avatar) {
        return avatarRepository.save(Avatar.builder()
                .name(avatar.getName())
                .face(Face.builder().id(avatar.getFaceId()).build())
                .nose(Nose.builder().id(avatar.getNoseId()).build())
                .mouth(Mouth.builder().id(avatar.getMouthId()).build())
                .eye(Eye.builder().id(avatar.getEyeId()).build())
                .hat(Hat.builder().id(avatar.getHatId()).build())
                .mustache(Mustache.builder().id(avatar.getMustacheId()).build())
                .user(User.builder().id(avatar.getUserId()).build())
                .build());
    }

    public boolean deleteAvatar(Long avatarId) {
        try {
            avatarRepository.deleteById(avatarId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Face> getAllFaces() {
        return faceRepository.findAll();
    }

    public List<Mouth> getAllMouths() {
        return mouthRepository.findAll();
    }

    public List<Nose> getAllNose() {
        return noseRepository.findAll();
    }

    public List<Eye> getAllEyes() {
        return eyeRepository.findAll();
    }

    public List<Hat> getAllHat() {
        return hatRepository.findAll();
    }

    public List<Mustache> getAllMustaches() {
        return mustacheRepository.findAll();
    }


    public AvatarGetDTO mapAvatarEntityToAvatarDTO(Avatar avatar) {
        return AvatarGetDTO.builder()
                .id(avatar.getId())
                .name(avatar.getName())
                .faceType(PartDTO.builder()
                        .id(avatar.getFace().getId())
                        .type(avatar.getFace().getType())
                        .build())
                .eyeType(PartDTO.builder()
                        .id(avatar.getEye().getId())
                        .type(avatar.getEye().getType())
                        .build())
                .noseType(PartDTO.builder()
                        .id(avatar.getNose().getId())
                        .type(avatar.getNose().getType())
                        .build())
                .mouthType(PartDTO.builder()
                        .id(avatar.getMouth().getId())
                        .type(avatar.getMouth().getType())
                        .build())
                .mustacheType(PartDTO.builder()
                        .id(avatar.getMustache().getId())
                        .type(avatar.getMustache().getType())
                        .build())
                .hatType(PartDTO.builder()
                        .id(avatar.getHat().getId())
                        .type(avatar.getHat().getType())
                        .build())
                .userId(avatar.getUser().getId())
                .build();
    }


}
