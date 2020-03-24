import java.util.ArrayList;

public class Bus {

    private String destination;
    private int capacity;
    private ArrayList<Person> passengers;

    public Bus(String destination, int capacity){
        this.destination = destination;
        this.capacity = capacity;
        this.passengers = new ArrayList<Person>();
    }

    public int getPassengers(){
        return this.passengers.size();
    }

    public String getDestination() {
        return this.destination;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean hasSpace(){
        return this.capacity > getPassengers();
    }

    public void addPassengerToBus(Person person){
        if(hasSpace()){
            this.passengers.add(person);
        }
    }

    public void deactivatePassenger(Person person){
        this.passengers.remove(person);
    }

    public void pickupPassengers(Person person, BusStop busStop){
        if(hasSpace()){
            this.passengers.add(person);
            busStop.deactivatePersonFromQueue(person);
        }
    }
}
