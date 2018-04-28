import java.util.ArrayList;

public class Car {

	public int id, current_timestep;
	public ArrayList<Ride> rides;
	public static int ID = 0;
	public int curPos_x = 0;
	public int curPos_y = 0;

	public Car() {
		this.id = ID++;
		this.rides = new ArrayList<Ride>();
		this.current_timestep = 0;
	}

	public Car(int id, ArrayList<Ride> rides) {
		this.rides = rides;
		this.id = id;
	}

	public int get_ride_count() {
		return this.rides.size();
	}

	public void print() {
		System.out.println("Car " + this.id + ": ");
		for (Ride r : rides) {
			r.print();
		}
	}

	protected void move(int dest_x, int dest_y) {
		this.current_timestep += Math.abs(dest_x - this.curPos_x) + Math.abs(dest_y - this.curPos_y);
		this.curPos_x=dest_x;
		this.curPos_y=dest_y;
	}

	protected int expectedArrival(Ride r) {
		int temp = current_timestep;
		temp += Math.abs(r.end_x - this.curPos_x) + Math.abs(r.end_y - this.curPos_y);
		return temp;
	}
}
