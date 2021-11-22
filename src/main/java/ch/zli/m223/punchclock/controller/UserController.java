package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Get all user")
    public List<User> list() {
        return userService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Create new User")
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @DELETE
    @Path("/{id}")
    @Operation(description = "Delete User with id")
    public void deleteUser(@PathParam("id") Long id){
        userService.delete(id);
    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Update User")
    public User update(User user){
        return userService.updateUser(user);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Get single User by id")
    public User getSingleEntry(@PathParam("id") Long id) {
        return userService.getUserById(id);
    }

    @GET
    @Path("/username/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Get User by username")
    public List<User> getUserByUsername(@PathParam("username") String username) {
        return userService.getUserByUsername(username);
    }
}
