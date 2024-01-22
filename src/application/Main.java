package application;

import model.dao.DepartmentDao;
import model.dao.FactoryDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = FactoryDao.createDepartmentDao();

        System.out.println("=== TEST 1: department findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n=== TEST 2: department findAll ===");
        List<Department> departmentList = departmentDao.findAll();
        for (Department obj : departmentList) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: department insert ===");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println("\n=== TEST 4: department update ===");
        department = departmentDao.findById(1);
        department.setName("Computers");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 5: department delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        SellerDao sellerDao = FactoryDao.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        department = new Department(2, null);
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

        System.out.println("\n=== TEST 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Bob Brown");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 6: seller delete ===");
        System.out.print("Enter id for delete test: ");
        id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}