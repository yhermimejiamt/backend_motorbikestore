package ciclo3.AppMotorBikeStore.Repository;

import ciclo3.AppMotorBikeStore.Interface.InterfaceMotorbike;
import ciclo3.AppMotorBikeStore.Model.Motorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@Repository
public class MotorbikeRepository {

    @Autowired
    private InterfaceMotorbike crud;

    public List<Motorbike> getAll() {
        return (List<Motorbike>) crud.findAll();
    }

    public Optional<Motorbike> getMotorbike(int id) {
        return crud.findById(id);
    }

    public Motorbike save(Motorbike motorbike) {
        return crud.save(motorbike);
    }

    public void delete(Motorbike motorbike) {
        crud.delete(motorbike);
    }

}