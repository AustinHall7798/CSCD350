// InputCreater
// Austin Hall
// This File creates a new text file used as the input
// for testing the MineSweeper class. There are edge case and non-edge
// case examples appended to this file

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InputCreater {
	public static void main(String[] args) throws IOException {

		// ArrayList to hold lines to be added to final InputFile
		ArrayList<String> textTobeAdded = new ArrayList<String>();
		
		// Attempts to create a new text File called InputFile. 
		// If one already exists, It doesn't create a new one
		// and will catch IO Exceptions
		try {
		      File myObj = new File("InputFile.txt");
		      myObj.createNewFile();
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		// FileWriter to add text to previously created file
		FileWriter writer = new FileWriter("InputFile.txt");

		// Add example input to the InputFile, newline character
		// so MineSweeper will know when a line ends
		textTobeAdded.add("4 4\n");
		textTobeAdded.add("*...\n");
		textTobeAdded.add("....\n");
		textTobeAdded.add(".*..\n");
		textTobeAdded.add("....\n");
		textTobeAdded.add("3 5\n");
		textTobeAdded.add("**...\n");
		textTobeAdded.add(".....\n");
		textTobeAdded.add(".*...\n");
		
		// Adds edge case minimum size of mine field, with both bomb
		// and no bomb cases, to InputFile
		textTobeAdded.add("1 1\n");
		textTobeAdded.add(".\n");
		textTobeAdded.add("1 1\n");
		textTobeAdded.add("*\n");
		
		// Adds the edge case maximum size of mine field, with no bombs
		int i = 0, k = 0;
		textTobeAdded.add("100 100\n");
		while(i < 100) {
			while(k < 100) {
				textTobeAdded.add(".");
				k++;
			} // End inner while loop
			k = 0; // K is reset to 0 to continue next run of outer loop
			textTobeAdded.add("\n"); // adds newline character
			i++;
		} // End outer while loop
		
		// Adds the edge case maximum size of mine field, with all bombs
		i = 0;
		k = 0;
		textTobeAdded.add("100 100\n");
		while(i < 100) {
			while(k < 100) {
				textTobeAdded.add("*");
				k++;
			} // End inner while loop
			k = 0; // K is reset to 0 to continue next run of outer loop
			textTobeAdded.add("\n"); // adds newline character
			i++;
		} // End outer while loop
		
		// Adds the edge case maximum size of mine field, with 
		// random bombs or safe spaces
		i = 0;
		k = 0;
		textTobeAdded.add("100 100\n");
		while(i < 100) {
			while(k < 100) {
				int ran = (Math.random() <= 0.5) ? 1 : 2;
				if(ran == 1) {
					textTobeAdded.add(".");
				} else {
					textTobeAdded.add("*");
				}
				k++;
			} // End inner while loop
			k = 0; // K is reset to 0 to continue next run of outer loop
			textTobeAdded.add("\n"); // adds newline character
			i++;
		} // End outer while loop
		textTobeAdded.add("0 0");
		
		// for loop to add each string in the text ArrayList to the
		// InputFile
		for (String line : textTobeAdded) {
			writer.write(line);
		}
		writer.close();
	}
}