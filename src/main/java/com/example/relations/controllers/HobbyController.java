package com.example.relations.controllers;

import com.example.relations.DTO.HobbyDTO;
import com.example.relations.services.HobbyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hobby")
@Tag(name = "HOBBY API", description = "CRUD операции хобби")
public class HobbyController {
    private final HobbyService hobbyService;

    @Operation(summary = "Find all hobby", description = "Find all hobby for users", responses = {
            @ApiResponse(responseCode = "200", description = "hobby was find successful")})
    @GetMapping
    public ResponseEntity<List<HobbyDTO>> getHobby(){
        return ResponseEntity.ok().body(hobbyService.getAll());
    }

    @Operation(summary = "Find hobby by id", description = "Find hobby by id for users", responses = {
            @ApiResponse(responseCode = "200", description = "Hobby was found successful"),
            @ApiResponse(responseCode = "404", description = "Hobby not found")})
    @GetMapping("/{id}")
    public  ResponseEntity<HobbyDTO> getHobbyById(@PathVariable Long id){
        return ResponseEntity.ok().body(hobbyService.findById(id));
    }

    @Operation(summary = "Create hobby", description = "Create new hobby for users", responses = {
            @ApiResponse(responseCode = "200", description = "Hobby was created successful"),
            @ApiResponse(responseCode = "404", description = "Hobby not found")})
    @PostMapping
    public ResponseEntity<HobbyDTO> createHobby(@RequestBody HobbyDTO hobbyDTO){
        return  ResponseEntity.ok().body((hobbyService.create(hobbyDTO)));
    }

    @Operation(summary = "Update Hobby", description = "Update hobby for users", responses = {
            @ApiResponse(responseCode = "200", description = "Hobby was update successful"),
            @ApiResponse(responseCode = "404", description = "Hobby not found")})
    @GetMapping("/{id}")
    public  ResponseEntity<HobbyDTO> updatehobby(@PathVariable Long id, @RequestBody HobbyDTO hobbyDTO){
        return ResponseEntity.ok().body(hobbyService.update(id, hobbyDTO));
    }

    @Operation(summary = "Delete Hobby", description = "Delete hobby for users", responses = {
            @ApiResponse(responseCode = "200", description = "Hobby was deleted successful"),
            @ApiResponse(responseCode = "404", description = "Hobby not found")})
    @GetMapping("/{id}")
    public  ResponseEntity<HobbyDTO> deletehobby(@PathVariable Long id){
        hobbyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
