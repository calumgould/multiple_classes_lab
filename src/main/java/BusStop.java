import java.util.ArrayList;

public class BusStop {

    private String name;
    private ArrayList<Person> queue;

    public BusStop(String name){
        this.name = name;
        this.queue = new ArrayList<Person>();
    }

    public void addPersonToQueue(Person person){
        this.queue.add(person);
    }

    public void deactivatePersonFromQueue(Person person){
        this.queue.remove(person);
    }

    public int getQueue() {
        return this.queue.size();
    }

    public String getBusStopName() {
        return this.name;
    }
}
