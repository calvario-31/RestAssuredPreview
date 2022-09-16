package base;

import data.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.File;

public abstract class BaseTest {
    protected DataProviders dataProviders = new DataProviders();
    protected SoftAssert softAssert;
    private final String schemaFolder = "src/test/resources/schemas";

    @BeforeMethod
    public void setup() {
        softAssert = new SoftAssert();
    }

    protected File getSchema(String json) {
        var path = String.format("%s/%s", schemaFolder, json);
        return new File(path);
    }
}
