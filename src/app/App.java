package app;

public class App {
    public static void main(String[] args) throws Exception {
        String fileName = null;
        try {
            fileName = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        }
        ConfigParser configParser = new ConfigParser(fileName);
        System.out.println(configParser.get("application.name"));
    }
}