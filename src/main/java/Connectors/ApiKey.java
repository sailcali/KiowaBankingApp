package Connectors;

import java.util.Map;

public class ApiKey {

    public static String getKeys () {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            if (envName.equals("APIKEY")) {
                return env.get(envName);
            }

        }
        return "";
    }

}
