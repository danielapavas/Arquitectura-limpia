package apitiendavideo_arquitecturalimpia.apitiendavideo.adapters.In;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo_arquitecturalimpia.apitiendavideo.entities.Pais;
import apitiendavideo_arquitecturalimpia.apitiendavideo.applications.inputPort.IPaisServicio;

@RestController
@RequestMapping("/paises")
public class PaisControlador {

    @Autowired
    private IPaisServicio servicio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Pais> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener{id}", method = RequestMethod.GET)
    public Pais obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Pais agregar(@RequestBody Pais pais) {
        return servicio.guardar(pais);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.POST)
    public Pais modificar(@RequestBody Pais pais) {

        if (servicio.obtener(pais.getId()) != null) {
            return servicio.guardar(pais);
        } else {
            return null;
        }
    }
}