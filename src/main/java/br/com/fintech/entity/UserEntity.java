package main.java.br.com.fintech.entity;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {

	public static UserEntity currentUser = null;
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private LocalDate dataDeNascimento;
	private String cpf;
	private String telefone;
	private String senha;
	private ContaEntity contaBancaria;
	
	public static UserEntity registrar(UserEntity user) throws Exception {
		userChecker(user);
		currentUser = user;
		return user;
	}
	
	public static void login(String userName, String senha) throws Exception {
		if (currentUser.getNome().equals(userName) && currentUser.getSenha().equals(senha)) {
			System.out.println("Login com sucesso!");
			return;
		}
		System.err.println("Usuário inválido.");
	}
	
	private static void userChecker(UserEntity user) throws Exception {
		Method[] methods = UserEntity.class.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.getName().startsWith("get") && method.invoke(user, null) == null) {
				throw new NullPointerException(method.getName().substring(3) + " deve ser informado.");
			}
		}
	}
}