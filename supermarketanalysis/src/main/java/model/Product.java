package model;

import java.math.BigDecimal;

public class Product {
    private int product_id;
    private String product_line;
    private BigDecimal unit_price;
    private BigDecimal rating;

    public Product() {
    }

    public Product(int product_id, String product_line, BigDecimal unit_price, BigDecimal rating) {
        this.product_id = product_id;
        this.product_line = product_line;
        this.unit_price = unit_price;
        this.rating = rating;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_line() {
        return product_line;
    }

    public void setProduct_line(String product_line) {
        this.product_line = product_line;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_line='" + product_line + '\'' +
                ", unit_price=" + unit_price +
                ", rating=" + rating +
                '}';
    }
}
