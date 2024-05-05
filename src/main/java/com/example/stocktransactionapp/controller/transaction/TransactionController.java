package com.example.stocktransactionapp.controller.transaction;

import com.example.stocktransactionapp.datasource.security.model.User;
import com.example.stocktransactionapp.dto.transaction.TransactionDto;
import com.example.stocktransactionapp.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/buy")
    public ResponseEntity<Void> placeBuyTransaction(
            @RequestBody TransactionDto transactionDto,
            @AuthenticationPrincipal User user) {

        transactionService.placeBuyTransaction(user.getId(), transactionDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/sell")
    public ResponseEntity<Void> placeSellTransaction(
            @RequestBody TransactionDto transactionDto,
            @AuthenticationPrincipal User user) {

        transactionService.placeSellTransaction(user.getId(), transactionDto);
        return ResponseEntity.ok().build();
    }
}
