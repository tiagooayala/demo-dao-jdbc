package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("Teste numero 1: seller findById");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\nTeste numero 2: seller findByDepartment");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj: list){
            System.out.println(obj);
        }

        System.out.println("\nTeste numero 3: seller findAll");
        list = sellerDao.findAll();
        for (Seller obj: list){
            System.out.println(obj);
        }

        System.out.println("\nTeste numero 4: seller insert");
        Seller newSeller = new Seller(null, "Boston", "bost@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("New seller inserted: New id = " + newSeller.getId());

        System.out.println("\nTeste numero 5: seller update");
        seller = sellerDao.findById(1);
        seller.setName("Cris Bob");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\nTeste numero 6: seller delete");
        Integer id = 2;
        sellerDao.deleteById(id);
        System.out.println("Id " + id + " deleted!");
    }
}
