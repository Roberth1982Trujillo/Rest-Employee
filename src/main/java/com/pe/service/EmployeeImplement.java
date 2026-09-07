package com.pe.service;

import com.pe.entity.Cuenta;
import com.pe.feignclient.ICuentaFeignClient;
import com.pe.model.Employee;
import com.pe.repository.IEmployeeRepository;
import com.pe.rabbit.RabbitMQConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

@Service
public class EmployeeImplement implements IEmployeeService {
    @Autowired
    IEmployeeRepository repoEmployee;

    @Autowired
    ICuentaFeignClient feigCuenta;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public List<Employee> listAllEmployee() {
        return repoEmployee.findAll();
    }

    @Override
    public String createEmployee(Employee employee) {
        repoEmployee.save(employee);

        // 2. Envío de evento a RabbitMQ de manera asíncrona
        String mensaje = "Nuevo empleado creado con ID: " + employee.getCod_Empl()
                + " y Correo: " + employee.getEmail_Empl();

        rabbitTemplate.convertAndSend( RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, mensaje);

        return "Empleado creado";
    }

    @Override
    public String updateEmployee(int codigo, Employee employee) {
        Employee empl = repoEmployee.findById(codigo).get();
        if(empl == null) return "Empleado NO encontrado";
        else {
            empl.setName_Empl(employee.getName_Empl());
            empl.setSurname_Empl(employee.getSurname_Empl());
            empl.setEmail_Empl(employee.getEmail_Empl());

            repoEmployee.save(empl);
            return "Empleado actualizado";
        }
    }

    @Override
    public String deleteEmployee(int codigo) {
        if (repoEmployee.existsById(codigo)) {
            repoEmployee.deleteById(codigo);
            return "Empleado eliminado";
        } else {
            return "Empleado NO encontrado";
        }
    }

    @Override
    public String createCuenta(Cuenta cuenta, int cod_Empl) {
        cuenta.setCod_Empl(cod_Empl);
        return feigCuenta.crearCuenta(cuenta);
    }
}