package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Userrole;
import ch.zli.m223.punchclock.service.UserroleService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/userrole")
public class UserroleController {

    @Inject
    UserroleService userroleService;

    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public List<Userrole> userroles() {
        return userroleService.findAll();
    }
}
