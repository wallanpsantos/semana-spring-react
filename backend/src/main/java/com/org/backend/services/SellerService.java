package com.org.backend.services;

import com.org.backend.dto.SellerDTO;
import com.org.backend.entities.Seller;
import com.org.backend.repositories.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SellerService {

    private SellerRepository sellerRepository;

    public List<SellerDTO> findAll() {
        List<Seller> sellers = sellerRepository.findAll();

        return sellers.stream().map(SellerDTO::new).collect(Collectors.toList());
    }
}
