package br.com.stefanini.maratonadev.service;

import br.com.stefanini.maratonadev.dao.CarroDao;
import br.com.stefanini.maratonadev.dto.CarroDto;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.parser.CarroParser;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:32
 */
@RequestScoped
public class CarroService {
    @Inject
    CarroDao dao;


    public List<CarroDto> listar(){
        return dao.listar().stream().map(CarroParser.get()::dto).collect(Collectors.toList());
    }
}
