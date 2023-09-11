package main.java.br.com.fintech.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContaCorrenteEntity extends ContaEntity {

	private static final double TAXA_CONTA_CORRENTE = 10.0;
	
	private static final long serialVersionUID = 1L;
	
	private double saldoChequeEspecial;
	private double limiteChequeEspecial;

	@Override
	public void sacarSaldo(double valorSaque) {
		valorSaque += TAXA_CONTA_CORRENTE;
		super.sacarSaldo(valorSaque);
	}

	public ContaCorrenteEntity(double saldoChequeEspecial, double limiteChequeEspecial, int numero, String agenciaNumber, double saldo, BancoEntity banco) {
		super(numero, agenciaNumber, saldo, banco);
		this.limiteChequeEspecial = limiteChequeEspecial;
		this.saldoChequeEspecial = saldoChequeEspecial;
	}
}