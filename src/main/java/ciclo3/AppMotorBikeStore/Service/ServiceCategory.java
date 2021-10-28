package ciclo3.AppMotorBikeStore.Service;

import ciclo3.AppMotorBikeStore.Model.Category;
import ciclo3.AppMotorBikeStore.Repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@Service
public class ServiceCategory {

    @Autowired
    private CategoryRepository metodosCrud;

    public List<Category> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Category> getCategoria(int idCategoria) {
        return metodosCrud.getCategoria(idCategoria);
    }

    public Category save(Category categoria) {
        if (categoria.getId() == null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Category> evt = metodosCrud.getCategoria(categoria.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public Category update(Category categoria) {
        if (categoria.getId() != null) {
            Optional<Category> g = metodosCrud.getCategoria(categoria.getId());
            if (!g.isEmpty()) {
                if (categoria.getDescription() != null) {
                    g.get().setDescription(categoria.getDescription());
                }
                if (categoria.getName() != null) {
                    g.get().setName(categoria.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categoria;
    }

    public boolean deleteCategoria(int categoriaId) {
        Boolean d = getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}