package com.sachi.maincompany.Service;

import com.sachi.maincompany.Dto.UserDTO;
import com.sachi.maincompany.Model.User;
import com.sachi.maincompany.Repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers(){
        List<User> usersList = userRepo.findAll();
        return modelMapper.map(usersList, new TypeToken<List<UserDTO>>() {}.getType());
    }

    public UserDTO saveuser(UserDTO user) {
        userRepo.save(modelMapper.map(user, User.class));
        return user;
    }

    public UserDTO updateuser(UserDTO user) {
        userRepo.save(modelMapper.map(user, User.class));
        return user;
    }

    public String deleteuser(int id){
        try {
            if(userRepo.existsById(id)){
                userRepo.deleteById(id);
                return "Deleted Successfully";
            } else {
                return "User with ID " + id + " not found";
            }
        } catch (Exception e) {
            return "Error deleting user: " + e.getMessage();
        }
    }
    public UserDTO getuserbyid(int id) {
        User user = userRepo.getuserbyid(id);
        return modelMapper.map(user,UserDTO.class);
    }

}
