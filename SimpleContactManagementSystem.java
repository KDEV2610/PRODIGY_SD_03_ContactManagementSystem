import java.util.*;

public class SimpleContactManagementSystem {

    //*******CONTACT CLASS********to store individual contact details.********
    class Contact {
        private String name;
        private String phone;
        private String email;

        // Constructor
        public Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        // Override toString to display contact details
        @Override
        public String toString() {
            return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
        }
    }

    // Using ArrayList to store contacts
    private ArrayList<Contact> contactList = new ArrayList<>();

    // Method to show the menu
    public void menu() {
        Scanner s = new Scanner(System.in);
        int input;

        // Do-while loop to display menu until user exits
        do {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contact");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice: ");

            // Taking input from user
            input = s.nextInt();
            s.nextLine(); // Clear the buffer

            // Switch cases for user choice
            switch (input) {
                case 1:
                    addContact(s);
                    break;
                case 2:
                    viewContact();
                    break;
                case 3:
                    editContact(s);
                    break;
                case 4:
                    deleteContact(s);
                    break;
                case 5:
                    System.out.println("Thank you for using Contact Management System! Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (input != 5);
        s.close();
    }

    // Method to add a contact
    private void addContact(Scanner s) {
        System.out.print("Enter Name: ");
        String name = s.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = s.nextLine();

        System.out.print("Enter Email: ");
        String email = s.nextLine();

        contactList.add(new Contact(name, phoneNumber, email));
        System.out.println("Contact added successfully!");
    }

    // Method to view all contacts
    private void viewContact() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("\nContact List:");
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println((i + 1) + ". " + contactList.get(i));
            }
        }
    }

    // Method to edit a contact
    private void editContact(Scanner s) {
        viewContact();  // Display the contact list
        if (contactList.isEmpty()) return;  // Return if no contacts are available

        System.out.print("Enter the contact number to edit: ");
        int index = -1;

        // Validate if input is a valid number (integer)
        if (s.hasNextInt()) {
            index = s.nextInt() - 1; // Zero-based index
            s.nextLine(); // Clear the buffer
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
            s.nextLine(); // Clear the invalid input
            return;  // Exit if input is invalid
        }

        // If the index is valid, allow the user to edit the contact
        if (index >= 0 && index < contactList.size()) {
            Contact contact = contactList.get(index);  // Get the contact to edit

            // Ask user for new details, leaving them blank to keep the old value
            System.out.print("Enter new Name (leave blank to keep \"" + contact.getName() + "\"): ");
            String name = s.nextLine();
            if (!name.isEmpty()) contact.setName(name);  // Update if new name is provided

            System.out.print("Enter new Phone (leave blank to keep \"" + contact.getPhone() + "\"): ");
            String phone = s.nextLine();
            if (!phone.isEmpty()) contact.setPhone(phone);  // Update if new phone is provided

            System.out.print("Enter new Email (leave blank to keep \"" + contact.getEmail() + "\"): ");
            String email = s.nextLine();
            if (!email.isEmpty()) contact.setEmail(email);  // Update if new email is provided

            System.out.println("Contact updated successfully!");  // Confirmation message
        } else {
            System.out.println("Invalid contact number.");  // Error message if index is out of bounds
        }
    }


    // Method to delete a contact
    private void deleteContact(Scanner s) {
        viewContact();
        if (contactList.isEmpty()) return;

        System.out.print("Enter the contact number to delete: ");
        int index = s.nextInt() - 1;

        if (index >= 0 && index < contactList.size()) {
            contactList.remove(index);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    // Main method
    public static void main(String[] args) {
        SimpleContactManagementSystem scms = new SimpleContactManagementSystem();
        scms.menu();
    }
}
