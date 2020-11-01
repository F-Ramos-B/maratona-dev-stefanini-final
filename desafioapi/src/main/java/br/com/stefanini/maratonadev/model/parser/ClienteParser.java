package br.com.stefanini.maratonadev.model.parser;

import java.util.Objects;

import br.com.stefanini.maratonadev.dto.ClienteDTO;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:33
 */
public class ClienteParser extends AbstractParser<Cliente, ClienteDTO> {

    public static ClienteParser get(){
        return new ClienteParser();
    }

	@Override
	public Cliente toEntity(ClienteDTO dto) {
		Cliente entidade = new Cliente();
		entidade.setCpf(dto.getCpf());
		entidade.setBairro(dto.getBairro());
		entidade.setCep(dto.getCep());
		entidade.setCidade(dto.getCidade());
		entidade.setContato(dto.getContato());
		entidade.setEmail(dto.getEmail());
		entidade.setUf(dto.getUf());
		entidade.setId(dto.getId());
		entidade.setLogradouro(dto.getLogradouro());
		entidade.setNome(dto.getNome());
		return entidade;
	}

	@Override
	public ClienteDTO toDTO(Cliente entidade) {
		ClienteDTO dto = new ClienteDTO();
		dto.setCpf(entidade.getCpf());
		dto.setBairro(entidade.getBairro());
		dto.setCidade(entidade.getCidade());
		dto.setCep(entidade.getCep());
		dto.setContato(entidade.getContato());
		dto.setEmail(entidade.getEmail());
		dto.setUf(entidade.getUf());
		dto.setId(entidade.getId());
		dto.setLogradouro(entidade.getLogradouro());
		dto.setNome(entidade.getNome());
		
		dto.setPossuiVeiculo(Objects.nonNull(entidade.getCarro()));
		
		if (dto.isPossuiVeiculo()) {
			Carro carro = entidade.getCarro();
			dto.setPlacaCarro(carro.getPlaca());
			dto.setMarcaCarro(carro.getMarca());
			dto.setAnoCarro(carro.getAno());
			dto.setModeloCarro(carro.getModelo());
		}
		
		return dto;
	}

}
