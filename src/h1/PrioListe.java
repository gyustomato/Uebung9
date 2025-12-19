package h1;

import java.util.ArrayList;

public class PrioListe {
	public ArrayList<Patient> myList = new ArrayList<>();

	public void addPatient(Patient p) {
		if (myList.isEmpty()) {
			myList.add(p);
		} else {
			for (int i = myList.size(); i >= 0; i--) {
				if (myList.get(i).prio > p.prio) {
					myList.add(i, p);
				}
			}
		}
	}
	
	public Patient getNextPatient() {
		 return myList.removeFirst();
		 // oder: Patient raus = myList.getFirst();   myList.remove(0);   return raus;
	}
	
	public int getPosition(Patient p) {
		return myList.indexOf(p);
	}
}
