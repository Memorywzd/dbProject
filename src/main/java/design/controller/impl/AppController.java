package design.controller.impl;

import design.controller.AbstractAppController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")

public class AppController implements AbstractAppController {
    /**
     *
     */
    @Override
    public void login() {

    }

    /**
     * @return
     */
    @Override
    public int getUserType() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public int getVolunteerNumber() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public double getProjectFounding() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public int getAcademicExchange() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public boolean editVolunteerNumber() {
        return false;
    }

    /**
     * @return
     */
    @Override
    public boolean editProjectFounding() {
        return false;
    }

    /**
     * @return
     */
    @Override
    public boolean editAcademicExchange() {
        return false;
    }
}
