package br.com.stefanini.maratonadev.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.maratonadev.dto.CarroDTO;
import br.com.stefanini.maratonadev.service.CarroService;

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
	@Operation(summary = "Listar carros", description = "Lista de carros com ano de compra, marca,modelo e placa")
	@APIResponse(responseCode = "200", description = "carro", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = CarroDTO.class)) })
	public Response listar() {
		return Response.status(Response.Status.OK).entity(service.listar()).build();
	}

	@GET
	@Path("/{placa}")
	@Operation(summary = "Recuperar carro por placa", description = "Recuperar carro por placa")
	@APIResponse(responseCode = "200", description = "carro", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = CarroDTO.class)) })
	public Response recuperarPorPlaca(@PathParam("placa") String placa) {
		return Response.ok(service.recuperarPorPlacaDTO(placa)).build();
	}

}
