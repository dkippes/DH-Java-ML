package com.hql.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hql.model.Doctor;
import com.hql.model.dto.DoctorDTO;
import com.hql.model.dto.TurnDTO;
import com.hql.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    ModelMapper mapper;

    @PostMapping("/save")
    public String saveDoctor(@RequestBody DoctorDTO doctorDTO){
        //el mapeo se tiene que hacer en service
        Doctor doctor = mapper.map(doctorDTO, Doctor.class);
        doctorRepository.save(doctor);
        return "todo salio bien";
    }

    @GetMapping("/get1")
    public Doctor find1(@RequestBody DoctorDTO doctorDTO) throws Exception {
        //buscar en el service
        return doctorRepository.buscarDoctorPorNombre3(doctorDTO.getName()).orElseThrow(Exception::new);
//        doctorRepository.buscarDoctorPorNombre(doctorDTO.getName()).
//        return mapper.map(doc, DoctorDTO.class);
    }

    @GetMapping("/get2")
    public DoctorDTO find2(@RequestBody DoctorDTO doctorDTO) throws Exception {
        //buscar en el service
        Doctor doc = doctorRepository.findDoctorByName(doctorDTO.getName());
//        doctorRepository.buscarDoctorPorNombre(doctorDTO.getName()).
        return mapper.map(doc, DoctorDTO.class);
    }

    @GetMapping("/get3")
    public DoctorDTO find3(@RequestBody DoctorDTO doctorDTO) throws Exception {
        //buscar en el service
        Doctor doc = doctorRepository.buscarDoctorPorNombre(doctorDTO.getName());
//        doctorRepository.buscarDoctorPorNombre(doctorDTO.getName()).
        return mapper.map(doc, DoctorDTO.class);
    }

    @GetMapping("/get4")
    public DoctorDTO find4(@RequestBody DoctorDTO doctorDTO) throws Exception {
        //buscar en el service
        Doctor doc = doctorRepository.buscarDoctorPorNombre2(doctorDTO.getName());
//        doctorRepository.buscarDoctorPorNombre(doctorDTO.getName()).
        return mapper.map(doc, DoctorDTO.class);
    }

    @GetMapping("/get5")
    public DoctorDTO find5(@RequestBody DoctorDTO doctorDTO) throws Exception {
        //buscar en el service
        Doctor doc = doctorRepository.buscarDoctorPorNombre4(doctorDTO.getName());
//        doctorRepository.buscarDoctorPorNombre(doctorDTO.getName()).
        return mapper.map(doc, DoctorDTO.class);
    }

    @GetMapping("/get6")
    public Set<DoctorDTO> find6(@RequestBody DoctorDTO doctorDTO) throws Exception {
        //buscar en el service
//        return doctorRepository.findDoctorByNameStartingWith(doctorDTO.getName());
//        doctorRepository.buscarDoctorPorNombre(doctorDTO.getName()).
//        Set<Doctor> docs = (Set<Doctor>) new ArrayList<Doctor>();
//        docs.
        ;
//        mapper.map(doctorRepository.findDoctorByNameStartingWith(doctorDTO.getName()), new TypeToken<Set<Doctor>>(){}.getType());
        return doctorRepository.findDoctorByNameStartingWith(doctorDTO.getName())
                    .stream()
                    .map(doctor -> mapper.map(doctor, DoctorDTO.class))
                    .collect(Collectors.toSet());
    }
}
