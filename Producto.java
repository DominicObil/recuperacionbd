
public class Producto {
    private final String productCode;
    private final String productName;
    private final String productLine;
    private final String productScale;
    private final String productVendor;
    private final String productDescription;
    private final Integer quantityInStock;
    private final Integer buyPrice;
    private final Integer MSRP;

    public Producto( String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, Integer quantityInStock, Integer buyPrice, Integer MSRP) {
        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.MSRP = MSRP;
    }


    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public Integer getMSRP() {
        return MSRP;
    }
}