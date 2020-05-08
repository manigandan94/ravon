package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\manigandang\\Desktop\\Sample\\SubjectiveMani\\FeatureFiles\\Q3.feature"},
		glue = "Q3",
		tags="@scenario1,@scenario2"
		)
public class RunnerQ3 {

}
