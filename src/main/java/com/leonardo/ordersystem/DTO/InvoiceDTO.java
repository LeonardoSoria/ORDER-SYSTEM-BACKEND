package com.leonardo.ordersystem.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class InvoiceDTO {

    private String fullName;
    private String nit;
    private Double total;
    private List<RegisterSaleDTO> registerSaleDTOList;
}
