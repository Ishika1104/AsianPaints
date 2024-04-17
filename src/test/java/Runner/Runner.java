package Runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "src\\test\\resource\\Features\\HomeDecor.feature",
//glue = "Step_Definition",
////tags="@tag1 or @tag2 or @tag3",
////monochrome=true,
//plugin = {"pretty","html:target/HTMLReports/AsiaPaintsReport5.html",
//		"json:target/JSONReports/AsianPaintsReports5.json",
//         "junit:target/JUNITReport/AsianPaintsReport5.xml",
//         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

@CucumberOptions(features = "src\\test\\resource\\Features\\HomeDecor.feature",
glue = "Step_Definition"
//,tags="@tag2"
)

public class Runner extends AbstractTestNGCucumberTests{


}
