public class EventDoorLock {
    private DoorSide side;

    public EventDoorLock (DoorSide side) {
        this.side = side;
    }

    public DoorSide getSide() {
        return side;
    }
    public String toString() {
        return "door | lock";
    }
}
