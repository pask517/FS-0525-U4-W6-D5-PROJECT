package andreapascarella.u5d10project.services;

import andreapascarella.u5d10project.entities.Employee;
import andreapascarella.u5d10project.exceptions.BadRequestException;
import andreapascarella.u5d10project.payloads.EmployeeDTO;
import andreapascarella.u5d10project.repositories.EmployeesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeesService {

    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public Employee saveEmployee(EmployeeDTO payload) {
        this.employeesRepository.findByEmail(payload.email()).ifPresent(user -> {
            throw new BadRequestException("L'email " + user.getEmail() + " è già in uso!");
        });

        Employee newEmployee = new Employee(payload.username(), payload.name(), payload.surname(), payload.email());

        Employee savedEmployee = this.employeesRepository.save(newEmployee);

        log.info("L'utente con id " + savedEmployee.getEmployeeId() + " è stato salvato correttamente!");

        return savedEmployee;
    }
}
