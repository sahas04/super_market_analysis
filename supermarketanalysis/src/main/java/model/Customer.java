package model;

public class Customer {
    private int customer_id;
    private String customer_type;
    private String gender;

    public Customer() {
    }

    public Customer(int customer_id, String customer_type, String gender) {
        this.customer_id = customer_id;
        this.customer_type = customer_type;
        this.gender = gender;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_type='" + customer_type + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
