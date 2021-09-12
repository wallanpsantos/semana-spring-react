package com.org.backend.services;

import com.org.backend.dto.SaleDTO;
import com.org.backend.dto.SaleSuccessDTO;
import com.org.backend.dto.SaleSumDTO;
import com.org.backend.entities.Sale;
import com.org.backend.repositories.SaleRepository;
import com.org.backend.repositories.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleService {

    private SaleRepository saleRepository;

    private SellerRepository sellerRepository;

    /**
     * Metodo responsavel por buscar e paginar informacoes de vendas e vendedores.
     * A anotacao  @Transactional(readOnly = true) garante que toda opercacao do banco
     * seja resolvida no service e o readOnly = true é para não fazer lock (escrita) no banco
     *
     * @param initialPage
     * @param pageSize
     * @param sortBy
     * @return Page<SaleDTO>
     */
    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Integer initialPage, Integer pageSize, String sortBy) {
        sellerRepository.findAll(); // Busca vendedores para armazenar em cache, melhorar o desempenho do Page
        Pageable pageable = PageRequest.of(initialPage, pageSize, Sort.by(sortBy));
        Page<Sale> sales = saleRepository.findAll(pageable);
        return sales.map(SaleDTO::new);
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        return saleRepository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> sucessGroupedBySeller() {
        return saleRepository.sucessGroupedBySeller();
    }

}
