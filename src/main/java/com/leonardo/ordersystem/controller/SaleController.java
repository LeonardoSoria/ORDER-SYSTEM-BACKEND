package com.leonardo.ordersystem.controller;

import com.leonardo.ordersystem.DTO.ComboDTO;
import com.leonardo.ordersystem.DTO.InvoiceDTO;
import com.leonardo.ordersystem.DTO.RegisterSaleDTO;
import com.leonardo.ordersystem.service.SaleService;
import com.leonardo.ordersystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/registerSale")
    public ResponseEntity<Sale> registerSale(@RequestBody InvoiceDTO invoiceData) {
        return ok(saleService.registerSale(invoiceData));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getCombos")
    public ResponseEntity<List<ComboDTO>> getCombos() { //@RequestParam long userId
        return ok(saleService.getCombos());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getPortions")
    public ResponseEntity<List<Portion>> getPortions() { //@RequestParam long userId
        return ok(saleService.getPortions());
    }

}
