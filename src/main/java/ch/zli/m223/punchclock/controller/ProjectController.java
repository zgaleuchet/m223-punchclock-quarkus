package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.service.ProjectService;
import org.eclipse.microprofile.openapi.annotations.Operation;
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
    @Operation(description = "Get all Projects")
    public List<Project> list() {
        return projectService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Get single Project by id")
    public Project getSingleProject(@PathParam Long id) {
        return projectService.getProjectById(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Create new Project")
    public Project addProject(Project project) {
        return projectService.createProject(project);
    }

    @DELETE
    @Path("/{id}")
    @Operation(description = "Delete Project by id")
    public void deleteProject(@PathParam Long id){
        projectService.delete(id);
    }

    @PUT
    @Operation(description = "Update Project")
    public void update(Project project){
        projectService.updateEntity(project);
    }

}
