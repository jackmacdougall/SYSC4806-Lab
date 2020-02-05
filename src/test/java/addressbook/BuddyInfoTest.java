package addressbook;

import addressbook.BuddyInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    @Test
    public void getName() {
        BuddyInfo b1 = new BuddyInfo("Jack", "(613)-327-9336");
        assertEquals(b1.getName(), "Jack");
    }

    @Test
    public void setName() {
        BuddyInfo b1 = new BuddyInfo("Jack", "(613)-327-9336");
        b1.setName("Jim");
        assertEquals(b1.getName(), "Jim");
    }

    @Test
    public void getPhoneNumber() {
        BuddyInfo b1 = new BuddyInfo("Jack", "(613)-327-9336");
        assertEquals(b1.getPhoneNumber(), "(613)-327-9336");
    }

    @Test
    public void setPhoneNumber() {
        BuddyInfo b1 = new BuddyInfo("Jack", "(613)-327-9336");
        b1.setPhoneNumber("613-987-6543");
        assertEquals(b1.getPhoneNumber(), "613-987-6543");
    }
}