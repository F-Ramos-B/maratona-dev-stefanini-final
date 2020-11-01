package br.com.stefanini.maratonadev.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.stefanini.maratonadev.dao.CarroDAO;
import br.com.stefanini.maratonadev.dto.CarroDTO;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.parser.CarroParser;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:32
 */
@RequestScoped
public class CarroService {

	@Inject
	CarroDAO carroDAO;

	public List<CarroDTO> listar() {
		return CarroParser.get().toDTOList(carroDAO.listar());
	}

	public Carro recuperarPorPlaca(String placa) {
		return carroDAO.recuperarPorPlaca(placa);
	}
	
	public CarroDTO recuperarPorPlacaDTO(String placa) {
		return CarroParser.get().toDTO(this.recuperarPorPlaca(placa));
	}

	public void inserir(Carro carro) {
		carroDAO.inserir(carro);
	}
}
