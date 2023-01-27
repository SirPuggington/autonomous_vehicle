public interface IDoor {
    DoorState unlock();
    DoorState lock();
    DoorState close();
    DoorState open();
}
