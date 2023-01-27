import java.util.UUID;

public class Application {
    public static void main(String... args) {
        AutonomousVehicle vehicle = new AutonomousVehicle();

        vehicle.addSubscriber(new SmartManagement());
        vehicle.addSubscriber(new DoorManagement());

        vehicle.electricEngineVersion();
        vehicle.electricEngineSetSerialNumber(UUID.randomUUID().toString());
        vehicle.electricEngineVersion();

        vehicle.electricEngineOn();
        vehicle.electricEngineOff();

        vehicle.unlockAllDoors();
        vehicle.lockAllDoors();
        vehicle.openAllDoors();
        vehicle.closeAllDoors();

        vehicle.unlockRightDoors();
        vehicle.lockRightDoors();
        vehicle.openRightDoors();
        vehicle.closeRightDoors();

        vehicle.unlockLeftDoors();
        vehicle.lockLeftDoors();
        vehicle.openLeftDoors();
        vehicle.closeLeftDoors();


    }
}