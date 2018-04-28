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
	static int start_x, start_y, end_x, end_y, earliest_start, latest_finish;
	static ArrayList<Ride> rides = new ArrayList<Ride>();
	static ArrayList<Car> vehicles = new ArrayList<Car>();

	public static void main(String[] args) throws IOException {
		String inputFileName = "a_example.in";
		String outputFileName = inputFileName.replace("in", "out");
		File inputFile = new File(inputFileName);
		File outputFile = new File(outputFileName);
		Scanner sc = new Scanner(inputFile);
		Scanner scout = new Scanner(outputFile);

		row = sc.nextInt();
		column = sc.nextInt();
		vehicle = sc.nextInt();
		ride = sc.nextInt();
		bonus = sc.nextInt();
		step = sc.nextInt();

		// Read the input file for grading
		for (int i = 0; i < ride; i++) {
			start_x = sc.nextInt();
			start_y = sc.nextInt();
			end_x = sc.nextInt();
			end_y = sc.nextInt();
			earliest_start = sc.nextInt();
			latest_finish = sc.nextInt();
			rides.add(new Ride(start_x, start_y, end_x, end_y, earliest_start, latest_finish));
		}

		// Read the output file for grading
		for (int i = 0; i < vehicle; i++) {
			int numRides = scout.nextInt();
			ArrayList<Ride> rd = new ArrayList<Ride>();
			for (int j = 0; j < numRides; j++) {
				Ride mr = rides.get(scout.nextInt());
				rd.add(mr);
			}
			vehicles.add(new Car(i, rd));
			vehicles.get(i).print();
		}

		System.out.println("Grade " + gradeCalc(vehicles));

	}

	public static int distanceCalc(Car c, Ride r) {
		return Math.abs(r.start_x - c.curPos_x) + Math.abs(r.start_y - c.curPos_y);
	}

	public static int gradeCalc(ArrayList<Car> c) {
		int grade = 0;
		boolean isBonus = false;
		boolean isExecuted = true;
		for (Car car : c) {
			for (Ride ride : car.rides) { 
				int remainingDist = ride.get_distance();
				car.current_timestep += distanceCalc(car, ride);
				if (ride.earliest_start > car.current_timestep) {
					car.current_timestep = ride.earliest_start;
					while(ride.ride(car.current_timestep) && remainingDist >0) {
						car.current_timestep += 1;
						remainingDist -= 1;
					}
					isBonus = true;
					isExecuted = true;
				} else if (ride.earliest_start == car.current_timestep) {
					while(ride.ride(car.current_timestep) && remainingDist >0) {
						car.current_timestep += 1;
						remainingDist -= 1;
					}
					isBonus = true;
					isExecuted = true;
				} else {
					while(ride.ride(car.current_timestep) && remainingDist >0) {
						car.current_timestep += 1;
						remainingDist -= 1;
					}
					isExecuted = true;
					isBonus = true;
				}
				if (ride.latest_finish > car.current_timestep)
					isExecuted = false;
				if (isExecuted) {
					grade += ride.get_distance();
					if (isBonus)
						grade += bonus;
				}
			}

		}
		return grade;
	}

}
