package model;

public class Branch {
    private int branch_id;
    private String branch;
    private String city;

    public Branch() {
    }

    public Branch(int branch_id, String branch, String city) {
        this.branch_id = branch_id;
        this.branch = branch;
        this.city = city;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branch_id=" + branch_id +
                ", Branch='" + branch + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
