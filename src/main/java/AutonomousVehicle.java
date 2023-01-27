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

    //All doors
    public void unlockAllDoors() {
        eventBus.post(new EventDoorUnlock(new EventDoorUnlock(DoorSide.ALL).getSide()));
    }

    public void lockAllDoors() {
        eventBus.post(new EventDoorLock(new EventDoorUnlock(DoorSide.ALL).getSide()));
    }

    public void openAllDoors() {
        eventBus.post(new EventDoorLock(new EventDoorUnlock(DoorSide.ALL).getSide()));
    }

    public void closeAllDoors() {
        eventBus.post(new EventDoorLock(new EventDoorUnlock(DoorSide.ALL).getSide()));
    }

    //Right doors
    public void unlockRightDoors() {
        eventBus.post(new EventDoorUnlock(new EventDoorUnlock(DoorSide.RIGHT).getSide()));
    }

    public void lockRightDoors() {
        eventBus.post(new EventDoorLock(new EventDoorLock(DoorSide.RIGHT).getSide()));
    }

    public void openRightDoors() {
        eventBus.post(new EventDoorLock(new EventDoorOpen(DoorSide.RIGHT).getSide()));
    }

    public void closeRightDoors() {
        eventBus.post(new EventDoorLock(new EventDoorClose(DoorSide.RIGHT).getSide()));
    }

    //Left doors
    public void unlockLeftDoors() {
        eventBus.post(new EventDoorUnlock(new EventDoorUnlock(DoorSide.LEFT).getSide()));
    }

    public void lockLeftDoors() {
        eventBus.post(new EventDoorLock(new EventDoorLock(DoorSide.LEFT).getSide()));
    }

    public void openLeftDoors() {
        eventBus.post(new EventDoorLock(new EventDoorOpen(DoorSide.LEFT).getSide()));
    }

    public void closeLeftDoors() {
        eventBus.post(new EventDoorLock(new EventDoorClose(DoorSide.LEFT).getSide()));
    }
}