import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ElectricEngineFactory {
    public static Object build() {
        Object port = null;

        try {
            URL[] urls = {new File(Configuration.INSTANCE.pathToJavaArchiveElectricEngine + "engine.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, ElectricEngineFactory.class.getClassLoader());
            Class<?> electricEngineClass = Class.forName("ElectricEngine", true, urlClassLoader);
            Object electricEngineInstance = electricEngineClass.getMethod("getInstance").invoke(null);
            port = electricEngineClass.getDeclaredField("port").get(electricEngineInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return port;
    }

    public static void main(String... args) {
        Object port = build();
        System.out.println("port   | " + port.hashCode());

        try {
            Method onMethod = port.getClass().getMethod("on");
            System.out.println(onMethod);

            ElectricEngineState result = (ElectricEngineState) onMethod.invoke(port);
            System.out.println("result | " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}