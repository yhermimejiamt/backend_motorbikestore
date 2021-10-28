package ciclo3.AppMotorBikeStore.Web;

import ciclo3.AppMotorBikeStore.Model.Client;
import ciclo3.AppMotorBikeStore.Service.ServiceClient;
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
@RequestMapping("/api/Client")
public class ClientWeb {

    @Autowired
    private ServiceClient servicios;

    @GetMapping("/all")
    public List<Client> getCliente() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getCliente(@PathVariable("id") int clientid) {
        return servicios.getCliente(clientid);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client cliente) {
        return servicios.save(cliente);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client cliente) {
        return servicios.update(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clienteId) {
        return servicios.deleteClient(clienteId);
    }
}