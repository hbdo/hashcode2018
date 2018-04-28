import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Grader {

	static BufferedWriter bf;
	static BufferedWriter bfout;
	static int row, column, vehicle, ride, bonus, step;
	
	public static void main(String[] args) throws IOException {
		String outputFileName = "output.txt";
		String inputFileName = "input.txt";
		File inputFile = new File(inputFileName);
		File outputFile = new File(outputFileName);
		Scanner sc = new Scanner(inputFile);
		Scanner scout = new Scanner(outputFile);
		bf = new BufferedWriter(new FileWriter(new File(inputFileName)));
		bfout = new BufferedWriter(new FileWriter(new File(outputFileName)));
		
		row = sc.nextInt();
		column=sc.nextInt();
		vehicle=sc.nextInt();
		ride=sc.nextInt();
		bonus=sc.nextInt();
		step=sc.nextInt();
		
		
		
		
	}
	
}
