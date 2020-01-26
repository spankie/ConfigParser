package app;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * ConfigParser
 */
public class ConfigParser {
  private Path p;
  private HashMap<String, String> config;

  public ConfigParser(String fileName) {
    if (fileName == null) {
      fileName = "config.txt";
    }
    p = Paths.get(fileName);
    config = new HashMap<>();
    ReadConfig();
  }

  private void AddConfig(String prefix, String line) {
    String[] keyValue = line.split("=");
    // tenary operator;
    String key = prefix.isEmpty() ? keyValue[0] : prefix.concat(".").concat(keyValue[0]);
    String value = keyValue[1];
    config.put(key, value);
  }

  private void ReadConfig() {
    try {
      List<String> lines = Files.readAllLines(this.p, StandardCharsets.UTF_8);
      String prefix = "";
      for (String line : lines) {
        if (!line.isEmpty()) {
          if (line.startsWith("[") && line.endsWith("]")) {
            prefix = line.substring(1, line.length() - 1);
            continue;
          }
          AddConfig(prefix, line);
        } else {
          prefix = "";
        }
      }
    } catch (IOException e) {
      System.err.println("IOExcetion : " + e.getMessage());
    }
  }

  public String get(String key) {
    return config.get(key);
  }

}