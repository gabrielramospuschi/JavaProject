package main.java.br.com.fintech;

import java.time.LocalDate;
import java.util.Scanner;

import main.java.br.com.fintech.entity.BancoEntity;
import main.java.br.com.fintech.entity.ContaPoupancaEntity;
import main.java.br.com.fintech.entity.DadoEntity;
import main.java.br.com.fintech.entity.DespesaEntity;
import main.java.br.com.fintech.entity.FonteRendaEntity;
import main.java.br.com.fintech.entity.InvestimentoEntity;
import main.java.br.com.fintech.entity.UserEntity;

public class Fintech {

//	BancoEntity banco = new BancoEntity("Junta Comercial", "48072319000159", 1);
//	
//	CartaoCreditoEntity cartaoCredito = new CartaoCreditoEntity(4111111111111111l, LocalDate.of(2030, 10, 1), "666");
//	
//	ContaCorrenteEntity contaCorrente = new ContaCorrenteEntity(10000.0, 20000.0, 123451, "001", 1e9, banco);
//	ContaPoupancaEntity contaPoupanca = new ContaPoupancaEntity(13.25, 123459, "001", 1e9, banco);
//	
//	DespesaEntity despesa = new DespesaEntity(0.0, null);
//	FonteRendaEntity fonteRenda = new FonteRendaEntity(1e9, LocalDate.now());
//	InvestimentoEntity investimento = new InvestimentoEntity(1e9, LocalDate.now(), "PlimBet");
//	
//	UserEntity gabriel = new UserEntity("BielzinhoFazOPlim", LocalDate.of(2003, 2, 6), "999.999.999-99", "(11) 99123-1234", "queDaGreen", contaCorrente);
//	UserEntity gustavo = new UserEntity("GuziFazOPlim", LocalDate.of(2002, 11, 3), "989.999.999-99", "(11) 97123-1234", "queDaGreen", contaPoupanca);
		
	public static void main(String[] args) {
		showMenu();
		Scanner sc = new Scanner(System.in);
		try (sc) {
			int opcao = 0;
			while (opcao != 6) {
				switch (sc.next()) {
				case "1":
					createUser(sc);
					break;
				case "2":
					loginUser(sc);
					break;
				case "3":
					registrar(sc, new DespesaEntity(), "Despesa");
					break;
				case "4":
					registrar(sc, new FonteRendaEntity(), "Fonte de Renda");
					break;
				case "5":
					registrar(sc, new InvestimentoEntity(), "Investimento");
					break;
				case "6":
					System.out.println("Sair!");
					sc.close();
					break;
				default:
					System.err.println("Por favor, inserir uma das opções.");
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}	
	}
	
	private static void showMenu() { 
		System.out.println("Seja bem vindo!");
		System.out.println("O que gostaria de fazer?");
		System.out.println("===========================");
		System.out.println("1: Se Cadastrar");
		System.out.println("2: Login");
		System.out.println("3: Registrar Despesa");
		System.out.println("4: Registrar Fonte de Renda");
		System.out.println("5: Registrar Investimento");
		System.out.println("6: Sair");
		System.out.println("===========================");
	}
	
	private static void createUser(Scanner sc) throws Exception {
		ContaPoupancaEntity conta = new ContaPoupancaEntity();
		BancoEntity banco = new BancoEntity();
		UserEntity user = new UserEntity();
		int ano, mes, dia = 0;
		
		System.out.println("Insira seu CPF:");
		user.setCpf(sc.next());
		System.out.println("Insira seu Ano de Nascimento:");
		ano = sc.nextInt();
		System.out.println("Insira seu Mês de Nascimento:");
		mes = sc.nextInt();
		System.out.println("Insira seu Dia do Nascimento:");
		dia = sc.nextInt();
		user.setDataDeNascimento(LocalDate.of(ano, mes, dia));
		System.out.println("Insira seu Nome:");	
		user.setNome(sc.next());
		System.out.println("Insira sua Senha:");
		user.setSenha(sc.next());
		System.out.println("Insira seu Telefone:");		
		user.setTelefone(sc.next());
		System.out.println("Insira sua Agencia:");
		conta.setAgenciaNumber(sc.next());
		System.out.println("Insira o Numero da Conta:");
		conta.setNumero(sc.nextInt());
		System.out.println("Insira seu Saldo:");
		conta.setSaldo(sc.nextDouble());
		System.out.println("Insira sua Taxa de Juros:");
		conta.setTaxaJuros(sc.nextDouble());
		System.out.println("Insira seu CNPJ:");
		banco.setCnpj(sc.next());
		System.out.println("Insira a ID Seu banco:");
		banco.setIdBanco(sc.nextLong());
		System.out.println("Insira sua Razão Social:");
		banco.setRazaoSocial(sc.next());
		System.out.println("Insira sua Taxa de Juros:");
		conta.setBanco(banco);
		user.setContaBancaria(conta);
		
		UserEntity.registrar(user);
		System.out.println("Cadastrado com sucesso!");
		showMenu();
	}
	
	private static void loginUser(Scanner sc) throws Exception {
		String name, pass = null;
		
		System.out.println("Insira seu Nome:");	
		name = sc.next();
		System.out.println("Insira sua Senha:");
		pass = sc.next();
		
		UserEntity.login(name, pass);
	}
	
	private static void registrar(Scanner sc, DadoEntity dado, String dadoName) throws Exception {
		int ano, mes, dia = 0;
		double valor = 0.0;
		
		System.out.println("Valor da "+dadoName+":");	
		valor = sc.nextDouble();
		
		System.out.println("Insira o Ano da "+dadoName+":");
		ano = sc.nextInt();
		System.out.println("Insira o Mês da "+dadoName+":");
		mes = sc.nextInt();
		System.out.println("Insira o Dia da "+dadoName+":");
		dia = sc.nextInt();
		
		dado.setData(LocalDate.of(ano, mes, dia));
		dado.setValor(valor);

		if (dadoName.equals("Investimento")) {
			System.out.println("Insira o nome do seu Investimento:");
			dado.getClass().getMethod("setNomeInvestimento", String.class).invoke(dado, sc.next());
		}
		
		System.out.println(dadoName+" registrado com sucesso!");
	}
}