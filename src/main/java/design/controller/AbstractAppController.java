package design.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface AbstractAppController {
    @GetMapping("login")
    void login();

    //系统要求相关
    @GetMapping("getUserType")
    int getUserType();

    @GetMapping("getVolunteerNumber")
    int getVolunteerNumber();

    @GetMapping("getProjectFounding")
    double getProjectFounding();

    @GetMapping("getAcademicExchange")
    int getAcademicExchange();

    @GetMapping("editVolunteerNumber")
    boolean editVolunteerNumber();

    @GetMapping("editProjectFounding")
    boolean editProjectFounding();

    @GetMapping("editAcademicExchange")
    boolean editAcademicExchange();
}
