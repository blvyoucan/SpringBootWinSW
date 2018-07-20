package sample;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class ApplicationShutdown {
    public static final String DEFAULT_OBJECT_NAME = "sample:type=Application,name=application";

    public static void main(String[] args) {
        if( args.length == 0 ) {
            System.out.println("请传入JMX端口号");
        }
        String url = "service:jmx:rmi:///jndi/rmi://127.0.0.1:" + args[0] + "/jmxrmi";
        JMXServiceURL serviceUrl;
        try {
            serviceUrl = new JMXServiceURL(url);
            JMXConnector connection = JMXConnectorFactory.connect(serviceUrl, null);
            ObjectName objectName = new ObjectName(DEFAULT_OBJECT_NAME);
            connection.getMBeanServerConnection().invoke(objectName, "shutdown", null, null);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (InstanceNotFoundException e) {
            e.printStackTrace();
        } catch (MBeanException e) {
            e.printStackTrace();
        } catch (ReflectionException e) {
            e.printStackTrace();
        }
    }
}
