package br.com.stefanini.maratonadev.model.parser;

import java.util.Objects;

import br.com.stefanini.maratonadev.dto.CarroDTO;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:33
 */
public class CarroParser extends AbstractParser<Carro, CarroDTO> {

	public static CarroParser get() {
		return new CarroParser();
	}
	
	@Override
	public CarroDTO toDTO(Carro entidade) {
		CarroDTO dto = new CarroDTO();
		dto.setPlaca(entidade.getPlaca());
		dto.setAno(entidade.getAno());
		dto.setModelo(entidade.getModelo());
		dto.setMarca(entidade.getMarca());
		
		dto.setAlugado(Objects.nonNull(entidade.getCliente()));
		
		if (dto.isAlugado()) {
			Cliente cliente = entidade.getCliente();
			dto.setIdCliente(cliente.getId());
			dto.setNomeCliente(cliente.getNome());
		}
		
		return dto;
	}

	@Override
	public Carro toEntity(CarroDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}
