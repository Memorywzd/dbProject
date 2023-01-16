package design.controller.impl;

import design.DAO.impl.DAOFactory;
import design.controller.AbstractAppController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")

public class AppController implements AbstractAppController {
    /**
     *
     */
    @Override
    public String login(@RequestParam("userID") String userID,
                        @RequestParam("password") String password,
                        @RequestParam("role") int role
    ) {
        return DAOFactory.getDAO().getAppDAO().login(userID, password, role);
    }


}
