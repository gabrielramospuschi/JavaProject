package main.java.br.com.fintech.entity;

import java.time.LocalDate;

public class FonteRendaEntity extends DadoEntity {

	private static final long serialVersionUID = 1L;

	public FonteRendaEntity() {
		super();
	}

	public FonteRendaEntity(double valor, LocalDate data) {
		super(valor, data);
	}
}