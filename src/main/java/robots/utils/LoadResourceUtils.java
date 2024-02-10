package robots.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exception.CreatePdfException;

/** Util class used to load resources files */
public class LoadResourceUtils {

    /** @param name the filename of the resource to load
     * @return a String with the file content */
    public static String loadResourceAsString(String name) {
        String result = null;
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(name);
        if (inputStream != null) {
            try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader reader = new BufferedReader(inputStreamReader)) {
                result = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            } catch (IOException e) {
                throw new CreatePdfException("Invalid resource name: " + name, e);
            }
        }
        return result;
    }

    /** @param name the filename of the resource to load
     * @return a String List with the file content */
    public static List<String> loadResourceAsListOfString(String name) {
        List<String> result = new ArrayList<>();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(name);
        if (inputStream != null) {
            try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader reader = new BufferedReader(inputStreamReader)) {
                result = reader.lines().collect(Collectors.toList());
            } catch (IOException e) {
                throw new CreatePdfException("Invalid resource name: " + name, e);
            }
        }
        return result;
    }
}
