package transformations;

import io.cucumber.java.ParameterType;
import transformations.types.Geolocation;

public class ParameterTypes {

    @ParameterType("'([^']+)'")
    public Geolocation geolocation(String name) {
        return Geolocation.byName(name);
    }
}
