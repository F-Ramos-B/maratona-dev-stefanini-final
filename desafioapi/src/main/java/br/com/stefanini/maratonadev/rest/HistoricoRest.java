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

import br.com.stefanini.maratonadev.dto.HistoricoDTO;
import br.com.stefanini.maratonadev.service.HistoricoService;

@Path("historico")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HistoricoRest {

	@Inject
	HistoricoService historicoService;

	@GET
	@Path("/{idCliente}")
	@Operation(summary = "Recuperar historico de cliente por id", description = "Recuperar historico por id cliente")
	@APIResponse(responseCode = "200", description = "historico", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = HistoricoDTO.class)) })
	public Response recuperarPorId(@PathParam("idCliente") Long idCliente) {
		return Response.ok(historicoService.listarHistoricoCliente(idCliente)).build();
	}

}
