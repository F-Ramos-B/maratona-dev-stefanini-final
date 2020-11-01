package br.com.stefanini.maratonadev.model.parser;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractParser<E, D> {
	
	public abstract E toEntity(D dto);
	
	public abstract D toDTO(E entidade);
	
	public List<E> toEntityList(List<D> dtos) {
		return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	}
	
	public List<D> toDTOList(List<E> entidades) {
		return entidades.stream().map(this::toDTO).collect(Collectors.toList());
	}
	
}
