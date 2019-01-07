package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import fr.wizard.fantasticBeasts.FantasticBeasts.FantasticBeastsApplication;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber.StepDefs"
)
public class CucumberRunnerTest {
}