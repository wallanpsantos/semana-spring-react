package com.org.backend.repositories;

import com.org.backend.entities.Sale;
import com.org.backend.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
