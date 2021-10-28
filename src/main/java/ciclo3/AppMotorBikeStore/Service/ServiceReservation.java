package ciclo3.AppMotorBikeStore.Service;  // should be lowercase name

import ciclo3.AppMotorBikeStore.Model.Reservation;
import ciclo3.AppMotorBikeStore.Reports.CountClient;
import ciclo3.AppMotorBikeStore.Repository.ReservationRepository;
import ciclo3.AppMotorBikeStore.Reports.StatusReservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@Service
public class ServiceReservation {

    @Autowired
    private ReservationRepository metodosCrud;

    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
        } else {
            Optional<Reservation> e = metodosCrud.getReservation(reservation.getIdReservation());
            if (e.isEmpty()) {
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = metodosCrud.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public StatusReservation getReportStatusReservation() {

        List<Reservation> completed = metodosCrud.ReservationStatus("completed");
        List<Reservation> cancelled = metodosCrud.ReservationStatus("cancelled");

        return new StatusReservation(completed.size(), cancelled.size());
    }

    public List<Reservation> getReportDateReservation(String first, String second) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate = new Date();
        Date secondDate = new Date();

        try {
            firstDate = format.parse(first);
            secondDate = format.parse(second);
        } catch (ParseException evt) {
        }
        if (firstDate.before(secondDate)) {
            return metodosCrud.ReservationDate(firstDate, secondDate);
        } else {
            return new ArrayList<>();
        }
    }
    
    public List<CountClient> serviceTopClients(){
        return metodosCrud.getTopClient();
    }

}
