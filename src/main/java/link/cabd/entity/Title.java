package link.cabd.entity;

public class Title {

    private String text;
    private String price;
    private String symbol;
    private String url;
    private String type;

    public Title(String title, String price, String symbol, String url, String type) {
        this.text = title;
        this.price = price;
        this.symbol = symbol;
        this.url = url;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public String getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getUrl() {
        return url;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
