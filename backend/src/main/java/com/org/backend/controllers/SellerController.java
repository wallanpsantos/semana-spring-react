package com.org.backend.controllers;

import com.org.backend.dto.SellerDTO;
import com.org.backend.services.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sellers")
@AllArgsConstructor
public class SellerController {

    private SellerService sellerService;

    @GetMapping
    public ResponseEntity<List<SellerDTO>> findAll() {
        List<SellerDTO> sellerDTOS = sellerService.findAll();

        return ResponseEntity.ok(sellerDTOS);
    }

}
