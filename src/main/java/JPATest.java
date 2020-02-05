import addressbook.AddressBook;
import addressbook.BuddyInfo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPATest {

    public void performJPA() {
        BuddyInfo buddyInfo1 = new BuddyInfo();
        buddyInfo1.setId(1);
        buddyInfo1.setName("John Lennon");
        buddyInfo1.setPhoneNumber("(613)-123-4567");

        BuddyInfo buddyInfo2 = new BuddyInfo();
        buddyInfo2.setId(2);
        buddyInfo2.setName("Paul McCartney");
        buddyInfo2.setPhoneNumber("(613)-987-6543");

        BuddyInfo buddyInfo3 = new BuddyInfo();
        buddyInfo3.setId(3);
        buddyInfo3.setName("George Harrison");
        buddyInfo3.setPhoneNumber("(613)-555-5555");

        BuddyInfo buddyInfo4 = new BuddyInfo();
        buddyInfo4.setId(4);
        buddyInfo4.setName("Ringo Starr");
        buddyInfo4.setPhoneNumber("(613)-434-7676");

        AddressBook addressBook = new AddressBook();
        addressBook.setId(1);
        addressBook.setName("The Beatles");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(buddyInfo1);
        em.persist(buddyInfo2);
        em.persist(buddyInfo3);
        em.persist(buddyInfo4);
        tx.commit();


        Query q1 = em.createQuery("SELECT b FROM BuddyInfo b");
        @SuppressWarnings("unchecked")
        List<BuddyInfo> buddyInfoResults = q1.getResultList();
        System.out.println("List of buddy infos\n----------------");
        for (BuddyInfo b : buddyInfoResults) {
            System.out.println(b.toString());
            addressBook.addBuddy(b);
        }
        System.out.println();

        tx.begin();
        em.persist(addressBook);
        tx.commit();

        Query q2 = em.createQuery("SELECT a FROM AddressBook a");
        @SuppressWarnings("unchecked")
        List<AddressBook> addressBookResults = q2.getResultList();
        System.out.println("List of address books\n----------------");
        for (AddressBook a : addressBookResults) {
            System.out.println(a.toString());
        }
        em.close();
        emf.close();
    }
}
