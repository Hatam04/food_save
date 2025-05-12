package com.upc.food_save.services;

import com.upc.food_save.dtos.ReporteConsumidoAdminDto;
import com.upc.food_save.dtos.ReporteConsumoDto;
import com.upc.food_save.entities.InventarioAlimento;
import com.upc.food_save.entities.Usuario;
import com.upc.food_save.interfaces.IReporteService;
import com.upc.food_save.repositories.InventarioAlimentoRepository;
import com.upc.food_save.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReporteService implements IReporteService {
    @Autowired
    private InventarioAlimentoRepository inventarioRepo;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public ReporteConsumoDto generarReporteConsumo(Long idUsuario, LocalDate desde, LocalDate hasta) {
        List<InventarioAlimento> inventarios = inventarioRepo.findByUsuario_Id(idUsuario);

        int totalConsumidos = 0;
        int totalVencidos = 0;

        for (InventarioAlimento inv : inventarios) {
            LocalDate actualizacion = inv.getFecha_actualizacion();
            if (actualizacion != null && !actualizacion.isBefore(desde) && !actualizacion.isAfter(hasta)) {
                totalConsumidos += inv.getCantidad_consumida();
                totalVencidos += inv.getCantidad_vencida();
            }
        }

        int total = totalConsumidos + totalVencidos;
        double eficiencia = total > 0 ? ((double) totalConsumidos / total) * 100 : 0;
        double ahorro = totalConsumidos * 2.0; // En este caso, estamos suponiendo S/2 por unidad aprovechada

        return new ReporteConsumoDto(totalConsumidos, totalVencidos, eficiencia, ahorro);
    }

    @Override
    public List<ReporteConsumidoAdminDto> generarReporteGlobal(LocalDate desde, LocalDate hasta) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<ReporteConsumidoAdminDto> reportes = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            List<InventarioAlimento> inventarios = inventarioRepo.findByUsuario_Id(usuario.getId_usuario());

            int consumidos = 0;
            int vencidos = 0;

            for (InventarioAlimento inv : inventarios) {
                LocalDate actualizacion = inv.getFecha_actualizacion();
                if (actualizacion != null && !actualizacion.isBefore(desde) && !actualizacion.isAfter(hasta)) {
                    consumidos += inv.getCantidad_consumida();
                    vencidos += inv.getCantidad_vencida();
                }
            }

            int total = consumidos + vencidos;
            double eficiencia = total > 0 ? ((double) consumidos / total) * 100 : 0;
            double ahorro = consumidos * 2.0;

            reportes.add(new ReporteConsumidoAdminDto(
                    usuario.getId_usuario(),
                    usuario.getNombre_completo(),
                    consumidos,
                    vencidos,
                    eficiencia,
                    ahorro
            ));
        }

        return reportes;
    }
}
