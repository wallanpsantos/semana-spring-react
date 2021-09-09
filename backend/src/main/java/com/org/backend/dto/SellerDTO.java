package com.org.backend.dto;

import com.org.backend.entities.Seller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SellerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public SellerDTO(Seller seller) {
        this.id = seller.getId();
        this.name = seller.getName();
    }
}
