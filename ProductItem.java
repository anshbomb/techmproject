public class ProductItem {
    private int itemNumber;
    private String category;
    private String description;
    private double price;
    private double offerPrice;

    public ProductItem(int itemNumber, String category, String description, double price, double offerPrice) {
        this.itemNumber = itemNumber;
        this.category = category;
        this.description = description;
        this.price = price;
        this.offerPrice = offerPrice;
    }

}
