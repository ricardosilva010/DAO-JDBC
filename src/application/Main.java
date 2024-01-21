package application;

import model.dao.FactoryDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        SellerDao sellerDao = FactoryDao.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellerList = sellerDao.findByDepartment(department);
        for (Seller obj : sellerList)
        {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll ===");
        sellerList = sellerDao.findAll();
        for (Seller obj : sellerList)
        {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", LocalDate.of(2000, 1, 1), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());
    }
}