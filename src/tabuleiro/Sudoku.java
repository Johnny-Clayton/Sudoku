package tabuleiro;

import java.util.Scanner;

public class Sudoku {
	
    private int[][] board = new int[9][9];
    private Scanner scanner = new Scanner(System.in);

    public void initializeBoard() {
    	
        board[0][0] = 5;
        board[0][1] = 3;
        board[0][4] = 7;
        board[1][0] = 6;
        board[1][3] = 1;
        board[1][4] = 9;
        board[1][5] = 5;
        board[2][1] = 9;
        board[2][2] = 8;
        board[2][7] = 6;
        board[3][0] = 8;
        board[3][4] = 6;
        board[3][8] = 3;
        board[4][0] = 4;
        board[4][3] = 8;
        board[4][5] = 3;
        board[4][8] = 1;
        board[5][0] = 7;
        board[5][4] = 2;
        board[5][8] = 6;
        board[6][1] = 6;
        board[6][6] = 2;
        board[6][7] = 8;
        board[7][3] = 4;
        board[7][4] = 1;
        board[7][5] = 9;
        board[7][8] = 5;
        board[8][4] = 8;
        board[8][7] = 7;
        board[8][8] = 9;
    }

    public boolean isValid(int row, int col, int value) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }
        int startRow = row - (row % 3);
        int startCol = col - (col % 3);
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public void play() {
        while (true) {
        	clearScreen();
            displayBoard();
            System.out.print("Digite a Linha (1-9): ");
            Integer row = scanner.nextInt() - 1;
            System.out.print("Digite a Coluna (1-9): ");
            Integer col = scanner.nextInt() - 1;
            System.out.print("Digite a Valor (1-9): ");
            int value = scanner.nextInt();
            if (isValid(row, col, value)) {
                board[row][col] = value;
                if (isComplete()) {
                    System.out.println("Parabéns! Você resolveu o quebra-cabeça!");
                    break;
                }
            } else {
                System.out.println("Movimento inválido. Por favor, tente novamente.");
            }
        }
    }


    public boolean isComplete() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void displayBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
    	Sudoku sudoku = new Sudoku();
        sudoku.initializeBoard();
        sudoku.play();
    }
    
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}	
}

