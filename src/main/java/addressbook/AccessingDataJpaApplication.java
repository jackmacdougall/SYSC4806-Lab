package addressbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main (String[] args) {
        System.setProperty("server.port", "8081");
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

   /* @Bean
    public CommandLineRunner demo(BuddyRepository buddyRepository, AddressBookRepository addressBookRepository) {
        return (args) -> {
            // save a few buddy infos
            BuddyInfo b1 = new BuddyInfo("Jack", "123-456-7899");
            BuddyInfo b2 = new BuddyInfo("Chloe", "987-654-3211");
            buddyRepository.save(b1);
            buddyRepository.save(b2);
            buddyRepository.save(new BuddyInfo("Kim", "555-555-5555"));
            buddyRepository.save(new BuddyInfo("David", "456-987-3421"));


            //fetch all buddies
            log.info("BuddyInfos found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddyInfo : buddyRepository.findAll()) {
                log.info(buddyInfo.toString());
            }
            log.info("");

            // fetch an individual buddy by ID
            BuddyInfo buddyInfo = buddyRepository.findById(1);
            log.info("addressbook.BuddyInfo found with findById(1):");
            log.info("--------------------------------");
            log.info(buddyInfo.toString());
            log.info("");

            // fetch buddies by name
            log.info("Buddy found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            buddyRepository.findByName("Jack").forEach(jack -> {
                log.info(jack.toString());
            });
            log.info("");

            // fetch buddies by phone number
            log.info("Buddy found with findByLastName('987-654-3211'):");
            log.info("--------------------------------------------");
            buddyRepository.findByPhoneNumber("987-654-3211").forEach(found -> {
                log.info(found.toString());
            });
            log.info("");

            AddressBook a = new AddressBook("Address Book");

            //fetch all address books
            log.info("AddressBooks found with findAll():");
            log.info("-------------------------------");
            for (AddressBook addressBook : addressBookRepository.findAll()) {
                log.info(addressBook.toString());
            }
            log.info("");

            // fetch an individual address book by ID
            AddressBook addressBook = addressBookRepository.findById(1);
            log.info("addressbook.AddressBook found with findById(1):");
            log.info("--------------------------------");
            log.info(addressBook.toString());
            log.info("");

            // fetch buddies by name
            log.info("addressbook.AddressBook found with findByName('Address Book'):");
            log.info("--------------------------------------------");
            addressBookRepository.findByName("Address Book'").forEach(aBook -> {
                log.info(aBook.toString());
            });
            log.info("");
        };
    }*/

}
