package utils;

import models.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestDataReader {
    public final String TEST_DATA_PATH = JsonReader.RESOURCES_PATH + "testdata/";
    private final String FILE_DATA_PATH = TEST_DATA_PATH + "cityData.json";

    public CityData getCityData() {
        return JsonReader.deserializeJson(FILE_DATA_PATH, CityData.class);
    }
}
