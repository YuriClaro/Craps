package application;

import java.security.SecureRandom;

import enums.Status;

// Capitulo 6.10 - Jogo de Azar "Craps"
// Versão 1.0
public class Program {
	
		// cria um gerador seguro de números aleatórios para uso no método rollDice();
		private static final SecureRandom randomNumbers = new SecureRandom();

		// contanstes que representam lançamentos comuns dos dados
		private static final int SNAKE_EYES = 2;
		private static final int TREY = 3;
		private static final int SEVEN = 7;
		private static final int YO_LEVEN = 11;

	// joga uma partida de craps
	public static void main(String[] args) {
		
		int myPoint = 0; // pontos se não ganhar ou perder na 1ª rolagem;
		Status gameStatus; // pode conter CONTINUE, WON ou LOST;
		
		int sumOfDice = rollDice(); // primeira rolagem dos dados.
		
		// determina o estaado do jogo e a pontuação com base no primeiro lançamento
		switch (sumOfDice) {
		case SEVEN: // ganha com 7 no primeiro lançamento
		case YO_LEVEN: // ganha com 11 no primeiro lançamento
			gameStatus = Status.WON;
			break;
		case SNAKE_EYES: // perde com 2 no primeiro lançamento;
		case TREY: // perde com 3 no primeiro lançamento;
			gameStatus =  Status.LOST;
			break;
		default: // não ganhou nem perdeu, portanto registra a pontuação;
			gameStatus = Status.CONTINUE; // jogo ainda não terminou;
			myPoint = sumOfDice; // informa a pontuação
			System.out.printf("Point is %d%n", myPoint);
			break;
		}
		
		// enquanto o jogo não estiver completo
		while (gameStatus == Status.CONTINUE) // nem WON nem LOST
		{
			sumOfDice = rollDice(); // lança os dados novamente
			
			// determina o estado do jogo
			if (sumOfDice == myPoint) { // vitória por pontuação
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

	// lança os dados, calcula a soma e exibe os resultados
			public static int rollDice() {
				// seleciona valores aleatórios do dado
				int die1 = 1 + randomNumbers.nextInt(6);
				int die2 = 1 + randomNumbers.nextInt(6);
				
				int sum = die1 + die2; // soma dos valores dos dados
				
				// exibe os resultados desse lançamento
				System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);
				
				return sum;
			}
}
