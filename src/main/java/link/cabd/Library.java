package link.cabd;

import link.cabd.entity.Title;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private List<Title> listOfTitles = new ArrayList<Title>();

    public List<WebElement> loadPage(ChromeDriver driver) {;
        return driver.findElementByClassName ("s-main-slot")
                .findElements(By.className("s-result-item"));
    }

    public String getTitleText(WebElement item) {
        try {
            WebElement product = item.findElement(By.className("a-text-normal"));
            return product.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getUrl(WebElement item) {
        try {
            WebElement priceDescription = item.findElement(By.className("s-price-instructions-style"));
            WebElement type = priceDescription.findElement(By.className("a-link-normal"));
            return type.getAttribute("href");
        } catch (Exception e) {
            return "";
        }
    }

    public String getType(WebElement item) {
        try {
            WebElement priceDescription = item.findElement(By.className("s-price-instructions-style"));
            WebElement type = priceDescription.findElement(By.className("a-link-normal"));
            return type.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public HashMap<String, String> getFullPrice(WebElement element) {
        try {
            WebElement price = element.findElement(By.className("a-price-whole"));
            WebElement priceSymbol = element.findElement(By.className("a-price-symbol"));

            Map<String, String> prices = new HashMap<>();
            prices.put("price", price.getText());
            prices.put("symbol", priceSymbol.getText());

            return (HashMap<String, String>) prices;
        } catch (Exception e) {
            return new HashMap<>();
        }
    }

    public  List<Title> getTitles(List<WebElement> titles) {
        HashMap<String, Title> filteredTitles = new HashMap<String,Title>();
        titles.forEach(item -> {
            String titleText = getTitleText(item);
            String price = getFullPrice(item).get("price");
            String symbol = getFullPrice(item).get("symbol");
            String url = getUrl(item);
            String type = getType(item);
            Title title = new Title(getTitleText(item), price, symbol, url, type);

            if (checkIsNullOrIsEmpty(titleText)) return;
            if (checkIsNullOrIsEmpty(price)) return;
            if (checkIsNullOrIsEmpty(url)) return;
            if (checkIsNullOrIsEmpty(type)) return;

            filteredTitles.put(titleText, title);
        });
        filteredTitles.forEach((titleText, title) -> {
            listOfTitles.add(title);
        });
        return listOfTitles;
    }

    private boolean checkIsNullOrIsEmpty(String titleText) {
        if(titleText == null || titleText.isEmpty()) {
            return true;
        }
        return false;
    }

    public List<Title> getListOfTitles() {
        return listOfTitles;
    }

}
