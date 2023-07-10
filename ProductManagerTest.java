import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductManagerTest {
    @Mock
    private ProductItem mockItem1, mockItem2, mockItem3;

    private ProductManager productManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productManager = new ProductManager();
        productManager.addProductItem(mockItem1);
        productManager.addProductItem(mockItem2);
        productManager.addProductItem(mockItem3);
    }

    @Test
    public void testSortByCategory() {
        List<ProductItem> expected = new ArrayList<>();
        expected.add(mockItem1);
        expected.add(mockItem3);
        expected.add(mockItem2);

        when(mockItem1.getCategory()).thenReturn("Electronics");
        when(mockItem2.getCategory()).thenReturn("Clothing");
        when(mockItem3.getCategory()).thenReturn("Electronics");

        List<ProductItem> sortedItems = productManager.sortByCategory();
        assertEquals(expected, sortedItems);
    }

    @Test
    public void testSearchByCategory() {
        List<ProductItem> expected = new ArrayList<>();
        expected.add(mockItem1);
        expected.add(mockItem3);

        when(mockItem1.getCategory()).thenReturn("Electronics");
        when(mockItem2.getCategory()).thenReturn("Clothing");
        when(mockItem3.getCategory()).thenReturn("Electronics");

        List<ProductItem> searchedItems = productManager.searchByCategory("Electronics");
        assertEquals(expected, searchedItems);
    }

    @Test
    public void testCalculateTotalPrice() {
        List<ProductItem> selectedItems = new ArrayList<>();
        selectedItems.add(mockItem1);
        selectedItems.add(mockItem2);
        selectedItems.add(mockItem3);

        when(mockItem1.getPrice()).thenReturn(100.0);
        when(mockItem1.getOfferPrice()).thenReturn(80.0);
        when(mockItem2.getPrice()).thenReturn(50.0);
        when(mockItem2.getOfferPrice()).thenReturn(40.0);
        when(mockItem3.getPrice()).thenReturn(200.0);
        when(mockItem3.getOfferPrice()).thenReturn(150.0);

        double expectedTotalPrice = 70.0; // (100-80) + (50-40) + (200-150)

        double totalPrice = productManager.calculateTotalPrice(selectedItems);
        assertEquals(expectedTotalPrice, totalPrice);
    }
}
