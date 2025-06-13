package com.example.relations.controllers;

import com.example.relations.DTO.UserDTO;
import com.example.relations.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Tag(name = "USER API", description = "CRUD операции паспорта")
public class UserController {
    private final UserService userService;

    @Operation(summary = "Find all users", description = "Find all users for users", responses = {
            @ApiResponse(responseCode = "200", description = "User was find successful")})
    @GetMapping
    public ResponseEntity<List<UserDTO>> getUser(){
        return ResponseEntity.ok().body(userService.getAll());
    }

    @Operation(summary = "Find user by id", description = "Find user by id for users", responses = {
            @ApiResponse(responseCode = "200", description = "User was found successful"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @GetMapping("/{id}")
    public  ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @Operation(summary = "Create user", description = "Create new user for users", responses = {
            @ApiResponse(responseCode = "200", description = "User was created successful"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return  ResponseEntity.ok().body((userService.create(userDTO)));
    }

    @Operation(summary = "Update User", description = "Update user for users", responses = {
            @ApiResponse(responseCode = "200", description = "User was update successful"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @GetMapping("/{id}")
    public  ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return ResponseEntity.ok().body(userService.update(id, userDTO));
    }

    @Operation(summary = "Delete User", description = "Delete user for users", responses = {
            @ApiResponse(responseCode = "200", description = "User was deleted successful"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @GetMapping("/{id}")
    public  ResponseEntity<UserDTO> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
