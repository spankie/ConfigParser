package app;

public class App {
    public static void main(String[] args) throws Exception {
        ConfigParser configParser = new ConfigParser("config.txt");
        System.out.println(configParser.get("application.name"));
    }
}