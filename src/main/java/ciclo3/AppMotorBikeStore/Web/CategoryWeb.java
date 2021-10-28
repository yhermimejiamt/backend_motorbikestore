package ciclo3.AppMotorBikeStore.Web;

import ciclo3.AppMotorBikeStore.Model.Category;
import ciclo3.AppMotorBikeStore.Service.ServiceCategory;
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
@RequestMapping("/api/Category")
public class CategoryWeb {

    @Autowired
    private ServiceCategory servicios;

    @GetMapping("/all")
    public List<Category> getCategoria() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoria(@PathVariable("id") int idCategoria) {
        return servicios.getCategoria(idCategoria);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category categoria) {
        return servicios.save(categoria);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category categoria) {
        return servicios.update(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoriaId) {
        return servicios.deleteCategoria(categoriaId);
    }
}