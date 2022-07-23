package link.cabd;

import link.cabd.entity.Title;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {

    private Library titles = new Library();

    @Test
    void when_elementHasTitleText_thenGetTittleText() {
        WebElementMock element = new WebElementMock();
        element.setElementValue("test");
        assertEquals("test", titles.getTitleText(element));
    }
    @Test
    void when_elementHasnoTitleText_thenReturnEmpty() {
        WebElementMock element = new WebElementMock();
        assertEquals("", titles.getTitleText(element));
    }
    @Test
    void when_elementHasPrice_thenGetFullPrice() {
        WebElementMock element = new WebElementMock();
        element.setElementPrice("20.0");
        assertEquals("20.0", titles.getFullPrice(element).get("price"));
    }
    @Test
    void when_elementHasnoPrice_thenReturnEmpty() {
        WebElementMock element = new WebElementMock();
        assertEquals(null, titles.getFullPrice(element).get("price"));
    }
    @Test
    void when_elementHasSymbol_then_getFullSymbol() {
        WebElementMock element = new WebElementMock();
        element.setElementPrice("R$");
        assertEquals("R$", titles.getFullPrice(element).get("symbol"));
    }
    @Test
    void when_elementHasnoSymbol_then_returnEmpty() {
        WebElementMock element = new WebElementMock();
        assertEquals(null, titles.getFullPrice(element).get("symbol"));
    }
    @Test
    void when_thereAreMoreThanOneTitleWithDiferenteText_thenReturnAllTitles() {
        List<WebElement> elements = new ArrayList<WebElement>();
        elements.add(new WebElementMock("test1"));
        elements.add(new WebElementMock("test2"));

        List<Title> library = titles.getTitles(elements);

        assertEquals(elements.size(), library.size());
    }
    @Test
    void when_thereAreMoreThanOneTitleWithTheSameText_thenReturnOnlyOneText() {
        List<WebElement> elements = new ArrayList<WebElement>();
        elements.add(new WebElementMock("test1"));
        elements.add(new WebElementMock("test1"));

        List<Title> library = titles.getTitles(elements);

        assertEquals(1, library.size());
    }
}