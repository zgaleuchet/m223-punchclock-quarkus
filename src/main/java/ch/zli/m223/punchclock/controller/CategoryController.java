package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.CategoryService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
public class CategoryController {
    @Inject
    CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Get all Categories")
    public List<Category> list() {
        return categoryService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Get single Category by id")
    public Category getSingleCategory(@PathParam("id") Long id) {
        return categoryService.getCategoryById(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Create new Category")
    public Category createCategory(Category category) {
        return categoryService.createCategory(category);
    }

    @DELETE
    @Path("/{id}")
    @Operation(description = "Delete Category by id")
    public void deleteCategory(@PathParam("id") Long id){
        categoryService.deleteCategory(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Update Catgory")
    public Category update(Category category){
        return categoryService.updateCategory(category);
    }

}
