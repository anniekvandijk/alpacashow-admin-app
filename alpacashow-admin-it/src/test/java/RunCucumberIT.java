import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Anniek van Dijk on 16-6-2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "html:target/cucumber/report.html", "json:target/cucumber-report.json" }
        ,features = { "src/test/resources/features" }
        //,tags = { "@run"}
)
public class RunCucumberIT {
    //
}
