public class ElectricEngine {
    // static instance
    private static final ElectricEngine instance = new ElectricEngine();
    // port
    public Port port;
    private String serialNumber;
    private ElectricEngineState state;


    private ElectricEngine() {
        port = new Port();
    }

    public static ElectricEngine getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "Workshop | Electric Engine | [" + serialNumber + "]";
    }

    private ElectricEngineState innerOn() {
        state = ElectricEngineState.ON;
        return state;
    }

    public ElectricEngineState innerOff() {
        state = ElectricEngineState.OFF;
        return state;
    }

    public class Port implements IElectricEngine {
        public String version() {
            return innerVersion();
        }

        public ElectricEngineState on() {
            return innerOn();
        }

        public ElectricEngineState off() {
            return innerOff();
        }

        public String setSerialNumber(String inputSerialNumber) {
            serialNumber = inputSerialNumber;
            return serialNumber;
        }
    }
}