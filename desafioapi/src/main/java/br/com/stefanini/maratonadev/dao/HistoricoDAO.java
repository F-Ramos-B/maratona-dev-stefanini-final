package br.com.stefanini.maratonadev.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.stefanini.maratonadev.model.Historico;
import io.quarkus.panache.common.Sort;

@RequestScoped
public class HistoricoDAO {

	public List<Historico> listarHistoricoCliente(Long idCliente) {
		return Historico.find("cliente.id", Sort.by("dataAluguel").descending(), idCliente).list();
	}

	public void inserir(Historico historico) {
		Historico.persist(historico);
	}

}
