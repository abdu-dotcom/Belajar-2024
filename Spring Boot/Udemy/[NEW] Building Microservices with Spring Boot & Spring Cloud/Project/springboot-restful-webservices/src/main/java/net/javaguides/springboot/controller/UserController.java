package net.javaguides.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(
        name = "CRUD REST APIs for user Resource",
        description = "CRUD REST APIs - Create User, Update User, Get All Users, Delete User"
)

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/users",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;

    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save user in a database"
    )

    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    // build create User REST API
    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get User By ID REST API",
            description = "Get User By ID REST API is used to get a single user from database"
    )

    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 SUCCESS"
    )

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {

        System.out.printf("userId: " + userId);
        UserDto user = userService.getUserById(userId);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Users  REST API",
            description = "Get All User REST API is used to get all the users from the database"
    )

    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 SUCCESS"
    )

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();

        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @Operation(
            summary = "Update User  REST API",
            description = "Update User REST API is used to update a particular user in the database"
    )

    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 200 SUCCESS"
    )
    // Build Update User REST API
    // http://localhost:8080/api/users/1
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody @Valid   UserDto user) {
        user.setId(userId);
        UserDto updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User  REST API",
            description = "Delete User REST API is used to delete a particular user in the database"
    )

    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 200 SUCCESS"
    )
    // Build Delete User REST API
    // http://localhost:8080/api/users/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

//    // Custome Handle Resource Not Found
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest){
//
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }
}
