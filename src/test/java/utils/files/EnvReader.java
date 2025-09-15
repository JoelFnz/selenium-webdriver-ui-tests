package utils.files;

import lombok.experimental.UtilityClass;
import models.EnvData;
import utils.PathsHelper;

@UtilityClass
public class EnvReader {

    public EnvData getEnvData() {
        String env = JsonUtils.getValue(PathsHelper.ENV_FILE, "env");
        return JsonUtils.deserializeJson(PathsHelper.ENVIRONMENT_PATH + "/%s.json".formatted(env), EnvData.class);
    }
}
