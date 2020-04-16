import java.util.Scanner;

public class MineSweeper {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = 1;

		while (scan.hasNext()) {
			int rows = scan.nextInt() + 2;
			int columns = scan.nextInt() + 2;

			if (rows + columns != 4) {
				System.out.println("Field #" + i + ":");
				char[][] container = generateContainer(rows, columns);
				generateMineField(scan, container);
				
				System.out.println();
				
				printMineField(generateHintField(container));
				
				System.out.println();
				i++;
			} else {
				break;
			}
		}
	}

	public static char[][] generateContainer(int rows, int columns) {
		char[][] container = new char[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < columns; k++) {
				container[i][k] = '.';
			}
		}
		return container;
	}

	public static char[][] generateMineField(Scanner scan, char[][] hintField) {
		int rows = hintField.length;
		int columns = hintField[0].length;

		for (int i = 1; i < rows - 1; i++) {
			String line = scan.next();
			for (int k = 1; k < columns - 1; k++) {
				hintField[i][k] = line.charAt(k - 1);
			}
		}
		return hintField;
	}

	public static void printMineField(char[][] mineField) {
		for (int i = 1; i < mineField.length - 1; i++) {
			for (int k = 1; k < mineField[0].length - 1; k++) {
				System.out.print(mineField[i][k]);
			}
			System.out.println();
		}
	}

	public static char[][] generateHintField(char[][] mineField) {
		int rows = mineField.length;
		int columns = mineField[0].length;
		for (int i = 1; i < rows - 1; i++) {
			for (int k = 1; k < columns - 1; k++) {
				if (mineField[i][k] != '*') {
					mineField[i][k] = findHints(mineField, i, k);
				}
			}
		}
		return mineField;
	}

	public static char findHints(char[][] mineField, int row, int column) {
		int count = 0;
		if (mineField[row][column + 1] == '*') {
			count++;
		}
		if (mineField[row + 1][column] == '*') {
			count++;
		}
		if (mineField[row][column - 1] == '*') {
			count++;
		}
		if (mineField[row - 1][column] == '*') {
			count++;
		}
		if (mineField[row + 1][column + 1] == '*') {
			count++;
		}
		if (mineField[row - 1][column - 1] == '*') {
			count++;
		}
		if (mineField[row - 1][column + 1] == '*') {
			count++;
		}
		if (mineField[row + 1][column - 1] == '*') {
			count++;
		}
		return (char) (count + '0');
	}
}