package com.leonardo.ordersystem.service;

import com.leonardo.ordersystem.DTO.ComboDTO;
import com.leonardo.ordersystem.DTO.InvoiceDTO;
import com.leonardo.ordersystem.DTO.RegisterSaleDTO;
import com.leonardo.ordersystem.entity.*;
import com.leonardo.ordersystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private ComboRepository comboRepository;
    @Autowired
    private PortionRepository portionRepository;
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ComboHasPortionRepository comboHasPortionRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private SaleHasComboRepository saleHasComboRepository;

    public Sale registerSale(InvoiceDTO invoiceData) {
        List<ComboHasPortion> combosToRegister = new ArrayList<>();

        invoiceData.getRegisterSaleDTOList().forEach(registerSaleDTO -> {
            if (!registerSaleDTO.getPortionIds().isEmpty()) {
                for (int i = 0; i < registerSaleDTO.getPortionIds().size(); i++) {
                    Long auxId = registerSaleDTO.getPortionIds().get(i);
                    combosToRegister.add(comboHasPortionRepository.save(ComboHasPortion.builder()
                            .combo(Combo.builder().id(registerSaleDTO.getComboId()).build())
                            .portion(Portion.builder().id(auxId).build())
                            .build()));
                }
            } else {
                combosToRegister.add(comboHasPortionRepository.save(ComboHasPortion.builder()
                        .combo(Combo.builder().id(registerSaleDTO.getComboId()).build())
                        .build()));
            }
        });

        Invoice invoiceToRegister = invoiceRepository.save(Invoice.builder()
                .fullName(invoiceData.getFullName())
                .nit(invoiceData.getNit())
                .invoiceDate(LocalDate.now())
                .build());

        Sale saleToRegister = saleRepository.save(Sale.builder()
                .saleDate(LocalDate.now())
                .totalAmount(invoiceData.getTotal())
                .invoice(Invoice.builder().id(invoiceToRegister.getId()).build())
                .build());

        combosToRegister.forEach(comboHasPortion -> {
            saleHasComboRepository.save(SaleHasCombo.builder()
                    .sale(Sale.builder().id(saleToRegister.getId()).build())
                    .comboHasPortion(ComboHasPortion.builder().id(comboHasPortion.getId()).build())
                    .build());
        });
        return saleToRegister;
    }

    public List<ComboDTO> getCombos() {
        List<Combo> comboList = comboRepository.findAll();
        return comboList.stream().map(avatar -> mapComboEntityToComboDTO(avatar))
                .collect(Collectors.toList());
    }

    public List<Portion> getPortions() {
        List<Portion> portionList = portionRepository.findAll();
        return portionList;
    }

    public ComboDTO mapComboEntityToComboDTO(Combo combo) {
        return ComboDTO.builder()
                .id(combo.getId())
                .description(combo.getDescription())
                .price(combo.getPrice())
                .comboType(combo.getComboType())
                .build();
    }
}
