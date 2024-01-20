package application;

import model.dao.FactoryDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        Department department = new Department(1, "Books");

        Seller seller = new Seller(21, "Bob", "bob@gmail.com", LocalDate.of(1998, 1, 1), 3000.0, department);

        SellerDao sellerDao = FactoryDao.createSellerDao();

        System.out.println(seller);
    }
}