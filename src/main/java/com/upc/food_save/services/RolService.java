package com.upc.food_save.services;

import com.upc.food_save.dtos.RolDto;
import com.upc.food_save.entities.Rol;
import com.upc.food_save.interfaces.IRolService;
import com.upc.food_save.repositories.RolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService implements IRolService {
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public RolDto registrarRol(RolDto dto) {
        Rol rol = modelMapper.map(dto, Rol.class);
        return modelMapper.map(rolRepository.save(rol), RolDto.class);
    }

    @Override
    public RolDto actualizarRol(RolDto dto) {
        Rol rol = rolRepository.findById(dto.getId_rol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        rol.setNombre(dto.getNombre());
        rol.setDescripcion(dto.getDescripcion());

        return modelMapper.map(rolRepository.save(rol), RolDto.class);
    }

    @Override
    public void eliminarRol(Long idRol) {
        rolRepository.deleteById(idRol);
    }

    @Override
    public List<RolDto> listarRoles() {
        return rolRepository.findAll().stream()
                .map(r -> modelMapper.map(r, RolDto.class))
                .collect(Collectors.toList());
    }
}
