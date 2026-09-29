package com.addyshine.springBootwebTutorials.controller;

import com.addyshine.springBootwebTutorials.dto.EmployeeDTO;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecreteMessage")
//    public String getMySecreteMessages() {
//        return "Hello World! AI is nothing without the human";
//    }

  @GetMapping( path="/{employeeId}")
  public EmployeeDTO  getEmployeeById(@PathVariable Long employeeId) {

      return  new EmployeeDTO(employeeId,"aditya","addy@gmail.com",26,LocalDate.of(2024,06,21),true);
  }
  @GetMapping
    public String getAllEmployees(@RequestParam(required = false)  Integer age,
                                  @RequestParam(required = false) String sortBy) {
      return  "hi age"+age+ " "+ sortBy;

  }
  @PostMapping
  public EmployeeDTO addEmployee(@RequestBody EmployeeDTO inputEmployee) {
    inputEmployee.setId(100L);
    return inputEmployee;

  }

  @PutMapping String updateEmployeeIs(){
    return  " hello Put  kaise ho !!!!";
  }


}
