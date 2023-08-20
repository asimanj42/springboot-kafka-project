package az.company.kafkaconsumerwikimedia.repository;

import az.company.kafkaconsumerwikimedia.model.Wikimedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<Wikimedia,Long> {
}
