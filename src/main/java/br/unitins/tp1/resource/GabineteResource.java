package br.unitins.tp1.resource;

import java.util.List;

import br.unitins.tp1.dto.GabineteRequestDTO;
import br.unitins.tp1.dto.GabineteResponseDTO;
import br.unitins.tp1.service.GabineteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/gabinetes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GabineteResource {
    @Inject
    GabineteService service;

    @POST
    public GabineteResponseDTO create(GabineteRequestDTO dto) {
        return service.create(dto);
    }

    @GET
    public List<GabineteResponseDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public GabineteResponseDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @GET
    @Path("/modelo/{modelo}")
    public GabineteResponseDTO findByModelo(@PathParam("modelo") String modelo) {
        return service.findByModelo(modelo);
    }

    @PUT
    @Path("/{id}")
    public GabineteResponseDTO update(@PathParam("id") Long id, GabineteRequestDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}
