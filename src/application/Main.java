package application;

import model.dao.FactoryDao;
import model.dao.SellerDao;
import model.entities.Seller;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        SellerDao sellerDao = FactoryDao.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
    }
}