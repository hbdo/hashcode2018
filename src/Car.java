import java.util.ArrayList;

public class Car {
	
	public int id, current_timestep;
	public ArrayList<Ride> rides;
	public static int ID = 0;
	
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
}
