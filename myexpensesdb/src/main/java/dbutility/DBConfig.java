package dbutility;

class DBConfig {

    private static String ip = "localhost";
    private static String port = "3306";
    private static String dbName = "myexpense";
    private static String username = "root";
    private static String password = "12345";

    public static String getConnectionName(){
        String s = "jdbc:mysql://"+DBConfig.getIp()+":"+DBConfig.getPort()+"/"+DBConfig.getDbName()+"?useSSL=false";
        return s;
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        DBConfig.ip = ip;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        DBConfig.port = port;
    }

    public static String getDbName() {
        return dbName;
    }

    public static void setDbName(String dbName) {
        DBConfig.dbName = dbName;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DBConfig.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DBConfig.password = password;
    }
}
