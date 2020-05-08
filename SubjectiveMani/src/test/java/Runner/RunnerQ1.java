package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\manigandang\\Desktop\\Sample\\SubjectiveMani\\FeatureFiles\\Q1.feature"},
		glue = "Q1"
		)
public class RunnerQ1 {

}
