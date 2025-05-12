package com.upc.food_save.services;

import com.upc.food_save.dtos.PerfilUsuarioDto;
import com.upc.food_save.entities.PerfilUsuario;
import com.upc.food_save.entities.Usuario;
import com.upc.food_save.interfaces.IPerfilUsuarioService;
import com.upc.food_save.repositories.PerfilUsuarioRepository;
import com.upc.food_save.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilUsuarioService implements IPerfilUsuarioService {
    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PerfilUsuarioDto actualizarPerfil(PerfilUsuarioDto perfilDto) {
        PerfilUsuario perfil;
        if (perfilDto.getId_perfil() != null) {
            perfil = perfilUsuarioRepository.findById(perfilDto.getId_perfil()).orElse(new PerfilUsuario());
        } else {
            perfil = perfilUsuarioRepository.findByUsuario_Id(perfilDto.getId_usuario()).orElse(new PerfilUsuario());
        }

        Usuario usuario = usuarioRepository.findById(perfilDto.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        perfil.setFoto_perfil(perfilDto.getFoto_perfil());
        perfil.setObjetivo(perfilDto.getObjetivo());
        perfil.setNivel_compromiso(perfilDto.getNivel_compromiso());
        perfil.setUsuario(usuario);

        return modelMapper.map(perfilUsuarioRepository.save(perfil), PerfilUsuarioDto.class);
    }

    @Override
    public PerfilUsuarioDto obtenerPerfilPorUsuario(Long idUsuario) {
        PerfilUsuario perfil = perfilUsuarioRepository.findByUsuario_Id(idUsuario)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
        return modelMapper.map(perfil, PerfilUsuarioDto.class);
    }
}
