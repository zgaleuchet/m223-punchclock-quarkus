package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.AuthenticationService;
import ch.zli.m223.punchclock.service.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path(("/auth"))
public class AuthentificationController {

    @Inject
    AuthenticationService authenticationService;

    @Inject
    UserService userService;

    @POST
    @Path("/login/{username}/{password}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(description = "Login request: Get JWT Token")
    public String login(@PathParam("username") String username, @PathParam("password") String password) {
        List<User> users = userService.getUserByUsername(username);
        if (authenticationService.checkIfUserExists(users.get(0))) {
            User user = users.get(0);
            if (user.getPassword().equals(password)) {
                return authenticationService.GenerateValidJwtToken(user.getUsername());
            }
        }
        return "";


    }


}
