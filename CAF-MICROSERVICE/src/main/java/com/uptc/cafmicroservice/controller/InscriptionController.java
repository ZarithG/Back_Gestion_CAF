package com.uptc.cafmicroservice.controller;

import com.uptc.cafmicroservice.dto.InscriptionDTO;
import com.uptc.cafmicroservice.dto.UserResponseDTO;
import com.uptc.cafmicroservice.entity.Inscription;
import com.uptc.cafmicroservice.enums.ConsentTypeEnum;
import com.uptc.cafmicroservice.enums.InscriptionStatusEnum;
import com.uptc.cafmicroservice.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/caf/inscription")
public class InscriptionController {
    @Autowired
    InscriptionService inscriptionService;

    @PostMapping("/inscribe-user/{email}")
    public ResponseEntity<InscriptionDTO> inscribeUserInFitnessCenter(@RequestBody InscriptionDTO inscriptionDTO, @PathVariable String email) {
//        InscriptionDTO inscriptionDTOResponse = inscriptionService.inscribeUserInFitnessCenter(inscriptionDTO, email);
//        if (inscriptionDTOResponse == null) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(inscriptionDTOResponse);
        return ResponseEntity.ok(InscriptionDTO.builder().id(2).
                build());
    }

    @PostMapping("/accept-inscription/{inscriptionId}")
    public ResponseEntity<InscriptionDTO> acceptUserInscription(@PathVariable("inscriptionId") int inscriptionId) {
        Inscription inscription = inscriptionService.changeUserInscription(inscriptionId, InscriptionStatusEnum.ACCEPTED);
        if (inscription == null) {
            return ResponseEntity.noContent().build();
        }
        InscriptionDTO inscriptionDTO = new InscriptionDTO();
        inscriptionDTO.setId(inscription.getId());
        inscriptionDTO.setInscriptionStatus(inscription.getInscriptionStatus());
        return ResponseEntity.ok(inscriptionDTO);
    }

    @PostMapping("/reject-inscription/{inscriptionId}")
    public ResponseEntity<InscriptionDTO> rejectUserInscription(@PathVariable("inscriptionId") int inscriptionId) {
        Inscription inscription = inscriptionService.changeUserInscription(inscriptionId, InscriptionStatusEnum.REJECTED);
        if (inscription == null) {
            return ResponseEntity.noContent().build();
        }
        InscriptionDTO inscriptionDTO = new InscriptionDTO();
        inscriptionDTO.setId(inscription.getId());
        inscriptionDTO.setInscriptionStatus(inscription.getInscriptionStatus());
        return ResponseEntity.ok(inscriptionDTO);
    }

    @PostMapping("/inactive-inscription/{inscriptionId}")
    public ResponseEntity<InscriptionDTO> inactiveUserInscription(@PathVariable("inscriptionId") int inscriptionId) {
        Inscription inscription = inscriptionService.changeUserInscription(inscriptionId, InscriptionStatusEnum.INACTIVE);
        if (inscription == null) {
            return ResponseEntity.noContent().build();
        }
        InscriptionDTO inscriptionDTO = new InscriptionDTO();
        inscriptionDTO.setId(inscription.getId());
        inscriptionDTO.setInscriptionStatus(inscription.getInscriptionStatus());
        return ResponseEntity.ok(inscriptionDTO);
    }

    @GetMapping("/all/{email}")
    public ResponseEntity<List<InscriptionDTO>> getAllUserInscriptions(@PathVariable("email") String email) {
        List<InscriptionDTO> inscriptions = inscriptionService.getAllUserInscriptions(email);
        if (inscriptions == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(inscriptions);
    }
}
