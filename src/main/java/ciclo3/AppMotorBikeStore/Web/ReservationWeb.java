package ciclo3.AppMotorBikeStore.Web;

import ciclo3.AppMotorBikeStore.Model.Reservation;
import ciclo3.AppMotorBikeStore.Reports.CountClient;
import ciclo3.AppMotorBikeStore.Reports.StatusReservation;
import ciclo3.AppMotorBikeStore.Service.ServiceReservation;
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
@RequestMapping("/api/Reservation")
public class ReservationWeb {

    @Autowired
    private ServiceReservation servicio;

    @GetMapping("/all")
    public List<Reservation> getReservations() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
        return servicio.getReservation(reservationId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return servicio.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservacion) {
        return servicio.update(reservacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicio.deleteReservation(reservationId);
    }

    @GetMapping("/report-status")
    public StatusReservation getReservas() {
        return servicio.getReportStatusReservation();
    }

    @GetMapping("/report-dates/{firstDate}/{secondDate}")
    public List<Reservation> getReservationsDate(@PathVariable("firstDate") String firstDate, @PathVariable("secondDate") String secondDate) {

        return servicio.getReportDateReservation(firstDate, secondDate);
    }

    @GetMapping("/report-clients")
    public List<CountClient> getClients() {
        return servicio.serviceTopClients();
    }

}
