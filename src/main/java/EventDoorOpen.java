public class EventDoorOpen {
    private DoorSide side;

    public EventDoorOpen (DoorSide side) {
        this.side = side;
    }

    public DoorSide getSide() {
        return side;
    }
    public String toString() {
        return "door | open";
    }
}
