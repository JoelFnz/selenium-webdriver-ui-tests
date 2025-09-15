package utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PathsHelper {
    public final String RESOURCES_PATH = "src/test/resources";
    public final String ENVIRONMENT_PATH = RESOURCES_PATH + "/environment";
    public final String TEST_DATA_PATH = RESOURCES_PATH + "/testData";
    public final String ENV_FILE = RESOURCES_PATH + "/env.json";
}
