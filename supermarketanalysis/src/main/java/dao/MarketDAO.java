package dao;

import java.sql.SQLException;

public interface MarketDAO {
    void Totalsales();
    void TotalGrossIncome();
    void AverageProductRating() ;
    void dailySales() throws SQLException;
    void weeklySales() throws SQLException;
    void monthlySales() throws SQLException;
    void quarterlySales() throws SQLException;
    void yearlySales() throws SQLException;
    void byBranch() throws SQLException;
    void byCity() throws SQLException;
    void byProductLine() throws SQLException;
    void byCustomerType() throws SQLException;
    void byGender() throws SQLException;
    void byPaymentMethod() throws SQLException;
    void profitByProductLine() throws SQLException;
    void ImpactOfDiscountsOnSalesAndProfit() throws SQLException;
    void ByHour() throws SQLException;
    void ByDayOfTheWeek() throws SQLException;
}
