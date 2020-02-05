package addressbook;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "buddies")
public interface BuddyRepository extends CrudRepository<BuddyInfo, Integer>{

    List<BuddyInfo> findByName(@Param("name") String name);
    List<BuddyInfo> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
    BuddyInfo findById(@Param("id") int id);
}
