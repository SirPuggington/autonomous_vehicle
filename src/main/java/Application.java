import java.util.UUID;

public class Application {
    public static void main(String... args) {
        AutonomousVehicle vehicle = new AutonomousVehicle();
        vehicle.addSubscriber(new SmartManagement());

        vehicle.electricEngineVersion();
        vehicle.electricEngineSetSerialNumber(UUID.randomUUID().toString());
        vehicle.electricEngineVersion();

        vehicle.electricEngineOn();
        vehicle.electricEngineOff();


    }
}