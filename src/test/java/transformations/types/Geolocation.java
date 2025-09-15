package transformations.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Geolocation {
    LONDON("London", 51.507351d, -0.127758d),
    NEW_YORK("New York", 40.724032d, -73.943975d);

    private final String name;
    private final double latitude;
    private final double longitude;

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
