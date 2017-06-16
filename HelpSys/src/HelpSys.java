import java.util.Scanner;

public class HelpSys {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int valor1 = 0;
		int valor2 = 0;
		int contPos = 0;
		int contPar = 0;
		int contImp = 0;
		int contParDiv = 0;

		System.out.println("Digite o valor inicial e o final, respectivamente: ");
		valor1 = sc.nextInt();
		valor2 = sc.nextInt();

		for (int i = valor1; i <= valor2; i++) {
			if (i >= 0) {
				contPos++;
			}

			if (i % 2 == 0) {
				contPar++;
				if (i % 3 == 0 && i % 4 == 0) {
					contParDiv++;
				}
			} else {
				contImp++;
			}

		}
		
		System.out.println("\nA quantidade de numeros inteiros e positivos e: " + contPos);
		System.out.println("\nA quantidade de numeros pares e: " + contPar);
		System.out.println("\nA quantidade de numeros impares e: " + contImp);
		System.out.println("\nA quantidade de numeros pares e divisiveis por 3 e 4 ao mesmo tempo e: " + contPos);
		
		
	}

}
