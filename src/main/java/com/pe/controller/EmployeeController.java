package com.pe.controller;

import com.pe.entity.Cuenta;
import com.pe.feignclient.ICuentaFeignClient;
import com.pe.model.Employee;
import com.pe.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService servEmployee;

    @GetMapping("/listEmployees")
    public List<Employee> listarEmpleados(){ return servEmployee.listAllEmployee(); }

    @PostMapping("/createEmployee")
    public String crearEmpleado(@RequestBody Employee employee){ return servEmployee.createEmployee(employee); }

    @PutMapping("/updateEmployee/{codigo}")
    public String actualizarEmpleado(@PathVariable int codigo, @RequestBody Employee employee){ return servEmployee.updateEmployee(codigo, employee); }

    @DeleteMapping("/deleteEmployee/{codigo}")
    public String eliminarEmpleado(@PathVariable int codigo){ return servEmployee.deleteEmployee(codigo); }

    @PostMapping("/createCt/{codigo}")
    public String crearCuenta(@PathVariable int codigo, @RequestBody Cuenta cuenta){ return servEmployee.createCuenta(cuenta, codigo); }
}