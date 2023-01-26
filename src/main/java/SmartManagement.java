import com.google.common.eventbus.Subscribe;

import java.lang.reflect.Method;

public class SmartManagement extends Subscriber {
    private final Object electricEnginePort;

    public SmartManagement() {
        super(1);
        electricEnginePort = ElectricEngineFactory.build();
    }

    @Subscribe
    public void receive(EventElectricEngineVersion eventElectricEngineVersion) {
        try {
            Method versionMethod = electricEnginePort.getClass().getDeclaredMethod("version");
            String result = (String) versionMethod.invoke(electricEnginePort);
            System.out.println("receive -> electricEngineVersion  | version : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventElectricEngineSetSerialNumber eventElectricEngineSetSerialNumber) {
        try {
            Method setSerialNumberMethod = electricEnginePort.getClass().getDeclaredMethod("setSerialNumber", String.class);
            setSerialNumberMethod.invoke(electricEnginePort, eventElectricEngineSetSerialNumber.getSerialNumber());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventElectricEngineOn eventElectricEngineOn) {
        try {
            Method onMethod = electricEnginePort.getClass().getDeclaredMethod("on");
            ElectricEngineState result = (ElectricEngineState) onMethod.invoke(electricEnginePort);
            System.out.println("receive -> electricEngineOn  | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EventElectricEngineOff eventElectricEngineOff) {
        try {
            Method offMethod = electricEnginePort.getClass().getDeclaredMethod("off");
            ElectricEngineState result = (ElectricEngineState) offMethod.invoke(electricEnginePort);
            System.out.println("receive -> electricEngineOff | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}