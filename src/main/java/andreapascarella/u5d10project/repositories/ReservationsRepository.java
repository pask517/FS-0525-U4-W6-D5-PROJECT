package andreapascarella.u5d10project.repositories;

import andreapascarella.u5d10project.entities.Employee;
import andreapascarella.u5d10project.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface ReservationsRepository extends JpaRepository<Reservation, UUID> {

    boolean existsByReservationEmployeeAndReservationDate(Employee employee, LocalDate reservationDate);
}
