package model;

import java.math.BigDecimal;

public class Sales {
    private int sale_id;
    private String invoice_id;

    private int customer_id;
    private int product_id;
    private int branch_id;
    private int time_id;
    private int payment_id;

    private BigDecimal unit_price;
    private int quantity;
    private BigDecimal tax_5_Percent;
    private BigDecimal total;
    private BigDecimal cogs;
    private BigDecimal gross_margin_percentage;
    private BigDecimal gross_income;

    public Sales() {
    }

    public Sales(int sale_id, String invoice_id, int customer_id, int product_id, int branch_id, int time_id, int payment_id, BigDecimal unit_price, int quantity, BigDecimal tax_5_Percent, BigDecimal total, BigDecimal cogs, BigDecimal gross_margin_percentage, BigDecimal gross_income) {
        this.sale_id = sale_id;
        this.invoice_id = invoice_id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.branch_id = branch_id;
        this.time_id = time_id;
        this.payment_id = payment_id;
        this.unit_price = unit_price;
        this.quantity = quantity;
        this.tax_5_Percent = tax_5_Percent;
        this.total = total;
        this.cogs = cogs;
        this.gross_margin_percentage = gross_margin_percentage;
        this.gross_income = gross_income;
    }

    public int getSale_id() {
        return sale_id;
    }

    public void setSale_id(int sale_id) {
        this.sale_id = sale_id;
    }

    public String getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public int getTime_id() {
        return time_id;
    }

    public void setTime_id(int time_id) {
        this.time_id = time_id;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTax_5_Percent() {
        return tax_5_Percent;
    }

    public void setTax_5_Percent(BigDecimal tax_5_Percent) {
        this.tax_5_Percent = tax_5_Percent;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getCogs() {
        return cogs;
    }

    public void setCogs(BigDecimal cogs) {
        this.cogs = cogs;
    }

    public BigDecimal getGross_margin_percentage() {
        return gross_margin_percentage;
    }

    public void setGross_margin_percentage(BigDecimal gross_margin_percentage) {
        this.gross_margin_percentage = gross_margin_percentage;
    }

    public BigDecimal getGross_income() {
        return gross_income;
    }

    public void setGross_income(BigDecimal gross_income) {
        this.gross_income = gross_income;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "sale_id=" + sale_id +
                ", invoice_id='" + invoice_id + '\'' +
                ", customer_id=" + customer_id +
                ", product_id=" + product_id +
                ", branch_id=" + branch_id +
                ", time_id=" + time_id +
                ", payment_id=" + payment_id +
                ", unit_price=" + unit_price +
                ", quantity=" + quantity +
                ", tax_5_Percent=" + tax_5_Percent +
                ", total=" + total +
                ", cogs=" + cogs +
                ", gross_margin_percentage=" + gross_margin_percentage +
                ", gross_income=" + gross_income +
                '}';
    }
}
