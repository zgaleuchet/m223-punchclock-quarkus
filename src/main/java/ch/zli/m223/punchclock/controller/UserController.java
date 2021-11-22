package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.UserService;

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
    public List<User> list() {
        return userService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") Long id){
        userService.delete(id);
    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User update(User user){
        return userService.updateUser(user);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getSingleEntry(@PathParam("id") Long id) {
        return userService.getUserById(id);
    }

    @GET
    @Path("/username/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserByUsername(@PathParam("username") String username) {
        return userService.getUserByUsername(username);
    }
}
