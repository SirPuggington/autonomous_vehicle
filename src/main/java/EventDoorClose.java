public class EventDoorClose {
    private DoorSide side;

    public EventDoorClose (DoorSide side) {
        this.side = side;
    }

    public DoorSide getSide() {
        return side;
    }

    public String toString() {
        return "door | close";
    }
}
