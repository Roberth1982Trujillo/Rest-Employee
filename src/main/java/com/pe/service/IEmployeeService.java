package com.pe.service;

import com.pe.entity.Cuenta;
import com.pe.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee>   listAllEmployee();
    public String           createEmployee(Employee employee);
    public String           updateEmployee(int codigo, Employee employee);
    public String           deleteEmployee(int codigo);

    public String           createCuenta(Cuenta cuenta, int cod_Empl);
}