import org.junit.jupiter.api.*;

import java.lang.reflect.Method;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestManagement {
    private Object enginePort;
    private final Object[] doorRight = new Object[2];
    private final Object[] doorLeft = new Object[2];

    @BeforeEach
    public void setup() {
        enginePort = ElectricEngineFactory.build();

        for (int i = 0; i<2; i++) {
            doorRight[i] = DoorFactory.build();
            doorLeft[i] = DoorFactory.build();
        }
    }

    private void invokeMethod(Object door, String doorMethod) {
        try{
            Method m = door.getClass().getMethod(doorMethod);
            m.invoke(door);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selectDoorSide(DoorSide side, DoorState state) {
        switch (side){
            case RIGHT -> {
                for (int i = 0; i < 2; i++) {
                    invokeMethod(doorRight[i], state.toString().toLowerCase());
                }
                break;
            }
            case LEFT -> {
                for (int i = 0; i < 2; i++) {
                    invokeMethod(doorLeft[i], state.toString().toLowerCase());
                }
                break;
            }
            case ALL -> {
                for (int i = 0; i < 2; i++) {
                    invokeMethod(doorRight[i], state.toString().toLowerCase());
                    invokeMethod(doorLeft[i], state.toString().toLowerCase());
                }
                break;
            }
        }
    }

    @Test
    @Order(1)
    public void version() {
        try {
            Method versionMethod = enginePort.getClass().getDeclaredMethod("version");
            String result = (String) versionMethod.invoke(enginePort);
            assertTrue(result.contains("Electric Engine"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void setSerialNumber() {
        try {
            Method setSerialNumberMethod = enginePort.getClass().getDeclaredMethod("setSerialNumber", String.class);
            String result = (String) setSerialNumberMethod.invoke(enginePort, UUID.randomUUID().toString());
            assertFalse(result.contains("null"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Order(3)
    public void on() {
        try {
            Method onMethod = enginePort.getClass().getDeclaredMethod("on");
            ElectricEngineState result = (ElectricEngineState) onMethod.invoke(enginePort);
            assertEquals(ElectricEngineState.ON, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Order(4)
    public void off() {
        try {
            Method offMethod = enginePort.getClass().getDeclaredMethod("off");
            ElectricEngineState result = (ElectricEngineState) offMethod.invoke(enginePort);
            assertEquals(ElectricEngineState.OFF, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Order(5)
    public void unlockAll() {
        this.selectDoorSide(DoorSide.ALL, DoorState.UNLOCKED);
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorLeft[i].getClass().getMethod("getState");
                assertEquals("UNLOCK", (String) m.invoke(doorLeft[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorRight[i].getClass().getMethod("getState");
                assertEquals("UNLOCK", (String) m.invoke(doorRight[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @Order(6)
    public void lockAll() {
        this.selectDoorSide(DoorSide.ALL, DoorState.LOCKED);
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorLeft[i].getClass().getMethod("getState");
                assertEquals("LOCK", (String) m.invoke(doorLeft[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorRight[i].getClass().getMethod("getState");
                assertEquals("LOCK", (String) m.invoke(doorRight[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @Order(7)
    public void openAll() {
        this.selectDoorSide(DoorSide.ALL, DoorState.OPENED);
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorLeft[i].getClass().getMethod("getState");
                assertEquals("OPEN", (String) m.invoke(doorLeft[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorRight[i].getClass().getMethod("getState");
                assertEquals("OPEN", (String) m.invoke(doorRight[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @Order(8)
    public void closeAll() {
        this.selectDoorSide(DoorSide.ALL, DoorState.CLOSED);
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorLeft[i].getClass().getMethod("getState");
                assertEquals("CLOSE", (String) m.invoke(doorLeft[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorRight[i].getClass().getMethod("getState");
                assertEquals("CLOSE", (String) m.invoke(doorRight[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @Order(9)
    public void unlockLeftDoors() {
        this.selectDoorSide(DoorSide.LEFT, DoorState.UNLOCKED);
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorLeft[i].getClass().getMethod("getState");
                assertEquals("UNLOCK", (String) m.invoke(doorLeft[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    @Order(10)
    public void unlockRightDoors() {
        this.selectDoorSide(DoorSide.RIGHT, DoorState.UNLOCKED);
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorRight[i].getClass().getMethod("getState");
                assertEquals("UNLOCK", (String) m.invoke(doorRight[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @Order(11)
    public void lockLeftDoors() {
        this.selectDoorSide(DoorSide.LEFT, DoorState.LOCKED);
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorLeft[i].getClass().getMethod("getState");
                assertEquals("LOCK", (String) m.invoke(doorLeft[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    @Order(12)
    public void lockRightDoors() {
        this.selectDoorSide(DoorSide.RIGHT, DoorState.LOCKED);
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorRight[i].getClass().getMethod("getState");
                assertEquals("LOCK", (String) m.invoke(doorRight[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @Order(13)
    public void openLeftDoors() {
        this.selectDoorSide(DoorSide.LEFT, DoorState.OPENED);
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorLeft[i].getClass().getMethod("getState");
                assertEquals("OPEN", (String) m.invoke(doorLeft[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    @Order(14)
    public void openRightDoors() {
        this.selectDoorSide(DoorSide.RIGHT, DoorState.OPENED);
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorRight[i].getClass().getMethod("getState");
                assertEquals("OPEN", (String) m.invoke(doorRight[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @Order(15)
    public void closeLeftDoors() {
        this.selectDoorSide(DoorSide.LEFT, DoorState.CLOSED);
        for (int i = 0; i < 2; i++) {
            try {
                Method m = doorRight[i].getClass().getMethod("getState");
                assertEquals("CLOSE", (String) m.invoke(doorRight[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}