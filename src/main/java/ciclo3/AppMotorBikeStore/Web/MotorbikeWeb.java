package ciclo3.AppMotorBikeStore.Web;

import ciclo3.AppMotorBikeStore.Model.Motorbike;
import ciclo3.AppMotorBikeStore.Service.ServiceMotorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@RestController
@RequestMapping("/api/Motorbike")
public class MotorbikeWeb {

    @GetMapping("/holaMundo")
    public String saludad() {
        return "Hola Motorbike Store";
    }

    @Autowired
    private ServiceMotorbike servicio;

    @GetMapping("all")
    public List<Motorbike> getFinca() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Motorbike> getOrthesis(@PathVariable("id") int idMotorbike) {
        return servicio.getMotorbike(idMotorbike);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike save(@RequestBody Motorbike motorbike) {
        return servicio.save(motorbike);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike update(@RequestBody Motorbike motorbike) {
        return servicio.update(motorbike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int motorbikeId) {
        return servicio.deleteMotorbike(motorbikeId);
    }
}