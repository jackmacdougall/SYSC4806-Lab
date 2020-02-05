package addressbook;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id = null;
    private String name = null;

    @OneToMany
    private List<BuddyInfo> buddyInfoList = new ArrayList<BuddyInfo>();

    public AddressBook() {}

    public AddressBook(String name){
        this.name = name;
        this.buddyInfoList = new ArrayList<BuddyInfo>();
    }

    public AddressBook(Integer id, String name){
        this.id = id;
        this.name = name;
        this.buddyInfoList = new ArrayList<BuddyInfo>();
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }


    public List<BuddyInfo> getBuddyInfoList(){ return this.buddyInfoList; }

    public void setBuddyInfoList(List<BuddyInfo> buddyInfoList) { this.buddyInfoList = buddyInfoList; }

    public void addBuddy(BuddyInfo b) { this.buddyInfoList.add(b); }

    public void removeBuddy(BuddyInfo b) {
        this.buddyInfoList.remove(b);
    }

    public int getSize() {
        return this.buddyInfoList.size();
    }

    public boolean isEmpty() {
        return this.buddyInfoList.isEmpty();
    }

    @Override
    public int hashCode() {
        final int prime = 29;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((buddyInfoList == null) ? 0 : buddyInfoList.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AddressBook other = (AddressBook) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (buddyInfoList == null) {
            if (other.buddyInfoList != null)
                return false;
        } else if (!buddyInfoList.equals(other.buddyInfoList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String buddyInfoListString = "{";
        for (int i = 0; i < buddyInfoList.size(); i++){
            if (i < buddyInfoList.size() - 1 ) {
                buddyInfoListString += buddyInfoList.get(i) + ", ";
            }
            else {
                buddyInfoListString += buddyInfoList.get(i) + "}";
            }
        }

        return "addressbook.AddressBook [id=" + id + ", name=" + name + ", buddyInfoList=" + buddyInfoListString + "]";
    }

    public static void main(String[] args) {

    }

}
