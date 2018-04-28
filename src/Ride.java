import java.lang.Math;

public class Ride {

	public int id, start_x, start_y, end_x, end_y, earliest_start, latest_finish;
	public Car car = null;

	public static int ID = 0;;

	public Ride(int start_x, int start_y, int end_x, int end_y, int earliest_start, int latest_finish) {
		this.id = ID++;
		this.start_x = start_x;
		this.start_y = start_y;
		this.end_x = end_x;
		this.end_y = end_y;
		this.earliest_start = earliest_start;
		this.latest_finish = latest_finish;
	}

	public int get_distance() {
		return Math.abs(end_y - start_y) + Math.abs(end_x - start_x);
	}
	
	public void print() {
		System.out.println("Ride "+ this.id + " start x " + this.start_x + " start y " + this.start_y + " end x " + this.end_x + " end y " + this.end_y + " earliest start " + this.earliest_start + " latest finish " + this.latest_finish);
	}
	
}
