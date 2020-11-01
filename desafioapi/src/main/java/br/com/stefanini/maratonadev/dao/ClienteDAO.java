package br.com.stefanini.maratonadev.dao;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;

import br.com.stefanini.maratonadev.model.Cliente;

@RequestScoped
public class ClienteDAO {

	public List<Cliente> listar() {
		return Cliente.listAll();
	}

	public Cliente recuperarPorId(Long id) {
		return Cliente.findById(id);
	}

	public Optional<Cliente> buscarPorCPF(String cpf) {
		return Optional.ofNullable(Cliente.find("cpf", cpf).firstResult());
	}

	public void inserir(Cliente cliente) {
		Cliente.persist(cliente);
	}
}
