package br.com.stefanini.maratonadev.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.dao.HistoricoDAO;
import br.com.stefanini.maratonadev.dto.HistoricoDTO;
import br.com.stefanini.maratonadev.model.Historico;
import br.com.stefanini.maratonadev.model.parser.HistoricoParser;

@RequestScoped
public class HistoricoService {

	@Inject
	HistoricoDAO historicoDAO;
	
	public List<HistoricoDTO> listarHistoricoCliente(Long idCliente) {
		return HistoricoParser.get().toDTOList(historicoDAO.listarHistoricoCliente(idCliente));
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void inserir(Historico historico) {
		historicoDAO.inserir(historico);
	}
	
}
