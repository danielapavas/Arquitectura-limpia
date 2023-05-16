package apitiendavideo_arquitecturalimpia.apitiendavideo.applications.inputPort;

import java.util.List;

import apitiendavideo_arquitecturalimpia.apitiendavideo.entities.Pais;

public interface IPaisServicio {

    List<Pais> listar();

    Pais obtener(long id);

    List<Pais> buscar(String nombre);

    Pais guardar(Pais pais);

    boolean eliminar(long id);

}