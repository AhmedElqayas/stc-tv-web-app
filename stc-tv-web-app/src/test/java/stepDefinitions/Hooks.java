package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.FileReaderManager;

public class Hooks {
    TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void beforeScenario() {
        context.getWebDriverManager().getDriver().get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
    }

//    @After
//    public void afterScenario() {
//        context.getWebDriverManager().closeDriver();
//    }
}
