package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.service.ProjectService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/projects")
public class ProjectController {

    @Inject
    ProjectService projectService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> list() {
        return projectService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Project getSingleProject(@PathParam Long id) {
        return projectService.getProjectById(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Project addProject(Project project) {
        return projectService.createProject(project);
    }

    @DELETE
    @Path("/{id}")
    public void deleteProject(@PathParam Long id){
        projectService.delete(id);
    }

    @PUT
    public void update(Project project){
        projectService.updateEntity(project);
    }

}
