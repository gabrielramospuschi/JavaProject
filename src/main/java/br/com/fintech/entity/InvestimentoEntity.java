package main.java.br.com.fintech.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvestimentoEntity extends DespesaEntity {

	private static final long serialVersionUID = 1L;

	private String nomeInvestimento;
	
	public InvestimentoEntity() {
		super();
	}

	public InvestimentoEntity(double valor, LocalDate data, String nomeInvestimento) {
		super(valor, data);
		this.nomeInvestimento = nomeInvestimento;
	}
}