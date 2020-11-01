package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dto.HistoricoDTO;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.Historico;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:33
 */
public class HistoricoParser extends AbstractParser<Historico, HistoricoDTO> {

    public static HistoricoParser get(){
        return new HistoricoParser();
    }

	@Override
	public Historico toEntity(HistoricoDTO dto) {
		return null;
	}

	@Override
	public HistoricoDTO toDTO(Historico entidade) {
		HistoricoDTO dto = new HistoricoDTO();
		Carro carro = entidade.getCarro();
		Cliente cliente = entidade.getCliente();
		dto.setDataAluguel(entidade.getDataAluguel());
		
		// Carro
		dto.setPlacaCarro(carro.getPlaca());
		dto.setAnoCarro(carro.getAno());
		dto.setMarcaCarro(carro.getMarca());
		dto.setModeloCarro(carro.getModelo());
		
		// Cliente
		dto.setIdCliente(cliente.getId());
		dto.setNomeCliente(cliente.getNome());
		
		return dto;
	}

}
