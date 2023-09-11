package main.java.br.com.fintech.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartaoCreditoEntity {

	private long numero;
	private LocalDate validate;
	private String cvv;
	
	public boolean registrarCartao(CartaoCreditoEntity cartao) throws NullPointerException {
		if (cartao.getValidate() == null || cartao.getCvv() == null) {
			throw new NullPointerException("Todos os campos devem ser informados.");
		}
		
		return cartao.getCvv().equals("0")
			&& cartao.getNumero() > 0
			&& cartao.getValidate().isAfter(LocalDate.now());
	}
}