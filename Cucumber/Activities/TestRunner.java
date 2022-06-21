package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/Features/Activity5.feature",
        glue={"stepDefinitions"},
        tags="@activity5",
        plugin={
                "pretty",
                "html:reports/HTML_report.html",
                "json:reports/JSON_reports.json",
                "junit:reports/XML_reports.xml"
        },
        publish=true
)
public class TestRunner {
}
