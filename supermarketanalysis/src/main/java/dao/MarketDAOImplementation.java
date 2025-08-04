package dao;

import util.DbConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.time.Year;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarketDAOImplementation implements MarketDAO{
    private final Connection connection;
    private static final Logger logger=LoggerFactory.getLogger(MarketDAOImplementation.class);



    public MarketDAOImplementation(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Totalsales() {
        String sql="select p.product_line as product, sum(total) as total_sales from sales s join product p using(product_id) group by product order by product";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet= preparedStatement.executeQuery()
        ){
            logger.info("executing total sales");
            System.out.printf("%-25s %-15s%n","product_line","total_sales");
            double sum=0;
            while(resultSet.next()){
               String product=resultSet.getString("product");
               Double totalsales=resultSet.getDouble("total_sales");


                System.out.printf("%-25s %-15s%n",product,totalsales);
                sum+=totalsales;

            }
            System.out.println("total sales:"+sum);
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating total sales",e.getMessage(),e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void TotalGrossIncome() {
        String sql="select p.product_line as product,sum(s.gross_income) as total_gross_income from sales s join product p using(product_id) group by product order by product";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery()) {
            logger.info("executing gross income");
            System.out.printf("%-25s %-15s%n","product","total_gross_income");
            double sum=0;
            while (resultSet.next()){
                String product=resultSet.getString("product");
                Double gross=resultSet.getDouble("total_gross_income");
                System.out.printf("%-25s %-15s%n",product,gross);
                sum+=gross;
            }
            System.out.println("total gross income:"+sum);
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating gross income",e.getMessage(),e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AverageProductRating() {
        String sql="select p.product_line as product,avg(rating) as avg_product_rating from sales s join product p using(product_id) group by product";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("executing average product rating");
            System.out.printf("%-25s %-15s%n","product","avg_product_rating");
            while (resultSet.next()){
                String product=resultSet.getString("product");
                Double rating=resultSet.getDouble("avg_product_rating");
                System.out.printf("%-25s %-15s%n",product,rating);
            }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating average product rating",e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dailySales() {
        String sql="select td.date as date,sum(s.total) as daily_sales from sales s join timeDimension td using(time_id)  group by td.date order by td.date";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("calculating daily sales");
            System.out.printf("%-15s %-15s%n","date","daily_sales");
            while (resultSet.next()){
                Date date=resultSet.getDate("date");
                BigDecimal sales=resultSet.getBigDecimal("daily_sales");
                System.out.printf("%-15s %-15s%n",date,sales);
            }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating daily sales",e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void weeklySales(){
        String sql="select year(td.date)as year,week(td.date) as week,sum(total) as total_sales from sales s join timeDimension td using(time_id) group by year,week order by year,week";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("calculating weekly sales");
            System.out.printf("%-15s %-15s %-15s%n","year","week","total_sales");
            while (resultSet.next()){
                int year=resultSet.getInt("year");
                int week=resultSet.getInt("week");
                BigDecimal sales=resultSet.getBigDecimal("total_sales");
                System.out.printf("%-15s %-15s %-15s%n",year,week,sales);
            }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating weekly sales",e.getMessage(),e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void monthlySales(){
        String sql="select year(td.date) as year,month(td.date) as month,sum(s.total) as total from sales s join timeDimension td using(time_id) group by year,month order by year,month";
        try(PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("executing monthly sales");
            System.out.printf("%-15s %-15s %-15s%n","year","month","total");
            while (resultSet.next()){
                int year=resultSet.getInt("year");
                int date=resultSet.getInt("month");
                BigDecimal total=resultSet.getBigDecimal("total");
                System.out.printf("%-15s %-15s %-15s%n",year,date,total);
            }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating monthly sales",e.getMessage(),e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void quarterlySales(){
        String sql="select year(td.date) as year,quarter(td.date) as quarter,sum(s.total) as total from sales s join timeDimension td using(time_id) group by year,quarter order by year,quarter";
        try(PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("executing quarterly sales");
            System.out.printf("%-15s %-15s %-15s%n","year","quarter","total");
            while (resultSet.next()){
                int year=resultSet.getInt("year");
                int quarter=resultSet.getInt("quarter");
                BigDecimal total=resultSet.getBigDecimal("total");
                System.out.printf("%-15s %-15s %-15s%n",year,quarter,total);
            }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating quarterly sales",e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }


    @Override
    public void yearlySales() {
        String sql="select year(date) as year,sum(s.total) as total from sales s join timeDimension td using(time_id) group by year order by year";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("executing yearly sales");
            System.out.printf("%-15s %-15s%n","year","total");
            while (resultSet.next()){
                int year=resultSet.getInt("year");
                BigDecimal total=resultSet.getBigDecimal("total");
                System.out.printf("%-15s %-15s%n",year,total);
        }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating yearly sales",e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void byBranch(){
        String sql="select b.branch as branch,sum(s.total) as total from branch b join sales s using(branch_id) group by branch order by branch";
        try(PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("executing sales by branch");
            System.out.printf("%-15s %-15s%n","branch","total_sales");
            while(resultSet.next()){
                String branch=resultSet.getString("branch");
                BigDecimal total=resultSet.getBigDecimal("total");
                System.out.printf("%-15s %-15s%n",branch,total);
            }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating sales by branch",e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void byCity(){
        String sql="select b.city as city,sum(s.total) as total from branch b join sales s using(branch_id) group by city order by city";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet= preparedStatement.executeQuery()){
            logger.info("executing sales by city");
            System.out.printf("%-15s %-15s%n","city","total");
            while (resultSet.next()){
                String city=resultSet.getString("city");
                BigDecimal total=resultSet.getBigDecimal("total");
                System.out.printf("%-15s %-15s%n",city,total);
            }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating sales by city",e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void byProductLine(){
        String sql="select p.product_line as product,sum(s.total) as total from product p join sales s using(product_id) group by product order by product";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("executing sales by productline");
            System.out.printf("%-25s %-15s%n","product","total");
            while (resultSet.next()){
                String product=resultSet.getString("product");
                BigDecimal total=resultSet.getBigDecimal("total");
                System.out.printf("%-25s %-15s%n",product,total);
            }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating sales by productline",e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void byCustomerType(){
        String sql="select c.customer_type as customer,sum(s.total) as total from customer c join sales s using(customer_id) group by customer order by customer";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("executing sales by customer type");
            System.out.printf("%-15s %-15s%n","customer","total");
            while (resultSet.next()){
                String customer=resultSet.getString("customer");
                BigDecimal total=resultSet.getBigDecimal("total");
                System.out.printf("%-15s %-15s%n",customer,total);
            }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating sales by customer type",e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void byGender(){
        String sql="select c.gender as gender,sum(s.total) as total from customer c join sales s using(customer_id) group by gender order by gender";
        try(PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("executing sales by gender");
            System.out.printf("%-15s %-15s%n","gender","total");
            while (resultSet.next()){
                String gender=resultSet.getString("gender");
                BigDecimal total=resultSet.getBigDecimal("total");
                System.out.printf("%-15s %-15s%n",gender,total);
            }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating sales by gender",e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void byPaymentMethod(){
        String sql="select p.payment_method as payment,sum(s.total) as total,count(*) as count from paymentMethod p join sales s using(Payment_id) group by payment order by payment";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("executing count of payment methods");
            System.out.printf("%-15s %-15s %-15s%n","payment","count","total");
            while (resultSet.next()){
                String payment=resultSet.getString("payment");
                int count=resultSet.getInt("count");
                BigDecimal total=resultSet.getBigDecimal("total");
                System.out.printf("%-15s %-15s %-15s%n",payment,count,total);
            }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating count of payment method",e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void profitByProductLine() {
        String sql="select p.product_line,sum(s.gross_income) as gross,sum(s.total) as total,round(sum(s.gross_income)/sum(s.total)*100,2) as profit from sales s join product p using(product_id) group by p.product_line order by gross desc";
        try(PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("executing sales profit by product line");
            System.out.printf("%-25s %-15s %-15s %-10s%n", "Product Line", "Gross Income", "Total Sales", "Profit (%)");
            while (resultSet.next()){
                String product=resultSet.getString("product_line");
                BigDecimal gross=resultSet.getBigDecimal("gross");
                BigDecimal sales=resultSet.getBigDecimal("total");
                BigDecimal profit=resultSet.getBigDecimal("profit");
                System.out.printf("%-25s %-15s %-15s %-10s%n", product, gross, sales, profit);
            }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating profit by productline",e.getMessage(),e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void ImpactOfDiscountsOnSalesAndProfit(){
        String sql="select invoice_id,cogs,tax_5_percent,total,gross_income,round(total-(cogs+tax_5_percent),2) as discount,round((gross_income/(cogs+tax_5_percent))*100,2) as profit_margin_percent from sales order by discount desc limit 20";
        try(PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("executing impact of discounts on sales and profit");
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s%n","invoice_id","cogs","tax_5_percent","total","gross_income","discount","profit_margin_percent(%)");
            try(PreparedStatement preparedStatement1= connection.prepareStatement(sql);
            ResultSet resultSet1=preparedStatement1.executeQuery()){
                while (resultSet.next()){
                    String invoice=resultSet.getString("invoice_id");
                    BigDecimal cogs=resultSet.getBigDecimal("cogs");
                    BigDecimal tax=resultSet.getBigDecimal("tax_5_percent");
                    BigDecimal total=resultSet.getBigDecimal("total");
                    BigDecimal gross=resultSet.getBigDecimal("gross_income");
                    BigDecimal discount=resultSet.getBigDecimal("discount");
                    BigDecimal profit=resultSet.getBigDecimal("profit_margin_percent");
                    System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s%n",invoice,cogs,tax,total,gross,discount,profit);
                }
                logger.info("execution completed");
            }
        } catch (SQLException e) {
            logger.error("error while calculating impact of discount on profits and sales",e.getMessage(),e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void ByHour() {
        String sql="select hour(td.time) as hour,sum(s.total) as total from timeDimension td join sales s using(time_id) group by hour order by total desc";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("executing sales by hour");
            System.out.printf("%-15s %-15s%n","Hour","total_sales");
            while(resultSet.next()){
                int hour=resultSet.getInt("hour");
                BigDecimal total=resultSet.getBigDecimal("total");
                System.out.printf("%-15s %-15s%n",hour,total);
            }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating sales by hour",e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void ByDayOfTheWeek() {
        String sql="select dayname(td.date) as day,sum(s.total) as total from timeDimension td join sales s using(time_id) group by day order by total desc";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery()){
            logger.info("executing sales by day");
            System.out.printf("%-15s %-15s%n","day","total");
            while(resultSet.next()){
                String day=resultSet.getString("day");
                BigDecimal total=resultSet.getBigDecimal("total");
                System.out.printf("%-15s %-15s%n",day,total);
            }
            logger.info("execution completed");
        } catch (SQLException e) {
            logger.error("error while calculating sales by day",e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }
}
