package ch.zli.m223.punchclock.controller;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.Claims;

import ch.zli.m223.punchclock.ViewModel.LoginResultViewModel;
import ch.zli.m223.punchclock.ViewModel.LoginViewModel;
import io.smallrye.jwt.build.Jwt;

/*
* A sample controller for creating JWT Tokens
* Do not use in productive environments!
*/
@Path("/auth")
public class AuthentificationController {
    
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LoginResultViewModel login(LoginViewModel loginViewModel){
        if(loginViewModel.getUsername().equals("user") && loginViewModel.getPassword().equals("secure")){
            String token =
            Jwt.issuer("https://zli.ch/issuer") 
              .upn("user@zli.ch") 
              .groups(new HashSet<>(Arrays.asList("User", "Admin"))) 
              .claim(Claims.birthdate.name(), "2001-07-13")
              .expiresIn(Duration.ofHours(1)) 
            .sign();
            return new LoginResultViewModel(token);
        }
        throw new NotAuthorizedException("User ["+loginViewModel.getUsername()+"] with password ["+loginViewModel.getPassword()+"] not known");
    }
}

