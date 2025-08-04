package main;

import dao.MarketDAOImplementation;
import service.MarketService;
import util.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MarketMain {
    public static void main(String[] args) throws SQLException {
        try(Connection connection= DbConnection.getConnection();
            Scanner sc=new Scanner(System.in)){
            MarketService marketService=new MarketService(new MarketDAOImplementation(connection));
            String choice;
            do{
                System.out.println("=====menu=====");
                System.out.println("1.view KPI'S");
                System.out.println("2.analyze sales trends");
                System.out.println("3.compare sales");
                System.out.println("4.analyze customer purchases");
                System.out.println("5.view probability by product line");
                System.out.println("6.analyze impact of discounts on sales and profit");
                System.out.println("7.view peak sales");
                System.out.println("8.exit");
                System.out.println("enter your choice:");
                choice= sc.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("===sub KPI analysis===");
                        System.out.println("1.view total sales");
                        System.out.println("2.total gross income");
                        System.out.println("3.view average product rating");
                        System.out.println("enter your choice:");
                        String choice1 = sc.nextLine();

                        switch (choice1) {
                            case "1":
                                marketService.viewTotalSales();
                                break;
                            case "2":
                                marketService.viewGrossIncome();
                                break;
                            case "3":
                                marketService.viewAverageProductRating();
                                break;
                            default:
                                System.out.println("Invalid option,select option 1,2,3");
                                break;
                        }
                        break;
                    case "2":
                        System.out.println("===sub anaylze sales trends==");
                        System.out.println("1.daily sales");
                        System.out.println("2.weekly sales");
                        System.out.println("3.monthly sales");
                        System.out.println("4.quarterly sales");
                        System.out.println("5.yearly sales");
                        String choice2 = sc.nextLine();
                        switch (choice2) {
                            case "1":
                                marketService.viewDailySales();
                                break;
                            case "2":
                                marketService.viewWeeklySales();
                                break;
                            case "3":
                                marketService.viewMonthlySales();
                                break;
                            case "4":
                                marketService.viewQuarterlySales();
                                break;
                            case "5":
                                marketService.viewYearlySales();
                                break;
                            default:
                                System.out.println("invalid choice");
                                break;
                        }
                        break;
                    case "3":
                        System.out.println("==sub compare sales==");
                        System.out.println("1.compare by branch");
                        System.out.println("2.compare by city");
                        System.out.println("3.compare by product line");
                        String choice3 = sc.nextLine();
                        switch (choice3) {
                            case "1":
                                marketService.viewByBranch();
                                break;
                            case "2":
                                marketService.viewByCity();
                                break;
                            case "3":
                                marketService.viewByProductLine();
                                break;
                            default:
                                System.out.println("invalid choice");
                                break;
                        }
                        break;
                    case "4":
                        System.out.println("==sub customer purchases");
                        System.out.println("1.analyze by customer type");
                        System.out.println("2.analyze by gender");
                        System.out.println(("3.analyze by payment method"));
                        String choice4 = sc.nextLine();
                        switch (choice4) {
                            case "1":
                                marketService.viewByCustomertype();
                                break;
                            case "2":
                                marketService.viewByGender();
                                break;
                            case "3":
                                marketService.viewByPaymentMethod();
                                break;
                            default:
                                System.out.println("invalid choice");
                                break;
                        }
                        break;
                    case "5":
                        marketService.viewProfitByProductLine();
                        break;
                    case "6":
                        marketService.viewImpactOfDiscountOnSalesAndProfit();
                        break;
                    case "7":
                        System.out.println("==sub peak sales==");
                        System.out.println("1.peak sales by hour");
                        System.out.println("2.peak sales by day of the week");
                        String choice7 = sc.nextLine();
                        switch (choice7) {
                            case "1":
                                marketService.viewByHour();
                                break;
                            case "2":
                                marketService.viewByDay();
                                break;
                            default:
                                System.out.println("invalid choice");
                                break;
                        }
                        break;
                    case "8":
                        System.out.println("exiting program.Thank you");
                        break;
                    default:
                        System.out.println("invalid operation");
                        break;
                }
            }while (!choice.equals("8"));
        }catch (Exception e){
            System.out.println("error:"+e.getMessage());
        }
    }
}
