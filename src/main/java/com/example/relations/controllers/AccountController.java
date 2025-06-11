package com.example.relations.controllers;

import com.example.relations.DTO.AccountDTO;
import com.example.relations.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
@Tag(name = "ACCOUNT API", description = "CRUD операции паспорта")
public class AccountController {
    private final AccountService accountService;

    @Operation(summary = "Find all accounts", description = "Find all accounts for users", responses = {
            @ApiResponse(responseCode = "200", description = "Account was find successful")})
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAccount(){
        return ResponseEntity.ok().body(accountService.getAll());
    }

    @Operation(summary = "Find account by id", description = "Find account by id for users", responses = {
            @ApiResponse(responseCode = "200", description = "Account was found successful"),
            @ApiResponse(responseCode = "404", description = "Account not found")})
    @GetMapping("/{id}")
    public  ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
        return ResponseEntity.ok().body(accountService.findById(id));
    }

    @Operation(summary = "Create account", description = "Create new account for users", responses = {
            @ApiResponse(responseCode = "200", description = "Account was created successful"),
            @ApiResponse(responseCode = "404", description = "Account not found")})
    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO){
        return  ResponseEntity.ok().body((accountService.create(accountDTO)));
    }

    @Operation(summary = "Update Account", description = "Update account for users", responses = {
            @ApiResponse(responseCode = "200", description = "Account was update successful"),
            @ApiResponse(responseCode = "404", description = "Account not found")})
    @GetMapping("/{id}")
    public  ResponseEntity<AccountDTO> updateAccount(@PathVariable Long id, @RequestBody AccountDTO accountDTO){
        return ResponseEntity.ok().body(accountService.update(id, accountDTO));
    }

    @Operation(summary = "Delete Account", description = "Delete account for users", responses = {
            @ApiResponse(responseCode = "200", description = "Account was deleted successful"),
            @ApiResponse(responseCode = "404", description = "Account not found")})
    @GetMapping("/{id}")
    public  ResponseEntity<AccountDTO> deleteAccount(@PathVariable Long id){
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
