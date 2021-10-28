package ciclo3.AppMotorBikeStore.Interface;

import ciclo3.AppMotorBikeStore.Model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
public interface InterfaceMessage extends CrudRepository<Message, Integer>{
    
}