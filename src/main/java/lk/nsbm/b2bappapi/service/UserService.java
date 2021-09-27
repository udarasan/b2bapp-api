package lk.nsbm.b2bappapi.service;

import lk.nsbm.b2bappapi.dto.UserDTO;
import lk.nsbm.b2bappapi.dto.UserResponseDTO;

import java.util.ArrayList;

public interface UserService {
    void registerUser(UserDTO dto);

    ArrayList<UserDTO> getAllUsers();

    UserResponseDTO matchesEmail(String email, String password);

    boolean nicAlreadyExists(int nic);

    void deleteUser(int id);

    UserDTO searchUser(String id);

    void updateUser(UserDTO dto);

    int getAvailableEmployeeCount();

    void updatePassword(String Email,String password);
}
