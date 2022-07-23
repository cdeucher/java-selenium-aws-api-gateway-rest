package link.cabd;

import org.openqa.selenium.*;

import java.util.List;

class WebElementMock implements WebElement {
    private String elementValue;

    public WebElementMock() { }

    public WebElementMock(String elementText) {
        this.elementValue = elementText;
    }

    public void setElementPrice(String price) {
        elementValue = price;
    }

    public void setElementValue(String elementValue) {
        this.elementValue = elementValue;
    }

    @Override
    public void click() { }

    @Override
    public void submit() { }

    @Override
    public void sendKeys(CharSequence... charSequences) { }

    @Override
    public void clear() { }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String s) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        if (elementValue == null)
            throw new UnsupportedOperationException("Not supported yet.");
        return elementValue;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return new WebElementMock(elementValue);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}