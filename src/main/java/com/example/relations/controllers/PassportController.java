package com.example.relations.controllers;

import com.example.relations.DTO.PassportDTO;
import com.example.relations.services.PassportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/passport")
@Tag(name = "PASSPORT API", description = "CRUD операции паспорта")
public class PassportController {
    private final PassportService passportService;

    @Operation(summary = "Find all passports", description = "Find all passports for users", responses = {
            @ApiResponse(responseCode = "200", description = "Passport was find successful")})
    @GetMapping
    public ResponseEntity<List<PassportDTO>> getPassport(){
        return ResponseEntity.ok().body(passportService.getAll());
    }

    @Operation(summary = "Find passport by id", description = "Find passport by id for users", responses = {
            @ApiResponse(responseCode = "200", description = "Passport was found successful"),
            @ApiResponse(responseCode = "404", description = "Passport not found")})
    @GetMapping("/{id}")
    public  ResponseEntity<PassportDTO> getPassportById(@PathVariable Long id){
        return ResponseEntity.ok().body(passportService.findById(id));
    }

    @Operation(summary = "Create passport", description = "Create new passport for users", responses = {
            @ApiResponse(responseCode = "200", description = "Passport was created successful"),
            @ApiResponse(responseCode = "404", description = "Passport not found")})
    @PostMapping
    public ResponseEntity<PassportDTO> createPassport(@RequestBody PassportDTO passportDTO){
        return  ResponseEntity.ok().body((passportService.create(passportDTO)));
    }

    @Operation(summary = "Update Passport", description = "Update passport for users", responses = {
            @ApiResponse(responseCode = "200", description = "Passport was update successful"),
            @ApiResponse(responseCode = "404", description = "Passport not found")})
    @GetMapping("/{id}")
    public  ResponseEntity<PassportDTO> updatePassport(@PathVariable Long id, @RequestBody PassportDTO passportDTO){
        return ResponseEntity.ok().body(passportService.update(id, passportDTO));
    }

    @Operation(summary = "Delete Passport", description = "Delete passport for users", responses = {
            @ApiResponse(responseCode = "200", description = "Passport was deleted successful"),
            @ApiResponse(responseCode = "404", description = "Passport not found")})
    @GetMapping("/{id}")
    public  ResponseEntity<PassportDTO> deletePassport(@PathVariable Long id){
        passportService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
