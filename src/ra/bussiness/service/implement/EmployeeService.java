package ra.bussiness.service.implement;

import ra.bussiness.model.Employee;
import ra.bussiness.service.IEmployeeService;
import ra.bussiness.util.IOFile;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private List<Employee> employees;

    public EmployeeService() {

        employees = IOFile.readFromFile(IOFile.EMPLOYEE_PATH);
    }

    @Override
    public Long getNewId() {
//        Long idMax =0L;
//        for (Employee e:employees
//             ) {
//            if(idMax<e.getEmployeeId())
//                idMax = e.getEmployeeId();
//        }
//        return idMax+1;
        return employees.stream().map(Employee::getEmployeeId)
                .max(Long::compare).orElse(0L)+1;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        return employees.stream().filter(em->em.getEmployeeId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public boolean save(Employee employee) {
        Employee oldEmployee = findById(employee.getEmployeeId());
        if (oldEmployee!=null){
            employees.set(employees.indexOf(oldEmployee),employee);
        }else {
            employees.add(employee);
        }
        IOFile.writeToFile(IOFile.EMPLOYEE_PATH,employees);
        return true;
    }

    @Override
    public void deleteById(Long id) {
        employees.remove(findById(id));
        IOFile.writeToFile(IOFile.EMPLOYEE_PATH,employees);
    }
}
