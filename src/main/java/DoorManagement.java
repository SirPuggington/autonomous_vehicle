import com.google.common.eventbus.Subscribe;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class DoorManagement extends Subscriber {
    private final ArrayList<Object> doorPorts;

    public DoorManagement() {
        super(1);
        doorPorts = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Object doorPort = DoorFactory.build();
            doorPorts.add(doorPort);
        }
    }


    public int[] borders(DoorSide side) {
        int[] borders = {0, 4};
        if (side.equals(DoorSide.LEFT)) {
            borders[1] = 2;
        } else if (side.equals(DoorSide.RIGHT)) {
            borders[0] = 2;
        }
        return borders;
    }

    @Subscribe
    public void receive(EventDoorUnlock eventDoorUnlock,DoorSide side) {
       int[] borders=borders(side);
        for (int i=borders[0]; i<borders[1];i++) {
        try {
            Method unlockMethod = doorPorts.get(i).getClass().getDeclaredMethod("unlock");
            DoorState result = (DoorState) unlockMethod.invoke(doorPorts.get(i));
            System.out.println("receive -> doorUnlock  | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }}
    @Subscribe
    public void receive(EventDoorLock eventDoorLock,DoorSide side) {
       int[] borders=borders(side);
        for (int i=borders[0]; i<borders[1];i++) {
        try {
            Method lockMethod = doorPorts.get(i).getClass().getDeclaredMethod("lock");
            DoorState result = (DoorState) lockMethod.invoke(doorPorts.get(i));
            System.out.println("receive -> doorLock  | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }}
    @Subscribe
    public void receive(EventDoorOpen eventDoorOpen,DoorSide side) {
       int[] borders=borders(side);
        for (int i=borders[0]; i<borders[1];i++) {
        try {
            Method openMethod = doorPorts.get(i).getClass().getDeclaredMethod("open");
            DoorState result = (DoorState) openMethod.invoke(doorPorts.get(i));
            System.out.println("receive -> doorOpen  | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }}
    @Subscribe
    public void receive(EventDoorClose eventDoorClose,DoorSide side) {
       int[] borders=borders(side);
        for (int i=borders[0]; i<borders[1];i++) {
        try {
            Method closeMethod = doorPorts.get(i).getClass().getDeclaredMethod("close");
            DoorState result = (DoorState) closeMethod.invoke(doorPorts.get(i));
            System.out.println("receive -> doorClose  | state : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }}

}
