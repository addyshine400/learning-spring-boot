package com.addyshine.springBootwebTutorials.configs;

import com.addyshine.springBootwebTutorials.dto.EmployeeDTO;
import com.addyshine.springBootwebTutorials.entities.EmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class mapperconfig {
    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper= new ModelMapper();
        modelMapper.typeMap(EmployeeDTO.class, EmployeeEntity.class).addMapping(EmployeeDTO::getActive,EmployeeEntity::setIsActive);
        return modelMapper;
    }
}
