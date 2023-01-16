package design.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface AbstractAppController {
    @PostMapping("login")
    String login(
            @RequestParam("userID") String userID,
            @RequestParam("password") String password,
            @RequestParam("role") int role
    );
}
