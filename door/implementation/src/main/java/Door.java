import java.util.UUID;

public class Door {
    private static final Door instance = new Door();

    public Port port;
    private DoorState state;

    private Door() {
        port = new Port();
    }

    public static Door getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "Workshop | Door | [" + UUID.randomUUID() + "]";
    }

    private DoorState innerOpen() {
        state = DoorState.OPEN;
        return state;
    }

    private DoorState innerClose() {
        state = DoorState.CLOSED;
        return state;
    }

    private DoorState innerLock() {
        state = DoorState.LOCKED;
        return state;
    }

    private DoorState innerUnlock() {
        state = DoorState.UNLOCKED;
        return state;
    }

    public class Port implements IDoor {
        public String version() {
            return innerVersion();
        }

        public DoorState open() {
            return innerOpen();
        }

        public DoorState close() {
            return innerClose();
        }

        public DoorState lock() {
            return innerLock();
        }

        public DoorState unlock() {
            return innerUnlock();
        }

    }
}

