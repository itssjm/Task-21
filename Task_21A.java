import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_21A {
    public static void main(String[] args) throws InterruptedException {
        // Set the path of ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/Moses/Documents/chromedriver-win64/chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();

        // Navigate to the URL
        driver.get("https://the-internet.herokuapp.com/iframe");
        
        Thread.sleep(3000);

        // Switch to the iframe using its ID or name attribute
        driver.switchTo().frame("mce_0_ifr");

        // Find the p tag inside the iframe and write text
        WebElement paragraphInsideIframe = driver.findElement(By.tagName("p"));
        paragraphInsideIframe.clear(); // Clear existing text (if any)
        paragraphInsideIframe.sendKeys("Hello People");

        // Switch back to the main content
        driver.switchTo().defaultContent();
        
        Thread.sleep(3000);

        // Close the browser
        driver.quit();
    }
}
