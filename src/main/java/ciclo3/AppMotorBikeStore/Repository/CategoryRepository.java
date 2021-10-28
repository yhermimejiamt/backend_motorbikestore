package ciclo3.AppMotorBikeStore.Repository;

import ciclo3.AppMotorBikeStore.Interface.InterfaceCategory;
import ciclo3.AppMotorBikeStore.Model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@Repository
public class CategoryRepository {

    @Autowired
    private InterfaceCategory crud2;

    public List<Category> getAll() {
        return (List<Category>) crud2.findAll();
    }

    public Optional<Category> getCategoria(int id) {
        return crud2.findById(id);
    }

    public Category save(Category categoria) {
        return crud2.save(categoria);
    }

    public void delete(Category categoria) {
        crud2.delete(categoria);
    }
}