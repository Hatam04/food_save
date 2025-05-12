package com.upc.food_save.services;

import com.upc.food_save.dtos.InventarioAlimentoDto;
import com.upc.food_save.dtos.NotificacionDto;
import com.upc.food_save.entities.Alimento;
import com.upc.food_save.entities.InventarioAlimento;
import com.upc.food_save.entities.Usuario;
import com.upc.food_save.interfaces.IInventarioAlimentoService;
import com.upc.food_save.interfaces.INotificacionService;
import com.upc.food_save.repositories.AlimentoRepository;
import com.upc.food_save.repositories.InventarioAlimentoRepository;
import com.upc.food_save.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventarioAlimentoService implements IInventarioAlimentoService {
    @Autowired
    private InventarioAlimentoRepository inventarioAlimentoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AlimentoRepository alimentoRepository;
    @Autowired
    private INotificacionService notificacionService;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public InventarioAlimentoDto registrarInventario(InventarioAlimentoDto inventarioDto) {
        InventarioAlimento inventario = modelMapper.map(inventarioDto, InventarioAlimento.class);

        Usuario usuario = usuarioRepository.findById(inventarioDto.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Alimento alimento = alimentoRepository.findById(inventarioDto.getId_alimento())
                .orElseThrow(() -> new RuntimeException("Alimento no encontrado"));

        inventario.setUsuario(usuario);
        inventario.setAlimento(alimento);
        inventario.setFecha_registro(LocalDate.now());
        inventario.setFecha_actualizacion(LocalDate.now());

        return modelMapper.map(inventarioAlimentoRepository.save(inventario), InventarioAlimentoDto.class);
    }

    @Override
    public InventarioAlimentoDto actualizarInventario(Long idInventario, int cantidadConsumida, int cantidadVencida) {
        InventarioAlimento inventario = inventarioAlimentoRepository.findById(idInventario)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));

        inventario.setCantidad_consumida(cantidadConsumida);
        inventario.setCantidad_vencida(cantidadVencida);
        inventario.setFecha_actualizacion(LocalDate.now());

        return modelMapper.map(inventarioAlimentoRepository.save(inventario), InventarioAlimentoDto.class);
    }

    @Override
    public List<InventarioAlimentoDto> listarInventarioPorUsuario(Long idUsuario) {
        List<InventarioAlimento> inventarios = inventarioAlimentoRepository.findByUsuario_Id(idUsuario);

        for (InventarioAlimento inventario : inventarios) {
            Alimento alimento = inventario.getAlimento();
            LocalDate fechaVencimiento = alimento.getFecha_vencimiento();

            if (fechaVencimiento != null && fechaVencimiento.isBefore(LocalDate.now().plusDays(3))) {
                NotificacionDto noti = new NotificacionDto();
                noti.setMensaje("Tu alimento '" + alimento.getNombre() + "' está por vencer.");
                noti.setId_usuario(idUsuario);
                notificacionService.enviarNotificacion(noti);
            }
        }

        return inventarios.stream()
                .map(i -> modelMapper.map(i, InventarioAlimentoDto.class))
                .collect(Collectors.toList());
    }
}
