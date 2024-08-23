package guru.springframework.Spring5webApp.repositories;

import guru.springframework.Spring5webApp.domain.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends JpaRepository<Publishers,Long> {

}
