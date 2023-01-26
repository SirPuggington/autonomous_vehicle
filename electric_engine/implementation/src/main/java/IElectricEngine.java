public interface IElectricEngine {
    String version();

    String setSerialNumber(String serialNumber);

    ElectricEngineState on();

    ElectricEngineState off();
}
