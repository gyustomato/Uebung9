package h2;
import java.util.ArrayList;

public class Bus {
	ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	public Bus() {
		passengers = new ArrayList<Passenger>();
	}
	
	public void enterBus(Passenger p) {
		passengers.add(p);
	}
	
	private void exitBus() {
		for(int i = passengers.size()-1; i>= 0; i--) {
			if(passengers.get(i).visited == passengers.get(i).planned) {
				passengers.remove(i);
			}
		}
	}
	
	public void nextStop(Passenger[] boarding) {
		for(int i = passengers.size()-1; i>= 0; i--) {
			passengers.get(i).visited += 1;
		}
		exitBus();
		for(int i=0; i<boarding.length;i++) {
			passengers.add(boarding[i]);
		}
	}
	
	public void nextStop() {
		for(int i = passengers.size()-1; i>= 0; i--) {
			passengers.get(i).visited += 1;
		}
		exitBus();
	}
	
	public ArrayList<Passenger> findPassengersWithoutTickets() {
		ArrayList<Passenger> ohneTicket = new ArrayList<>();
		for(int i = passengers.size()-1; i>= 0; i--) {
			if(passengers.get(i).ticket == false) {
				ohneTicket.addFirst(passengers.get(i));
				passengers.remove(i);
			}
		}
		return ohneTicket;
	}
	
	public void transferPassengers(Bus otherBus, String[] passengerNames) {
		ArrayList<Passenger> umsteiger = new ArrayList<>();
		for(int i = passengers.size()-1; i>= 0; i--) {
			for(int j= 0; j<passengerNames.length; j++) {
				if(passengers.get(i).name == passengerNames[j]) {
					umsteiger.addFirst(passengers.get(i));
					passengers.remove(i);
				}
			}
		}
		for(int k=0; k<umsteiger.size();k++) {
			otherBus.enterBus(umsteiger.get(k));
		}
	}
}
