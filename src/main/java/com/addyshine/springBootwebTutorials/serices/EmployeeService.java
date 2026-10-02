package com.addyshine.springBootwebTutorials.serices;

import com.addyshine.springBootwebTutorials.dto.EmployeeDTO;
import com.addyshine.springBootwebTutorials.entities.EmployeeEntity;
import com.addyshine.springBootwebTutorials.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long employeeId) {
      EmployeeEntity employeeEntity    = employeeRepository.findById(employeeId).orElse(null);

      return modelMapper.map(employeeEntity,EmployeeDTO.class);

    }

    public List<EmployeeDTO> getAllEmployees() {
         List<EmployeeEntity> empployeeEntities =   employeeRepository.findAll();
          return empployeeEntities
                 .stream()
                 .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                 .collect(Collectors.toList());
    }

    public EmployeeDTO addEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity tosaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity= employeeRepository.save(tosaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity =modelMapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity= employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public boolean deleteEmployeeById(long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            return false;
        }
        employeeRepository.deleteById(employeeId);
        return true;
    }
}
