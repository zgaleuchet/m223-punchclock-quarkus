package ch.zli.m223.punchclock.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;

@Path("/entries")
public class EntryController {

    @Inject
    EntryService entryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Get all Entries")
    public List<Entry> list() {
        return entryService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Get single Entry by id")
    public Entry getSingleEntry(@PathParam Long id) {
        return entryService.getEntryById(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Create new Entry")
    public Entry addEntry(Entry entry) {
       return entryService.createEntry(entry);
    }
    
    @DELETE
    @Path("/{id}")
    @Operation(description = "Delete Entry by id")
    public void deleteEntry(@PathParam Long id){
        entryService.delete(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Update Entry")
    public Entry update(Entry entry){
        return entryService.updateEntity(entry);
    }

}
