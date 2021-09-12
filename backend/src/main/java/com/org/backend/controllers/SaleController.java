package com.org.backend.controllers;

import com.org.backend.dto.SaleDTO;
import com.org.backend.dto.SaleSuccessDTO;
import com.org.backend.dto.SaleSumDTO;
import com.org.backend.services.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/sales")
public class SaleController {

    private static final String INITIAL_PAGE = "0";
    private static final String PAGE_SIZE = "20";
    private static final String SORT_BY_ASC = "visited";

    private SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(
            @RequestParam(defaultValue = INITIAL_PAGE) Integer page,
            @RequestParam(defaultValue = PAGE_SIZE) Integer size,
            @RequestParam(defaultValue = SORT_BY_ASC) String sort
    ) {
        Page<SaleDTO> saleDTOS = saleService.findAll(page, size, sort);
        return new ResponseEntity<>(saleDTOS, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
        List<SaleSumDTO> saleSumDTOS = saleService.amountGroupedBySeller();
        return ResponseEntity.ok(saleSumDTOS);
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> sucessGroupedBySeller() {
        List<SaleSuccessDTO> saleSuccessDTOS = saleService.sucessGroupedBySeller();
        return ResponseEntity.ok(saleSuccessDTOS);
    }

}
