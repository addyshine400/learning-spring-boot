package com.addyshine.springBootwebTutorials.services;

import com.addyshine.springBootwebTutorials.dto.EmployeeDTO;
import com.addyshine.springBootwebTutorials.entities.EmployeeEntity;
import com.addyshine.springBootwebTutorials.exception.ResourceNotFoundException;
import com.addyshine.springBootwebTutorials.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO >getEmployeeById(Long employeeId) {
//EmployeeEntity employeeEntity    = employeeRepository.findById(employeeId).orElse(null);

return employeeRepository.findById(employeeId).map(employeeEntity ->  modelMapper.map(employeeEntity, EmployeeDTO.class));

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

         isExistingEmployeeId(employeeId);
         EmployeeEntity employeeEntity =modelMapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity= employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public void isExistingEmployeeId(long employeeId) { //bar bar jo chize repeate ho rhi hai use yha ek bar write krk har jgh use krlo sirf employeeservice me

        boolean exists= employeeRepository.existsById(employeeId);
        if (!exists)
            throw new ResourceNotFoundException("EMPLOYEE NOT FOUND with id: " + employeeId);



    }

    public boolean deleteEmployeeById(long employeeId) {
         isExistingEmployeeId(employeeId);

        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO patchEmployee(long employeeId, Map<String, Object> updates) {
        isExistingEmployeeId(employeeId);

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElse(null);
        updates.forEach((key, value) -> {
           Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class,key);
           fieldToBeUpdated.setAccessible(true);
           ReflectionUtils.setField(fieldToBeUpdated,employeeEntity,value);
        });
        return  modelMapper.map(employeeEntity,EmployeeDTO.class);
    }
}
