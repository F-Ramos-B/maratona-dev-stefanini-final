package br.com.stefanini.maratonadev.rest;

import br.com.stefanini.maratonadev.dto.CarroDto;
import br.com.stefanini.maratonadev.service.CarroService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:37
 */
@Path("carro")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarroRest {

    @Inject
    CarroService service;

    @GET
    @Operation(summary = "Listar carros",
            description = "Lista de carros com ano de compra, marca,modelo e placa")
    @APIResponse(responseCode = "201",
            description = "carro",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = CarroDto.class))
            }
    )
    public Response listar(){
        return Response
                .status(Response.Status.OK)
                .entity(service.listar())
                .build();
    }

}
