package application;

import java.security.SecureRandom;

import enums.Status;

// Capitulo 6.10 - Jogo de Azar "Craps"
// Vers�o 1.0
public class Program {
	
		// cria um gerador seguro de n�meros aleat�rios para uso no m�todo rollDice();
		private static final SecureRandom randomNumbers = new SecureRandom();

		// contanstes que representam lan�amentos comuns dos dados
		private static final int SNAKE_EYES = 2;
		private static final int TREY = 3;
		private static final int SEVEN = 7;
		private static final int YO_LEVEN = 11;

	// joga uma partida de craps
	public static void main(String[] args) {
		
		int myPoint = 0; // pontos se n�o ganhar ou perder na 1� rolagem;
		Status gameStatus; // pode conter CONTINUE, WON ou LOST;
		
		int sumOfDice = rollDice(); // primeira rolagem dos dados.
		
		// determina o estaado do jogo e a pontua��o com base no primeiro lan�amento
		switch (sumOfDice) {
		case SEVEN: // ganha com 7 no primeiro lan�amento
		case YO_LEVEN: // ganha com 11 no primeiro lan�amento
			gameStatus = Status.WON;
			break;
		case SNAKE_EYES: // perde com 2 no primeiro lan�amento;
		case TREY: // perde com 3 no primeiro lan�amento;
			gameStatus =  Status.LOST;
			break;
		default: // n�o ganhou nem perdeu, portanto registra a pontua��o;
			gameStatus = Status.CONTINUE; // jogo ainda n�o terminou;
			myPoint = sumOfDice; // informa a pontua��o
			System.out.printf("Point is %d%n", myPoint);
			break;
		}
		
		// enquanto o jogo n�o estiver completo
		while (gameStatus == Status.CONTINUE) // nem WON nem LOST
		{
			sumOfDice = rollDice(); // lan�a os dados novamente
			
			// determina o estado do jogo
			if (sumOfDice == myPoint) { // vit�ria por pontua��o
				gameStatus = Status.WON;
			} else if (sumOfDice == SEVEN) {
				gameStatus = Status.LOST;
			}
			
			// exibe uma mensagem se ganhou ou perdeu
			if (gameStatus == Status.WON) {
				System.out.println("Player wins!");
			} else {
				System.out.println("Player loses!");
			}
				
		}
	}

	// lan�a os dados, calcula a soma e exibe os resultados
			public static int rollDice() {
				// seleciona valores aleat�rios do dado
				int die1 = 1 + randomNumbers.nextInt(6);
				int die2 = 1 + randomNumbers.nextInt(6);
				
				int sum = die1 + die2; // soma dos valores dos dados
				
				// exibe os resultados desse lan�amento
				System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);
				
				return sum;
			}
}
