package br.com.stefanini.maratonadev.dao;

import br.com.stefanini.maratonadev.model.Carro;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.RequestScoped;
import java.util.List;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:30
 */
@RequestScoped
public class CarroDao {

    public List<Carro> listar(){
        return Carro.listAll(Sort.by("modelo,marca").ascending());
    }
}
