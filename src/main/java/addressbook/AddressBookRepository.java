package addressbook;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "books")
public interface AddressBookRepository extends CrudRepository<AddressBook, Integer>{

    List<AddressBook> findByName(@Param("name") String name);
    AddressBook findById(@Param("id") int id);
}
