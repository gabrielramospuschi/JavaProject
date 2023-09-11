package main.java.br.com.fintech.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private int numero;
	private String agenciaNumber;
	private double saldo;
	private BancoEntity banco;
	
	/**
	 * Acrescenta valor ao Saldo da Conta
	 * @param valor que será depositado
	 */
	public void depositar(double valor){
		this.saldo += valor;
	}
	
	/**
	 * Retira um valor do Saldo da Conta
	 * @param valorSaque
	 */
	public void sacarSaldo(double valorSaque){
		this.saldo -= valorSaque;
	}
}