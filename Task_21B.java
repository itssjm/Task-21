import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Task_21B {
    public static void main(String[] args)  throws InterruptedException {
        // Set the path of ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",  "C:/Users/Moses/Documents/chromedriver-win64/chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();

        // Navigate to the URL
        driver.get("https://the-internet.herokuapp.com/windows");

        // Click the "Click Here" button to open a new window
        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();
        
        Thread.sleep(3000);

        // Get the window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the newly opened window
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        
        Thread.sleep(3000);

        // Verify that the text "New Window" is present on the page
        WebElement newWindowText = driver.findElement(By.tagName("h3"));
        String newText = newWindowText.getText();
        if (newText.equals("New Window")) {
            System.out.println("Text 'New Window' is present on the page.");
        } else {
            System.out.println("Text 'New Window' is not present on the page.");
        }
        

        // Close the new window
        driver.close();

        // Switch back to the original window
        driver.switchTo().window((String) windowHandles.toArray()[0]);

        // Verify that the original window is active
        String originalWindowText = driver.findElement(By.tagName("h3")).getText();
        if (originalWindowText.equals("Opening a new window")) {
            System.out.println("Original window is active.");
        } else {
            System.out.println("Original window is not active.");
        }

        Thread.sleep(3000); 
        
        // Close the browser instance
        driver.quit();
    }
}
