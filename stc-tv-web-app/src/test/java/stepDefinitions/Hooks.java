package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void beforeScenario() {
    }

//    @After
//    public void afterScenario() {
//        context.getWebDriverManager().closeDriver();
//    }
}
