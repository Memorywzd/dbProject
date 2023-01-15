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
}
