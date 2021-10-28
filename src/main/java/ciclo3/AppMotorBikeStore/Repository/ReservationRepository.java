package ciclo3.AppMotorBikeStore.Repository;

import ciclo3.AppMotorBikeStore.Interface.InterfaceReservation;
import ciclo3.AppMotorBikeStore.Model.Client;
import ciclo3.AppMotorBikeStore.Model.Reservation;
import ciclo3.AppMotorBikeStore.Reports.CountClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@Repository
public class ReservationRepository {

    @Autowired
    private InterfaceReservation intResev;

    public List<Reservation> getAll() {
        return (List<Reservation>) intResev.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return intResev.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return intResev.save(reservation);
    }

    public void delete(Reservation reservacion) {
        intResev.delete(reservacion);
    }

    public List<Reservation> ReservationStatus(String status) {
        return intResev.findAllByStatus(status);
    }

    public List<Reservation> ReservationDate(Date first, Date second) {
        return intResev.findAllByStartDateAfterAndStartDateBefore(first, second);
    }

    public List<CountClient> getTopClient() {
        List<CountClient> countClient = new ArrayList<>();
        List<Object[]> report = intResev.countTotalReservationsByClient();
        for (int i = 0; i < report.size(); i++) {
            countClient.add(new CountClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return countClient;
    }

}
