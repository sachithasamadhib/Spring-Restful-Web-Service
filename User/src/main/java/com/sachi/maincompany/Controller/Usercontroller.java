package com.sachi.maincompany.Controller;

import com.sachi.maincompany.Dto.UserDTO;
import com.sachi.maincompany.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/")
public class Usercontroller {

    @Autowired
    private UserService UserService;

    @GetMapping("/getalluser")
    public List<UserDTO> getallUser() {
        return UserService.getAllUsers();
    }

    @GetMapping("/getuser/{userid}")
    public UserDTO getuserid(@PathVariable int userid) {
        return UserService.getuserbyid(userid);
    }

    @GetMapping("/hi")
    public String hi() {
        return "Hi";
    }

    @PostMapping("/adduser")
    public UserDTO adduser(@RequestBody UserDTO user) {
        return UserService.saveuser(user);

    }

    @PutMapping("/updateuser")
    public UserDTO updateuser(@RequestBody UserDTO user) {
        return UserService.updateuser(user);
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteuser (@PathVariable int id) {
        return UserService.deleteuser(id);
    }

}
