package design.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface AbstractAppController {
    @PostMapping("login")
    void login();

    //系统要求相关
    @GetMapping("getUserType")
    int getUserType();
}
