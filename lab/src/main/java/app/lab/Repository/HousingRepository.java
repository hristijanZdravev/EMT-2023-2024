package app.lab.Repository;

import app.lab.Model.Housing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HousingRepository extends JpaRepository<Housing, Long> {
}