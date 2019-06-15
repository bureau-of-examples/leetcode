package zhy2002.misc;

public class SystemConfig implements SystemConfigMBean {

    private int threadCount;
    private String schemaName;

    public SystemConfig(int threadCount, String schemaName) {
        this.threadCount = threadCount;
        this.schemaName = schemaName;
    }

    @Override
    public void setThreadCount(int count) {
        this.threadCount = count;
    }

    @Override
    public int getThreadCount() {
        return threadCount;
    }

    @Override
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    @Override
    public String getSchemaName() {
        return this.schemaName;
    }

    @Override
    public String doConfig() {
        return String.format("Thread count = %s, schema name = %s", threadCount, schemaName);
    }
}
