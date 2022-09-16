package base;

import data.DataProviders;

import java.io.File;

public abstract class BaseTest {
    protected DataProviders dataProviders = new DataProviders();
    private final String schemaFolder = "src/test/resources/schemas";

    protected File getSchema(String json) {
        var path = String.format("%s/%s", schemaFolder, json);
        return new File(path);
    }
}
