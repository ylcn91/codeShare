package platform.repository;


import org.springframework.data.repository.CrudRepository;
import platform.model.Code;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CodeRepository extends CrudRepository<Code, Integer> {

    @Transactional
        // https://stackoverflow.com/questions/27567351/get-last-records-ordered-by-date-on-spring-data
        // List<Code> findTop10ByOrderByIdDesc();
        // List<Code> findTop10ByViewsGreaterThan0AndTimeGreaterThan0OrderByDateDesc();
    List<Code> findAllByOrderByDateDesc();

    @Transactional
    Optional<Code> findByUuid(String id);
}
