package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class Program2 {

    public static void main (String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\nTeste 1: Insert");
        Department department = new Department(null, "Casa");
        departmentDao.insert(department);
        System.out.println("Department inserted, id: " + department.getId());

        System.out.println("\nTeste 2: Update");
        Department dep = departmentDao.findById(4);
        dep.setName("Literature");
        departmentDao.update(dep);
        System.out.println("UPDATED");

        System.out.println("\nTeste 3: DeleteById");
        int idDeleted = 6;
        departmentDao.deleteById(idDeleted);
        System.out.println("Id deleted: " + idDeleted);

        System.out.println("\nTeste 4: FindById");
        dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("\nTeste 5: findAll");
        List<Department> list = departmentDao.findAll();

        for(Department x : list) {
            System.out.println(x);
        }
    }
}
