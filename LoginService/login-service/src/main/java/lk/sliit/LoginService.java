package lk.sliit;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by VMARALA on 6/9/2017.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api/")
public class LoginService {

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public UserAuth authorizeUser(@RequestBody User dummyUser, HttpServletResponse response) {
        UserAuth auth = new UserAuth();
        auth.setUser(dummyUser.getUsername());
        auth.setUser(dummyUser.getUsername());
        if (LoginServiceApplication.users.containsKey(dummyUser.getUsername())) {
            if (LoginServiceApplication.users.get(dummyUser.getUsername()).getPassword().equals(dummyUser.getPassword())) {
                auth.setStatus(true);
                auth.setStatusCode(200);
                auth.setMessage("Login Successful");
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                auth.setStatus(false);
                auth.setStatusCode(401);
                auth.setMessage("Password is Incorrect");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else {
            auth.setStatus(false);
            auth.setStatusCode(401);
            auth.setMessage("Invalid Username");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        return auth;
    }

}
