package apitiendavideo_arquitecturalimpia.apitiendavideo.commons;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apitiendavideo_arquitecturalimpia.apitiendavideo.applications.inputPort.IPaisServicio;
import apitiendavideo_arquitecturalimpia.apitiendavideo.applications.outputPort.IPaisRepositorio;
import apitiendavideo_arquitecturalimpia.apitiendavideo.entities.Pais;

@Service
public class PaisServicio implements IPaisServicio {

    @Autowired
    IPaisRepositorio repositorio;

    @Override
    public List<Pais> listar() {
        return repositorio.findAll();
    }

    @Override
    public Pais obtener(long id) {
        var pais = repositorio.findById(id);
        return pais.isEmpty() ? null : pais.get();
    }

    @Override
    public List<Pais> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Pais guardar(Pais pais) {
        return repositorio.save(pais);
    }

    @Override
    public boolean eliminar(long id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }
}
