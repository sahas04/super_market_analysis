package service;

import dao.MarketDAO;
import dao.MarketDAOImplementation;

import java.sql.SQLException;

public class MarketService {
    private final MarketDAO marketDAO;

    public MarketService(MarketDAO marketDAO) {
        this.marketDAO = marketDAO;
    }

    public void viewTotalSales() throws SQLException {
        marketDAO.Totalsales();
    }

    public void viewGrossIncome(){
        marketDAO.TotalGrossIncome();
    }

    public void viewAverageProductRating() throws SQLException {
        marketDAO.AverageProductRating();
    }

    public void viewDailySales() throws SQLException {
        marketDAO.dailySales();
    }

    public void viewWeeklySales() throws SQLException {
        marketDAO.weeklySales();
    }

    public void viewMonthlySales() throws SQLException {
        marketDAO.monthlySales();
    }

    public void viewQuarterlySales() throws SQLException {
        marketDAO.quarterlySales();
    }

    public void viewYearlySales() throws SQLException {
        marketDAO.yearlySales();
    }

    public void viewByBranch() throws SQLException {
        marketDAO.byBranch();
    }

    public void viewByCity() throws SQLException {
        marketDAO.byCity();
    }

    public void viewByProductLine() throws SQLException {
        marketDAO.byProductLine();
    }

    public void viewByCustomertype() throws SQLException {
        marketDAO.byCustomerType();
    }

    public void viewByGender() throws SQLException {
        marketDAO.byGender();
    }

    public void viewByPaymentMethod() throws SQLException {
        marketDAO.byPaymentMethod();
    }

    public void viewProfitByProductLine() throws SQLException {
        marketDAO.profitByProductLine();
    }

    public void viewImpactOfDiscountOnSalesAndProfit() throws SQLException {
        marketDAO.ImpactOfDiscountsOnSalesAndProfit();
    }

    public void viewByHour() throws SQLException {
        marketDAO.ByHour();
    }

    public void viewByDay() throws SQLException {
        marketDAO.ByDayOfTheWeek();
    }
}
