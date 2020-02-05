package addressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;

@Controller
public class AddressBookController {
    @Autowired
    AddressBookRepository addressBookRepository;

    @Autowired
    BuddyRepository buddyBookRepository;
    private final AtomicInteger counter = new AtomicInteger();

    @GetMapping("/addressbook")
    public String addressbook(@RequestParam(name="name", required=false, defaultValue="Address Books") String name, Model model) {
        model.addAttribute("name", name);
        return "addressbook";
    }

    @GetMapping("/addressbook/buddies")
    public String getBuddies(@RequestParam(name="name", defaultValue="Address Book") String name, Model model) {
        List buddies = new ArrayList<BuddyInfo>();
        AddressBook a1 = addressBookRepository.findByName(name).get(0);
        buddies = a1.getBuddyInfoList();
        model.addAttribute("buddies", buddies);
        return "newaddressbook";
    }

    @GetMapping("/newaddressbook")
    public AddressBook newaddressbook(@RequestParam(value="name", defaultValue="addressBook") String name) {
        return new AddressBook(counter.incrementAndGet(), name);
    }

    /*@PutMapping("/adddressbook")
    public AddressBook addressbook(@RequestParam(value="id", defaultValue="addressBook") String name)*/
}
