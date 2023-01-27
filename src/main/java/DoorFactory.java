import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
public class DoorFactory {

    public static Object build() {
        Object port = null;



        try {
            URL[] urls = {new File(Configuration.INSTANCE.pathToJavaArchiveDoor + "door.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, DoorFactory.class.getClassLoader());
            Class<?> doorClass = Class.forName("Door", true, urlClassLoader);
            Object doorInstance = doorClass.getMethod("getInstance").invoke(null);
            port = doorClass.getDeclaredField("port").get(doorInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return port;
    }

    public static void main(String... args) {
        Object port = build();
        System.out.println("port   | " + port.hashCode());

        try {
            Method onMethod = port.getClass().getMethod("open");
            System.out.println(onMethod);

            DoorState result = (DoorState) onMethod.invoke(port);
            System.out.println("result | " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
