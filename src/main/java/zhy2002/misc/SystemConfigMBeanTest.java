package zhy2002.misc;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class SystemConfigMBeanTest {

    private static final int DEFAULT_THREAD_COUNT = 10;
    private static final String DEFAULT_SCHEMA = "default";

    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        SystemConfigMBean mbean = new SystemConfig(DEFAULT_THREAD_COUNT, DEFAULT_SCHEMA);
        ObjectName name = new ObjectName("zhy2002.misc:type=SystemConfig");
        mbs.registerMBean(mbean, name);
        do {
            Thread.sleep(10000);
            System.out.println(mbean.doConfig());
        } while (mbean.getThreadCount() != 0);
    }
}
