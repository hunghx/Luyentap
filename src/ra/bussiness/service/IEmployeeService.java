package ra.bussiness.service;

import ra.bussiness.model.Employee;

public interface IEmployeeService extends IGeneric<Employee,Long> {
    Long getNewId();
}
