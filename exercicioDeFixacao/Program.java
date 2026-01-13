import java.util.Locale;
import java.util.Scanner;

import Model.exepitions.DomainException;

public class Program {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Dados da conta");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Titular: ");
		String titular = sc.next();
		System.out.print("Saldo inicial: ");
		double saldoInicial = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double limiteSaque = sc.nextDouble();
		
		Account account = new Account(numero, titular, saldoInicial, limiteSaque);
		
		System.out.println();
		System.out.print("Informe o valor do saque: ");
		double saque = sc.nextDouble();
		account.withdraw(saque);
		System.out.print("Novo saldo: " + account.getBalance());
		}
		catch (DomainException e) {
			System.err.println("Erro no saque: " + e.getMessage());
		}
		sc.close();
	}

}
