package br.com.stefanini.maratonadev.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:27
 */
@Entity
@Table(name = "carro")
public class Carro extends PanacheEntityBase {
    @Id
    private String placa;

    @Column(name = "ano")
    private int ano;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "marca")
    private String marca;

    @OneToOne
	@JoinColumn(name = "id_cliente", nullable = true)
	private Cliente cliente;
    
    @OneToMany(mappedBy = "carro")
	private List<Historico> historico;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Historico> getHistorico() {
		return historico;
	}

	public void setHistorico(List<Historico> historico) {
		this.historico = historico;
	}

}
