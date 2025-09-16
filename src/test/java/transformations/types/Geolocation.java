package transformations.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Geolocation {
    BUENOS_AIRES("Buenos Aires", -34.6037f, -58.3816f),
    MONTEVIDEO("Montevideo", -34.90f, -56.1667f);

    private final String name;
    private final float latitude;
    private final float longitude;

    public static Geolocation byName(String name) throws IllegalArgumentException {
        Geolocation returnValue = null;
        Geolocation[] values = Geolocation.values();
        int i = 0;
        while (returnValue == null && i < values.length) {
            if (values[i].name.equalsIgnoreCase(name)) {
                returnValue = values[i];
            }
            i++;
        }
        if (returnValue == null) {
            throw new IllegalArgumentException("No enum value with name " + name);
        }
        return returnValue;
    }
}
