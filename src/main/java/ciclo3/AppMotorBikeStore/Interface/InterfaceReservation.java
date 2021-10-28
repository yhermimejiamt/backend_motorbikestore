package ciclo3.AppMotorBikeStore.Interface;

import ciclo3.AppMotorBikeStore.Model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
public interface InterfaceReservation extends CrudRepository<Reservation, Integer> {

    public List<Reservation> findAllByStatus(String status);

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date first, Date second);

    @Query("SELECT cl.client, COUNT(cl.client) FROM Reservation AS cl GROUP BY cl.client ORDER BY COUNT(cl.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
}
