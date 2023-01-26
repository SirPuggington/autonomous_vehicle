public class EventElectricEngineSetSerialNumber {
    private final String serialNumber;

    public EventElectricEngineSetSerialNumber(String inputSerialNumber) {
        serialNumber = inputSerialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String toString() {
        return "electric engine | set serial number | " + serialNumber;
    }
}
