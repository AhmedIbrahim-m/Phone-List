public class phoneBook{
  public static void main(String[] args) {
    PhoneList pl1 = new PhoneList();
    System.out.println("-----Add Contact------");
    pl1.addContact("Alice1", "123-456-7890");
    pl1.addContact("Alice2", "781-348-6754");
    pl1.addContact("Alice3", "426-172-4383");
    //------------------------------------------
    System.out.println("-----Display Contacts------");
    pl1.displayList();
    //-------------------------------------------
    System.out.println("-----Delete Contacts------");
    pl1.deleteContact("Alice1");
    pl1.deleteContact("Alice2");
    pl1.displayList();
    //---------------------------------------------
    System.out.println("-----Search Contact------");
    pl1.addContact("Alice1", "123-456-7890");
    pl1.addContact("Alice2", "781-348-6754");
    pl1.searchContact("Alice1");
  }
} 
class ContactNode {
  String phoneNumber;
  String name;
  ContactNode next;
  ContactNode(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.next = null;
  }
}
class PhoneList {
  ContactNode head;
  //since tail means that node.next == null, we will use that as our exiting condition
  PhoneList(){
    this.head = null;
  }
  // DELETE ------------------------------------------
  public void deleteContact(String name) {
    ContactNode current = head;
    // case 1: head is the target,
    if (head.name == name) {
      System.out.println("Contact deleted, Name: " + current.name + ", Phone: " + current.phoneNumber);
      head = head.next;
      return;
    }
    // case 2: loops with while as long as current node is NOT null
    // and checks for name, if not found, then it goes to the next node
      while (current != null) {
      if (current.next.name == name) {
        System.out.println("Contact deleted, Name: " + current.next.name + ", Phone: " + current.next.phoneNumber);
          // deletes node and exits
          current.next = current.next.next;
          return;
        }
        //steps into the next node
        current = current.next;
      }
    // if last node is null, then it has reached the tail and exists.
    System.out.println("Contact not found");
  }
  //SEARCH ------------------------------------------
  public void searchContact(String name) {
    ContactNode currentNode = head;
    // case 1: head is the target,
    if (head.name == name) {
      System.out.println("Contact found, Name: " + currentNode.name + ", Phone: " + currentNode.phoneNumber);
    }else {
    // case 2: loops with while, if name is found, exit and print, otherwise returns 
      while (currentNode.next.name != name) {
        currentNode.next  = currentNode.next.next;
        if (currentNode.next == null) {
          System.out.println("Contact not found.");
          return;
        }
      }
      System.out.println("Contact found, Name: " + currentNode.next.name + ", Phone: " + currentNode.next.phoneNumber);
    }
  }
  //DISPLAY ------------------------------------------
  public void displayList() {
    ContactNode currentNode = head;
    // case 1: if head is empty, exit
    if (head == null) {
      System.out.println("This phone list is empty.");
    } else {
      //loops until it reaches the last node (that is currentNodeNode == null)
      System.out.println("Current phone list:");
      while(currentNode != null) {
        System.out.println("Name:" + currentNode.name + ", Phone: " + currentNode.phoneNumber);
        currentNode = currentNode.next;
      }
    }
  }
  //ADD CONTACT ------------------------------------------
  public void addContact(String name, String phoneNumber) {
    ContactNode newContact = new ContactNode(name, phoneNumber);
    // if head is empty, add contact to it
    if (head == null) {
      head = newContact;
      System.out.println("Contact added: " + newContact.name + ", " + newContact.phoneNumber);
    }else {
      //loops til it reaches last node (curretNode == null)
      ContactNode currentNode = head;
      while (currentNode.next != null) {
        currentNode = currentNode.next;
      }
      currentNode.next = newContact; 
      System.out.println("Contact added: " + newContact.name + ", " + newContact.phoneNumber);
    }
  }
}
