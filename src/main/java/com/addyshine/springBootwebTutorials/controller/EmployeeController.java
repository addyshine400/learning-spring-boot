package com.addyshine.springBootwebTutorials.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.addyshine.springBootwebTutorials.dto.EmployeeDTO;
import com.addyshine.springBootwebTutorials.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecreteMessage")
//    public String getMySecreteMessages() {
//        return "Hello World! AI is nothing without the human";
//    }

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping(path = "/{employeeId}")
  public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable long employeeId) {
    Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(employeeId);
    return employeeDTO
            .map(employeeDTO1 ->ResponseEntity.ok(employeeDTO1) )
            .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false) Integer age,
                                           @RequestParam(required = false) String sortBy) {
    return ResponseEntity.ok(employeeService.getAllEmployees());
  }

  @PostMapping
  public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody @Valid EmployeeDTO inputEmployee) {

   EmployeeDTO savedEmployee=  employeeService.addEmployee(inputEmployee);
    return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
  }


  @PutMapping(path = "/{employeeId}")
  public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId) {
    return  ResponseEntity.ok (employeeService.updateEmployeeById(employeeId, employeeDTO));
  }

  @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable long employeeId){
     boolean gotdeleted = employeeService.deleteEmployeeById(employeeId);
     if(gotdeleted) return  ResponseEntity.ok(true);
     return ResponseEntity.notFound().build();

    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> patchEmployee(@RequestBody Map<String,Object> updates,
                                     @PathVariable long employeeId) {
       EmployeeDTO employeeDTO=  employeeService.patchEmployee(employeeId,updates);

       if(employeeDTO == null) return ResponseEntity.notFound().build();
       return ResponseEntity.ok(employeeDTO);
    }

  }


