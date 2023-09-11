package main.java.br.com.fintech.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DadoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private double valor;
	private LocalDate data;
}