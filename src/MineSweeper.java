// MineSweeper
// Austin Hall
// This File reads input from the console and creates
// 3 different 2d char arrays, a container array so that
// edge case if clauses arent necessary, the actual minefield with
// . and * to represent bombs and safe spaces as defined by the user,
// and a hint array that displays the number of bombs a space is 
// adjacent to. There is also a print array method
import java.util.Scanner;

public class MineSweeper {
	public static void main(String[] args) {
		
		// Scanner to read in input from user or test file
		Scanner scan = new Scanner(System.in);
		// i initialized to 1 to begin Field # header before each Field
		int i = 1;

		// While loop that will continue until there is no more input
		// or 0 0 is encountered
		while (scan.hasNext()) {
			// The rows and columns are increased by 2 to make room
			// for the buffer
			int rows = scan.nextInt() + 2;
			int columns = scan.nextInt() + 2;

			// If rows added to columns is 4, that means that initial input
			// was 0 0 and the loop should stop
			if (rows + columns != 4) {
				System.out.println("Field #" + i + ":");
				char[][] container = GenerateContainer(rows, columns);
				GenerateMineField(scan, container);
				
				System.out.println();
				
				PrintMineField(GenerateHintField(container));
				
				System.out.println();
				i++;
			} else {
				break;
			}
		}
	}

	// Method to create a container array to give a 1 space buffer
	// around each edge of actual mine field array. Takes in the 
	// number of rows and columns to make the array, then returns a 2d array
	// of that size populated with dots. These dots will later be changed
	// in another method, but for now will ensure the edges will count
	// as empty spaces for counting the number of bombs
	private static char[][] GenerateContainer(int rows, int columns) {
		char[][] container = new char[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < columns; k++) {
				container[i][k] = '.';
			}
		}
		return container;
	}

	// Method to create a mine field. It takes in a scanner parameter
	// that is connected to the console to parse the input, and a 2d
	// char array. It populates the inner part (not the one space buffer)
	// of the previously generated container field with input from the user
	// and returns this array.
	private static char[][] GenerateMineField(Scanner scan, char[][] hintField) {
		int rows = hintField.length;
		int columns = hintField[0].length;

		// i and k begin at 1 and end at 1 less than the length and height
		// of the array to preserve the buffer zone
		for (int i = 1; i < rows - 1; i++) { 
			String line = scan.next();
			for (int k = 1; k < columns - 1; k++) {
				// this parses each char in the inputed line
				hintField[i][k] = line.charAt(k - 1);
			}
		}
		return hintField;
	}

	// Method that takes in a 2d array and then prints each item,
	// in the array to be displayed as a field
	private static void PrintMineField(char[][] mineField) {
		// Begins each row and column at 1 and end less than the 
		// total height and length as to not include the buffer area
		for (int i = 1; i < mineField.length - 1; i++) {
			for (int k = 1; k < mineField[0].length - 1; k++) {
				System.out.print(mineField[i][k]);
			}
			System.out.println();
		}
	}

	// Method to search each position in a 2d array to determine if
	// there is a safe place in that position. If there is,
	// then a helper method is called to correctly increment the number
	// now placed in that position. If there are no bombs, then it will
	// be a zero. If a bomb is found in the position, then nothing is done.
	// The resulting array with numbers in place of dots is returned
	private static char[][] GenerateHintField(char[][] mineField) {
		int rows = mineField.length;
		int columns = mineField[0].length;
		// Begins each row and column at 1 and end less than the 
		// total height and length as to not include the buffer area
		for (int i = 1; i < rows - 1; i++) {
			for (int k = 1; k < columns - 1; k++) {
				if (mineField[i][k] != '*') {
					mineField[i][k] = FindHints(mineField, i, k);
				}
			}
		}
		return mineField;
	}

	// Helper method to determine the number of bombs surrounding 
	// a position in the field. The 2d char array field is passed in
	// along with two ints as the position in the field. Every space surrounding 
	// the position is checked if there is a bomb, and if there is, count 
	// is incremented. The resulting number is returned and is the number
	// of bombs that space is adjacent to
	private static char FindHints(char[][] mineField, int row, int column) {
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