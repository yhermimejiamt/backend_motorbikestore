package ciclo3.AppMotorBikeStore.Repository;

import ciclo3.AppMotorBikeStore.Interface.InterfaceClient;
import ciclo3.AppMotorBikeStore.Model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@Repository
public class ClientRepository {

    @Autowired
    private InterfaceClient crud1;

    public List<Client> getAll() {
        return (List<Client>) crud1.findAll();
    }

    public Optional<Client> getCliente(int id) {
        return crud1.findById(id);
    }

    public Client save(Client cliente) {
        return crud1.save(cliente);
    }

    public void delete(Client cliente) {
        crud1.delete(cliente);
    }
}