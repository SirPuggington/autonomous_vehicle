import com.google.common.eventbus.EventBus;

public class AutonomousVehicle {
    private final EventBus eventBus;

    public AutonomousVehicle() {
        eventBus = new EventBus();
    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void electricEngineVersion() {
        eventBus.post(new EventElectricEngineVersion());
    }

    public void electricEngineSetSerialNumber(String serialNumber) {
        eventBus.post(new EventElectricEngineSetSerialNumber(serialNumber));
    }

    public void electricEngineOn() {
        eventBus.post(new EventElectricEngineOn());
    }

    public void electricEngineOff() {
        eventBus.post(new EventElectricEngineOff());
    }

    public void unlockAllDoors() {
        eventBus.post(new EventDoorUnlock());
    }
}