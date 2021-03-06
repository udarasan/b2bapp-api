package lk.nsbm.b2bappapi.controller;


import lk.nsbm.b2bappapi.dto.UserDTO;
import lk.nsbm.b2bappapi.dto.UserResponseDTO;
import lk.nsbm.b2bappapi.service.UserService;
import lk.nsbm.b2bappapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/registerUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody UserDTO dto) {
        userService.registerUser(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllUsers() {
        ArrayList<UserDTO> allUsers = userService.getAllUsers();
        return new ResponseEntity(new StandardResponse("200", "Done", allUsers), HttpStatus.OK);
    }


    @GetMapping(path = "/login")
    public ResponseEntity loginUser(@RequestParam String email, @RequestParam String password) {
        UserResponseDTO userResponseDTO = userService.matchesEmail(email, password);
        return new ResponseEntity(new StandardResponse("202", "Done", userResponseDTO), HttpStatus.ACCEPTED);


    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchUser(@PathVariable String id) {
        UserDTO userDTO = userService.searchUser(id);
        return new ResponseEntity(new StandardResponse("200", "Done", userDTO), HttpStatus.OK);
    }


    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @PutMapping(path = ("/updateUser"),consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody UserDTO dto) {
        userService.updateUser(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }
    @PutMapping(path = "/resetPassword")
    public ResponseEntity resetPassword(@RequestParam String email, @RequestParam String password) {
        userService.updatePassword(email, password);
        System.out.println(email);
        System.out.println(password);
        return new ResponseEntity(new StandardResponse("202", "Done", null), HttpStatus.ACCEPTED);


    }

    @GetMapping(path = ("/getAllShops"),produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllShops(@RequestParam String userType) {
        ArrayList<UserDTO> allShops= userService.getAllShops(userType);
        return new ResponseEntity(new StandardResponse("200", "Done", allShops), HttpStatus.OK);
    }
}
