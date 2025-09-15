package utils.files;

import com.google.gson.*;
import lombok.experimental.UtilityClass;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@UtilityClass
public class JsonUtils {
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public <T> T deserializeJson(String filePath, Class<T> tClass) {
        try (FileReader reader = new FileReader(filePath)) {
            return GSON.fromJson(reader, tClass);
        } catch (IOException | JsonSyntaxException e) {
            handleFileException(filePath, e);
        }
        return null;
    }

    public void serializeJson(String filePath, Object object) {
        try (FileWriter writer = new FileWriter(filePath)) {
            GSON.toJson(object, writer);
        } catch (IOException | JsonSyntaxException e) {
            handleFileException(filePath, e);
        }
    }

    public String getValue(String filePath, String attributeName) {
        String value = null;
        try (FileReader reader = new FileReader(filePath)) {
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            value = (jsonObject.has(attributeName)) ? jsonObject.get(attributeName).getAsString() : null;
        } catch (IOException e) {
            handleFileException(filePath, e);
        }
        return value;
    }

    private void handleFileException(String filePath, Exception e) throws RuntimeException {
        throw new RuntimeException("Could not serialize/deserialize JSON at '%s'\nCause: %s".formatted(filePath, e));
    }
}
