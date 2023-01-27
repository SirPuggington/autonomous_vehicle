public class Door {
    // static instance
    private static final Door instance = new Door();

    // port
    public Port port;
    private DoorState state;
    // constructor
    private Door() {
        port = new Port();
    }

    public static Door getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "Workshop | Electric Engine ";
    }

    private DoorState innerUnlock() {
        state = DoorState.UNLOCK;
        return state;
    }
    private DoorState innerLock() {
        state = DoorState.LOCK;
        return state;
    }
    private DoorState innerOpen() {
        state = DoorState.OPEN;
        return state;
    }
    private DoorState innerClose() {
        state = DoorState.CLOSE;
        return state;
    }

    public class Port implements IDoor {
        public String version() {
            return innerVersion();
        }

        public DoorState unlock() {
            return innerUnlock();
        }

        public DoorState lock() {
            return innerLock();
        }

        public DoorState open() {
            return innerOpen();
        }

        public DoorState close() {
            return innerClose();
        }

        public String getState() {
            return state.name();
        }



    }
}
