import com.google.common.eventbus.Subscribe;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class DoorManagement extends Subscriber{

    private final Object[] doors = new Object[4];

    public DoorManagement() {
        super(2);
        for (int i = 0; i < 4; i++) {
            doors[i] = DoorFactory.build();
        }
    }

    private void invokeMethod(Object door, String doorMethod) {
        try{
            Method m = door.getClass().getMethod(doorMethod);
            m.invoke(door);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selectDoorSide(DoorSide side, DoorState state) {
        switch (side){
            case RIGHT -> {
                for (int i = 0; i < 2; i++) {
                    invokeMethod(doors[i], state.toString().toLowerCase());
                }
                break;
            }
            case LEFT -> {
                for (int i = 2; i < 4; i++) {
                    invokeMethod(doors[i], state.toString().toLowerCase());
                }
                break;
            }
            case ALL -> {
                for (int i = 0; i < 4; i++) {
                    invokeMethod(doors[i], state.toString().toLowerCase());
                }
                break;
            }
        }
    }

    @Subscribe
    public void receive(EventDoorUnlock eventDoorUnlock) {
        selectDoorSide(eventDoorUnlock.getSide(), DoorState.UNLOCKED);
    }
    @Subscribe
    public void receive(EventDoorLock eventDoorLock) {
        selectDoorSide(eventDoorLock.getSide(), DoorState.LOCKED);
    }
    @Subscribe
    public void receive(EventDoorOpen eventDoorOpen) {
        selectDoorSide(eventDoorOpen.getSide(), DoorState.OPENED);
    }
    @Subscribe
    public void receive(EventDoorClose eventDoorClose) {
        selectDoorSide(eventDoorClose.getSide(), DoorState.CLOSED);
    }
}
