import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Point;


public class Grader {

	static BufferedWriter bf;
	static BufferedWriter bfout;
	static int row, column, vehicle, ride, bonus, step;
	static int start_x, start_y, end_x, end_y, earliest_start, earliest_finish;
	static ArrayList<Ride> rides = new ArrayList<Ride>();
	static ArrayList<Car> vehicles = new ArrayList<Car>();
	
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
		
		for(int i=0; i<ride; i++) {
			start_x = sc.nextInt();
			start_y = sc.nextInt();
			end_x = sc.nextInt();
			end_y = sc.nextInt();
			earliest_start=sc.nextInt();
			earliest_finish=sc.nextInt();
			rides.add(new Ride(start_x, start_y, end_x, end_y, earliest_start, earliest_finish));
		}
		
		for(int i=0; i<vehicle; i++) {
			int numRides = sc.nextInt();
			ArrayList<Ride> rd = new ArrayList<Ride>();
			for(int j=0; j<numRides; j++) {
				rd.add(rides.get(sc.nextInt()));
			}
			vehicles.add(new Car());
		}
		
		
		
	}
	
	public int gradeCalc(ArrayList<Ride> r ) {
		
		return 0;
	}
	
}
