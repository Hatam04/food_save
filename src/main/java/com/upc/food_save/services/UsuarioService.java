package com.upc.food_save.services;

import com.upc.food_save.dtos.UsuarioDto;
import com.upc.food_save.entities.Usuario;
import com.upc.food_save.interfaces.IUsuarioService;
import com.upc.food_save.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioDto registrarUsuario(UsuarioDto usuarioDto) {
        if (usuarioRepository.existsByCorreo(usuarioDto.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado.");
        }
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        usuario.setFecha_registro(java.time.LocalDate.now());
        return modelMapper.map(usuarioRepository.save(usuario), UsuarioDto.class);
    }

    @Override
    public UsuarioDto login(String correo, String contrasenia) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByCorreoAndContrasenia(correo, contrasenia);
        if (optionalUsuario.isPresent()) {
            return modelMapper.map(optionalUsuario.get(), UsuarioDto.class);
        } else {
            throw new RuntimeException("Credenciales incorrectas.");
        }
    }

    @Override
    public List<UsuarioDto> listarUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(u -> modelMapper.map(u, UsuarioDto.class))
                .collect(Collectors.toList());
    }
}
