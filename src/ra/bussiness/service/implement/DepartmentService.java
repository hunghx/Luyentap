package ra.bussiness.service.implement;

import ra.bussiness.model.Department;
import ra.bussiness.service.IDepartmentService;
import ra.bussiness.util.IOFile;

import java.util.List;

public class DepartmentService implements IDepartmentService {
    private List<Department> departments;

    public DepartmentService() {
       this.departments = IOFile.readFromFile(IOFile.DEPARTMENT_PATH);
    }

    @Override
    public List<Department> findAll() {
        return departments;
    }

    @Override
    public Department findById(String id) {
//        for (Department d:departments
//             ) {
//            if (d.getDepartmentId().equals(id)){
//                return d;
//            }
//        }
//        return null;
        return departments.stream()
                .filter(d->d.getDepartmentId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public boolean save(Department department) {
        Department departmentOld = findById(department.getDepartmentId());
        if (departmentOld !=null){
            // chức nănng cập nhật
            departments.set(departments.indexOf(departmentOld),department);
        }else {
            // chức năng thêm mới
            departments.add(department);
        }
        // lưu vào file
        IOFile.writeToFile(IOFile.DEPARTMENT_PATH,departments);
        return true;
    }

    @Override
    public void deleteById(String id) {
        departments.remove(findById(id));
        // luưu vào file
        IOFile.writeToFile(IOFile.DEPARTMENT_PATH,departments);
    }
}
