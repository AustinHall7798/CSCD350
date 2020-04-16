import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InputCreater {
	public static void main(String[] args) throws IOException {

		ArrayList<String> text = new ArrayList<String>();
		
		try {
		      File myObj = new File("InputFile.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		        System.out.println(myObj.getAbsolutePath());
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		FileWriter writer = new FileWriter("InputFile.txt");

		text.add("4 4\n");
		text.add("*...\n");
		text.add("....\n");
		text.add(".*..\n");
		text.add("....\n");
		text.add("3 5\n");
		text.add("**...\n");
		text.add(".....\n");
		text.add(".*...\n");
		
		text.add("1 1\n");
		text.add(".\n");
		text.add("1 1\n");
		text.add("*\n");
		
		int i = 0, k = 0;
		text.add("100 100\n");
		while(i < 100) {
			while(k < 100) {
				text.add(".");
				k++;
			}
			k = 0;
			text.add("\n");
			i++;
		}
		
		i = 0;
		k = 0;
		text.add("100 100\n");
		while(i < 100) {
			while(k < 100) {
				text.add("*");
				k++;
			}
			k = 0;
			text.add("\n");
			i++;
		}
		
		i = 0;
		k = 0;
		text.add("100 100\n");
		while(i < 100) {
			while(k < 100) {
				int ran = (Math.random() <= 0.5) ? 1 : 2;
				if(ran == 1) {
					text.add(".");
				} else {
					text.add("*");
				}
				k++;
			}
			k = 0;
			i++;
			text.add("\n");
		}
		text.add("0 0");
		
		for (String line : text) {
			writer.write(line);
		}
		writer.close();
	}
}