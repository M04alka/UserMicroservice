package ua.od.UserService.application.controller.read;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.od.UserService.infostructure.repository.UserRepository;

@RestController
@RequestMapping("user/read")
public class ControllerRead {

    private UserRepository userRepository;

    @GetMapping("/balance/{id}")
    public Double selectBook(@PathVariable String userId){
        UserRepository userRepository = new UserRepository();
        return userRepository.viewBalance(userId);
    }
}
