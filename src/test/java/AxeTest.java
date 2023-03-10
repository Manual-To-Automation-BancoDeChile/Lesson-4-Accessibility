import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;


public class AxeTest {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver();

        driver.get("https://portales.bancochile.cl/personas");

        AxeBuilder builder = new AxeBuilder();
        Results results = builder.analyze(driver);
        List<Rule> violations = results.getViolations();

        System.out.println("Number of Violations: " + violations.size());

        for (Rule currentViolation : violations) {
            System.out.println(currentViolation.getDescription());
        }

        driver.quit();
    }
}