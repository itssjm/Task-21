import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task_21C {
    public static void main(String[] args)  throws InterruptedException {
        // Set the path of ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",  "C:/Users/Moses/Documents/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Launch the website
        driver.get("http://the-internet.herokuapp.com/nested_frames");

        // Switch to the top frame
        driver.switchTo().frame("frame-top");

        // Verify that there are three frames on the page
        WebElement framesCount = driver.findElement(By.cssSelector("#content > div > iframe:nth-child(3)"));
        Select framesCountSelect = new Select(framesCount);
        if (framesCountSelect.getOptions().size() == 3) {
            System.out.println("There are three frames on the page.");
        } else {
            System.out.println("There are not three frames on the page.");
        }

        // Switch to the left frame
        driver.switchTo().frame("frame-left");

        // Verify that the left frame has a text "LEFT"
        WebElement leftText = driver.findElement(By.cssSelector("#content > div"));
        if (leftText.getText().equals("LEFT")) {
            System.out.println("The left frame has a text 'LEFT'.");
        } else {
            System.out.println("The left frame does not have a text 'LEFT'.");
        }

        // Switch back to the top frame
        driver.switchTo().parentFrame();

        // Switch to the middle frame
        driver.switchTo().frame("frame-middle");

        // Verify that the middle frame has a text "MIDDLE"
        WebElement middleText = driver.findElement(By.cssSelector("#content > div"));
        if (middleText.getText().equals("MIDDLE")) {
            System.out.println("The middle frame has a text 'MIDDLE'.");
        } else {
            System.out.println("The middle frame does not have a text 'MIDDLE'.");
        }

        // Switch back to the top frame
        driver.switchTo().parentFrame();

        // Close the browser instance
        driver.quit();
    }
}