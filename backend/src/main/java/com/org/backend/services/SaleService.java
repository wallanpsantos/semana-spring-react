package com.org.backend.services;

import com.org.backend.dto.SaleDTO;
import com.org.backend.entities.Sale;
import com.org.backend.repositories.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaleService {

    private SaleRepository saleRepository;

    public Page<SaleDTO> findAll(Integer initialPage, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(initialPage, pageSize, Sort.by(sortBy));
        Page<Sale> sales = saleRepository.findAll(pageable);
        return sales.map(SaleDTO::new);
    }

}
