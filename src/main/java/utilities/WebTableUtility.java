package utilities;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableUtility {

    /**
     * Checks if the given text is present in the list of table header elements.
     *
     * @param driver      WebDriver instance (not used here but kept for signature consistency)
     * @param elements    List of WebElements (e.g., table headings)
     * @param searchText  Text to search for in the list
     * @return true if the text is found, false otherwise
     */
    public static boolean isTextPresentInTable(WebDriver driver, List<WebElement> elements, String searchText) {
        for (WebElement element : elements) {
            if (element.getText().trim().equalsIgnoreCase(searchText.trim())) {
                System.out.println("Text found: " + element.getText());
                return true;
            }
        }
        return false;
    }
}
