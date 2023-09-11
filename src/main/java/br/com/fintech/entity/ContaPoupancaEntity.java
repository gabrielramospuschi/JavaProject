package main.java.br.com.fintech.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContaPoupancaEntity extends ContaEntity {

	private static final long serialVersionUID = 1L;
	
	private double taxaJuros;
	
	public void creditarJuros() {
		super.setSaldo(taxaJuros);
	}

	public ContaPoupancaEntity(double taxaJuros, int numero, String agenciaNumber, double saldo, BancoEntity banco) {
		super(numero, agenciaNumber, saldo, banco);
		this.taxaJuros = taxaJuros;
	}
}