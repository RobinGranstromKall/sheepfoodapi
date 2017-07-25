package se.nackademin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.nackademin.domain.Unit;
import se.nackademin.repository.UnitRepository;

import java.util.List;

@Service
public class UnitService {

    private final UnitRepository repository;

    @Autowired
    public UnitService(UnitRepository repository) {
        this.repository = repository;
    }

    public List<Unit> getUnits() {
        return repository.findAll();
    }

    public void addUnit(Unit unit) {
        repository.save(unit);
    }
}
