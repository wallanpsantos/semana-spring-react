package com.org.backend.dto;

import com.org.backend.entities.Seller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaleSuccessDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sellerNamename;
    private Long visited;
    private Long deals;

    public SaleSuccessDTO(Seller seller, Long visited, Long deals) {
        this.sellerNamename = seller.getName();
        this.visited = visited;
        this.deals = deals;
    }
}
