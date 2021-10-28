package ciclo3.AppMotorBikeStore.Interface;

import ciclo3.AppMotorBikeStore.Model.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
public interface InterfaceClient extends CrudRepository<Client, Integer>{
    
}