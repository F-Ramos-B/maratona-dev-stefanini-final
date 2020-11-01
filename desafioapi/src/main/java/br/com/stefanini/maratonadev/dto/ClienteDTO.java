package br.com.stefanini.maratonadev.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:33
 */
public class ClienteDTO {

    private Long id;

	@NotBlank
	@Length(min = 3, max = 100, message = "Nome deve ter entre 3 a 100 caracteres.")
    private String nome;
	
	@NotNull
    @Column(name = "cpf", nullable = false, length = 11, unique = true)
    private String cpf;
	
	@NotNull
    @Column(nullable = false)
    private Long contato;
	
	@NotBlank
    @Column(nullable = false)
    private String email;

	@NotBlank
	@Column(nullable = false)
    private String cep;
    @NotBlank
    @Column(nullable = false)
    private String bairro;
    @NotBlank
    @Column(nullable = false)
    private String cidade;
    @NotBlank
    @Column(nullable = false)
    private String uf;
    
    private String logradouro;
    private String complemento;
    
    private String placaCarro;
    private int anoCarro;
    private String marcaCarro;
    private String modeloCarro;
    
    private boolean possuiVeiculo;
    
	public boolean isPossuiVeiculo() {
		return possuiVeiculo;
	}
	public void setPossuiVeiculo(boolean possuiVeiculo) {
		this.possuiVeiculo = possuiVeiculo;
	}
	public String getPlacaCarro() {
		return placaCarro;
	}
	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}
	public int getAnoCarro() {
		return anoCarro;
	}
	public void setAnoCarro(int anoCarro) {
		this.anoCarro = anoCarro;
	}
	public String getMarcaCarro() {
		return marcaCarro;
	}
	public void setMarcaCarro(String marcaCarro) {
		this.marcaCarro = marcaCarro;
	}
	public String getModeloCarro() {
		return modeloCarro;
	}
	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Long getContato() {
		return contato;
	}
	public void setContato(Long contato) {
		this.contato = contato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
    
}
