package zhy2002.misc;

public interface SystemConfigMBean {

    void setThreadCount(int count);

    int getThreadCount();

    void setSchemaName(String schemaName);

    String getSchemaName();

    String doConfig();

}
