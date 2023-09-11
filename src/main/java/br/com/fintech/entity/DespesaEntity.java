package main.java.br.com.fintech.entity;

import java.time.LocalDate;

public class DespesaEntity extends DadoEntity {

	private static final long serialVersionUID = 1L;

	public DespesaEntity() {
		super();
	}

	public DespesaEntity(double valor, LocalDate data) {
		super(valor, data);
	}
}