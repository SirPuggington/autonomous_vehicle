public interface IDoor {
    String version();
    DoorState open();
    DoorState close();
    DoorState lock();
    DoorState unlock();
}
