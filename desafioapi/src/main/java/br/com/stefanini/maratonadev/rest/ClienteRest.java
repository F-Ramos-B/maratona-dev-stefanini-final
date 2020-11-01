package br.com.stefanini.maratonadev.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.maratonadev.dto.ClienteDTO;
import br.com.stefanini.maratonadev.service.ClienteService;

@Path("cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteRest {

	@Inject
	ClienteService clienteService;

	@GET
	@Operation(summary = "Listar clientes", description = "Lista de clientes")
	@APIResponse(responseCode = "200", description = "cliente", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ClienteDTO.class)) })
	public Response listar() {
		return Response.ok(clienteService.listar()).build();
	}

	@GET
	@Path("/{id}")
	@Operation(summary = "Recuperar cliente por id", description = "Recuperar cliente id")
	@APIResponse(responseCode = "200", description = "cliente", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ClienteDTO.class)) })
	public Response recuperarPorId(@PathParam("id") Long id) {
		return Response.ok(clienteService.recuperarPorId(id)).build();
	}

	@POST
	@Operation(summary = "Inserir cliente", description = "Adicionar cliente")
	@APIResponse(responseCode = "201", description = "cliente", content = { @Content(mediaType = "application/json") })
	public Response inserir(ClienteDTO cliente) {
		boolean isInserido = clienteService.inserir(cliente);

		if (isInserido) {
			return Response.status(Status.CREATED).build();
		}

		return Response.status(Status.BAD_REQUEST).build();
	}

	@PUT
	@Path("/alugar/{idCliente}/{placa}")
	@Operation(summary = "Alugar carro", description = "Alugar carro")
	@APIResponse(responseCode = "202", description = "alugar", content = { @Content(mediaType = "application/json") })
	public Response alugarCarro(@PathParam("idCliente") Long idCliente, @PathParam("placa") String placa) {
		boolean success = clienteService.alugar(idCliente, placa);
		if (success) {
			return Response.status(Status.ACCEPTED).build();
		}

		return Response.status(Status.BAD_REQUEST).build();
	}

	@PUT
	@Path("/devolver/{idCliente}")
	@Operation(summary = "Devolver carro", description = "Devolver carro")
	@APIResponse(responseCode = "202", description = "devolver", content = { @Content(mediaType = "application/json") })
	public Response devolverCarro(@PathParam("idCliente") Long idCliente) {
		boolean success = clienteService.devolverCarro(idCliente);
		if (success) {
			return Response.status(Status.ACCEPTED).build();
		}

		return Response.status(Status.BAD_REQUEST).build();
	}

}
