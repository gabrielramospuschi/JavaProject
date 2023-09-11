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
public class BancoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String razaoSocial;
	private String cnpj;
	private long idBanco;
}