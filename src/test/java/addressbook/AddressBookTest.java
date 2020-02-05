package addressbook;

import addressbook.AddressBook;
import addressbook.BuddyInfo;

import static org.junit.Assert.*;

public class AddressBookTest {
    protected BuddyInfo b1, b2;

    protected void setUp(){
        b1 = new BuddyInfo("Jack", "(613)-327-9336");
        b2 = new BuddyInfo("Joe", "(613)-123-4567");
    }

    @org.junit.Test
    public void getBuddyList() {
        AddressBook aBook = new AddressBook("Test");
        aBook.addBuddy(b1);
        assertEquals(aBook.getBuddyInfoList().size(), aBook.getSize());
    }

    @org.junit.Test
    public void addBuddy() {
        AddressBook aBook = new AddressBook("Test");
        aBook.addBuddy(b1);
        assertEquals(aBook.getSize(), 1);
        aBook.addBuddy(b2);
        assertEquals(aBook.getSize(), 2);
    }

    @org.junit.Test
    public void removeBuddy() {
        AddressBook aBook = new AddressBook("Test");
        aBook.addBuddy(b1);
        aBook.addBuddy(b2);
        aBook.removeBuddy(b1);
        assertEquals(aBook.getSize(), 1);
        aBook.removeBuddy(b2);
        assertEquals(aBook.getSize(), 0);
    }

    @org.junit.Test
    public void getSize() {
        AddressBook aBook = new AddressBook("Test");
        aBook.addBuddy(b1);
        assertEquals(aBook.getSize(), 1);
    }

    @org.junit.Test
    public void isEmpty() {
        AddressBook aBook = new AddressBook("Test");
        assertEquals(aBook.isEmpty(), true);
        aBook.addBuddy(b1);
        assertEquals(aBook.isEmpty(), false);
    }
}