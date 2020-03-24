import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private BusStop busStop;
    private Person person;
    private Person person1;
    private Person person2;

    @Before
    public void before(){
        bus = new Bus("Edinburgh", 5);
        busStop = new BusStop("Haymarket");
        person = new Person("Calum");
        person1 = new Person("Roosa");
        person2 = new Person("Noel");
    }

    @Test
    public void checkBusStartsEmpty(){
        assertEquals(0, bus.getPassengers());
    }

    @Test
    public void checkQueueStartsEmpty(){
        assertEquals(0, busStop.getQueue());
    }

    @Test
    public void checkHasDestination(){
        assertEquals("Edinburgh", bus.getDestination());
    }

    @Test
    public void checkBusStopHasName(){
        assertEquals("Haymarket", busStop.getBusStopName());
    }

    @Test
    public void checkHasCapacity(){
        assertEquals(5, bus.getCapacity());
    }

    @Test
    public void checkOverCapacity(){
        bus.addPassengerToBus(person);
        bus.addPassengerToBus(person);
        bus.addPassengerToBus(person1);
        bus.addPassengerToBus(person1);
        bus.addPassengerToBus(person2);
        bus.addPassengerToBus(person2);
        assertEquals(5, bus.getPassengers());
    }

    @Test
    public void canAddPassengerToBus(){
        bus.addPassengerToBus(person);
        assertEquals(1, bus.getPassengers());
    }

    @Test
    public void canAddPersonToQueue(){
        busStop.addPersonToQueue(person1);
        assertEquals(1, busStop.getQueue());
    }

    @Test
    public void canDeactivatePassenger(){
        bus.addPassengerToBus(person);
        bus.addPassengerToBus(person1);
        bus.deactivatePassenger(person1);
        assertEquals(1, bus.getPassengers());
    }

    @Test
    public void canDeactivatePersonFromQueue(){
        busStop.addPersonToQueue(person);
        busStop.addPersonToQueue(person1);
        busStop.deactivatePersonFromQueue(person1);
        assertEquals(1, busStop.getQueue());
    }

    @Test
    public void canPickupPeopleFromQueue(){
        busStop.addPersonToQueue(person);
        busStop.addPersonToQueue(person1);
        busStop.addPersonToQueue(person2);
        bus.pickupPassengers(person1, busStop);
        assertEquals(1, bus.getPassengers());
        assertEquals(2, busStop.getQueue());
    }
}