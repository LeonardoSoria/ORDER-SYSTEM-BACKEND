package com.leonardo.ordersystem.controller;

import com.leonardo.ordersystem.DTO.AvatarDTO;
import com.leonardo.ordersystem.DTO.AvatarGetDTO;
import com.leonardo.customavatar.entity.*;
import com.leonardo.ordersystem.service.AvatarService;
import com.leonardo.ordersystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class AvatarController {

    @Autowired
    private AvatarService avatarService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/saveAvatar")
    public ResponseEntity<Avatar> saveAvatar(@RequestBody AvatarDTO avatarDTO) {
        return ok(avatarService.createAvatar(avatarDTO));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/deleteAvatar")
    public ResponseEntity<Boolean> deleteAvatar(@RequestParam Long avatarId) {
        return ok(avatarService.deleteAvatar(avatarId));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAvatarsByUserId")
    public ResponseEntity<List<AvatarGetDTO>> getAvatarsByUserId(@RequestParam long userId) {
        return ok(avatarService.getAvatarByUserId(userId));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getHats")
    public ResponseEntity<List<Hat>> getHats() {
        return ok(avatarService.getAllHat());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getFaces")
    public ResponseEntity<List<Face>> getFaces() {
        return ok(avatarService.getAllFaces());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getEyes")
    public ResponseEntity<List<Eye>> getEyes() {
        return ok(avatarService.getAllEyes());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getNose")
    public ResponseEntity<List<Nose>> getNose() {
        return ok(avatarService.getAllNose());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getMouths")
    public ResponseEntity<List<Mouth>> getMouths() {
        return ok(avatarService.getAllMouths());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getMustaches")
    public ResponseEntity<List<Mustache>> getMustaches() {
        return ok(avatarService.getAllMustaches());
    }

}
