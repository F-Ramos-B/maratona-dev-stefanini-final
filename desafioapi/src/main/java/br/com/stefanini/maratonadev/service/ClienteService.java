package br.com.stefanini.maratonadev.service;

import java.util.List;
import java.util.Objects;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.stefanini.maratonadev.dao.ClienteDAO;
import br.com.stefanini.maratonadev.dto.ClienteDTO;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.Historico;
import br.com.stefanini.maratonadev.model.parser.ClienteParser;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:32
 */
@RequestScoped
public class ClienteService {

	@Inject
	ClienteDAO clienteDAO;

	@Inject
	CarroService carroService;

	@Inject
	HistoricoService historicoService;

	public List<ClienteDTO> listar() {
		return ClienteParser.get().toDTOList(clienteDAO.listar());
	}

	@Transactional(rollbackOn = Exception.class)
	public boolean inserir(@Valid ClienteDTO cliente) {
		if (existeCPF(cliente.getCpf())) {
			return false;
		}

		clienteDAO.inserir(ClienteParser.get().toEntity(cliente));
		return true;
	}

	private boolean existeCPF(String cpf) {
		return clienteDAO.buscarPorCPF(cpf).isPresent();
	}

	@Transactional(rollbackOn = Exception.class)
	public boolean alugar(Long idCliente, String placa) {
		Cliente cliente = clienteDAO.recuperarPorId(idCliente);
		Carro carro = carroService.recuperarPorPlaca(placa);

		if (isEntidadesNull(cliente, carro) || aluguelInvalido(cliente, carro)) {
			return false;
		}

		cliente.setCarro(carro);
		carro.setCliente(cliente);

		clienteDAO.inserir(cliente);
		carroService.inserir(carro);

		historicoService.inserir(new Historico(cliente, carro));

		return true;
	}

	@Transactional(rollbackOn = Exception.class)
	public boolean devolverCarro(Long idCliente) {
		Cliente cliente = clienteDAO.recuperarPorId(idCliente);
		Carro carro = carroService.recuperarPorPlaca(cliente.getCarro().getPlaca());
		
		if (isEntidadesNull(cliente, carro) || devolucaoInvalida(cliente, carro)) {
			return false;
		}
		
		cliente.setCarro(null);
		carro.setCliente(null);
		
		clienteDAO.inserir(cliente);
		carroService.inserir(carro);
		
		return true;
	}

	public ClienteDTO recuperarPorId(Long id) {
		return ClienteParser.get().toDTO(clienteDAO.recuperarPorId(id));
	}

	private boolean aluguelInvalido(Cliente cliente, Carro carro) {
		return Objects.nonNull(cliente.getCarro()) && Objects.nonNull(carro.getCliente());
	}

	private boolean devolucaoInvalida(Cliente cliente, Carro carro) {
		return Objects.isNull(cliente.getCarro()) || Objects.isNull(carro.getCliente())
				|| !Objects.equals(cliente.getCarro().getPlaca(), carro.getPlaca());
	}

	private boolean isEntidadesNull(Cliente cliente, Carro carro) {
		return Objects.isNull(cliente) && Objects.isNull(carro);
	}
}
