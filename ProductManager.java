import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManager {
    private List<ProductItem> productItems;

    public ProductManager() {
        this.productItems = new ArrayList<>();
    }

    public void addProductItem(ProductItem item) {
        productItems.add(item);
    }

    public List<ProductItem> sortByCategory() {
        return productItems.stream()
                .sorted(Comparator.comparing(ProductItem::getCategory))
                .collect(Collectors.toList());
    }

    public List<ProductItem> searchByCategory(String category) {
        return productItems.stream()
                .filter(item -> item.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public double calculateTotalPrice(List<ProductItem> selectedItems) {
        return selectedItems.stream()
                .mapToDouble(item -> item.getPrice() - item.getOfferPrice())
                .sum();
    }
}
