package com.addyshine.springBootwebTutorials.controller;

import java.util.List;

import com.addyshine.springBootwebTutorials.dto.EmployeeDTO;
import com.addyshine.springBootwebTutorials.entities.EmployeeEntity;
import com.addyshine.springBootwebTutorials.serices.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecreteMessage")
//    public String getMySecreteMessages() {
//        return "Hello World! AI is nothing without the human";
//    }

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService emplyeeService) {
    this.employeeService = emplyeeService;
  }

  @GetMapping(path = "/{employeeId}")
  public EmployeeDTO getEmployeeById(@PathVariable Long employeeId) {


    return employeeService.getEmployeeById(employeeId);
  }

  @GetMapping
  public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age,
                                           @RequestParam(required = false) String sortBy) {
    return employeeService.getAllEmployees();
  }

  @PostMapping
  public EmployeeDTO addEmployee(@RequestBody EmployeeDTO inputEmployee) {

    return employeeService.addEmployee(inputEmployee);

  }


  @PutMapping(path = "/{employeeId}")
  public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId) {
    return employeeService.updateEmployeeById(employeeId, employeeDTO);
  }

  @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable long employeeId){
     return  employeeService.deleteEmployeeById(employeeId);

    }
  }


