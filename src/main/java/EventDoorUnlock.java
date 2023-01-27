public class EventDoorUnlock {
    private DoorSide side;

    public EventDoorUnlock (DoorSide side) {
        this.side = side;
    }

    public DoorSide getSide() {
        return side;
    }
    public String toString() {
        return "door | unlock";
    }
}
