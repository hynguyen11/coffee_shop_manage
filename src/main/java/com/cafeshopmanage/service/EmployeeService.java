package com.cafeshopmanage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cafeshopmanage.entity.Employee;
import com.cafeshopmanage.model.EmployeeModel;
import com.cafeshopmanage.repository.EmployeeRepository;
import com.cafeshopmanage.utils.ImageUtils;
import com.cafeshopmanage.utils.MapperUtils;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void createUpdateEmployee(EmployeeModel employeeForm) {
        Employee employee = null;
        if (employeeForm.getId() != null) {
            Optional<Employee> employeeEntity = employeeRepository.findById(employeeForm.getId());
            if (employeeEntity.isPresent()) {
                employee = employeeEntity.get();
            }
        }
        if (employee == null) {
            employee = new Employee();
        }

        if (employeeForm.getImageUpload() != null && StringUtils.hasText(employeeForm.getImageUpload().getOriginalFilename())) {
            employee.setPictureLink(ImageUtils.upload(employeeForm.getImageUpload()));
        }
        MapperUtils.map(employeeForm, employee);
        employeeRepository.save(employee);
        employeeForm.setId(employee.getId());
        employeeForm.setPictureLink(employee.getPictureLink());
    }

    public List<EmployeeModel> getEmployeeList() {
        List<EmployeeModel> listEmployeeModel = new ArrayList<>();
        List<Employee> listEmployee = employeeRepository.findAll();
        for (Employee employee : listEmployee) {
            EmployeeModel model = new EmployeeModel();
            MapperUtils.map(employee, model);
            listEmployeeModel.add(model);
        }
        return listEmployeeModel;
    }

    public EmployeeModel getEmployee(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            EmployeeModel model = new EmployeeModel();
            MapperUtils.map(employee.get(), model);
            return model;
        }
        return new EmployeeModel();
    }

    public void deleteEmployee(EmployeeModel employeeForm) {
        employeeRepository.deleteById(employeeForm.getId());
    }

    public EmployeeModel getEmployeeById(EmployeeModel employeeForm) {
        Employee employee = new Employee();
        if (employeeForm.getId() != null) {
            Optional<Employee> employeeEntity = employeeRepository.findById(employeeForm.getId());
            if (employeeEntity.isPresent()) {
                employee = employeeEntity.get();
            }
        }
        MapperUtils.map(employee, employeeForm);
        return employeeForm;
    }

	public long countEmployee() {
		return employeeRepository.count();
	}
	
//	public List<EmployeeModel> getemployeeByCategory(String id) {
//		List<EmployeeModel> listEmployeeModel = new ArrayList<>();
//        List<Employee> listEmployee = employeeRepository.findByCategory(id);
//        for (Employee employee : listEmployee) {
//            EmployeeModel model = new EmployeeModel();
//            MapperUtils.map(employee, model);
//            listEmployeeModel.add(model);
//        }
//        return listEmployeeModel;
//	}
	
//	public List<employeeModel> getemployeeByBrand(String id) {
//		List<employeeModel> listemployeeModel = new ArrayList<>();
//        List<employee> listEmployee = employeeRepository.findByBrand(id);
//        for (employee employee : listEmployee) {
//            employeeModel model = new employeeModel();
//            MapperUtils.map(employee, model);
//            listemployeeModel.add(model);
//        }
//        return listemployeeModel;
//	}
}
