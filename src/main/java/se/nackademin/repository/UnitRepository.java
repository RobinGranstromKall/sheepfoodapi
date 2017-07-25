package se.nackademin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.nackademin.domain.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {
}
