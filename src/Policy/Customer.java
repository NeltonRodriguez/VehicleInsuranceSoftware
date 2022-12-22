package Policy;

import java.io.Serializable;

public class Customer implements Serializable {
    String firstName, lastName, city;
    int customerPhone;
    Policy policy;

    // Empty constructor


    public Customer() {
    }

    // Parametrized constructor

    public Customer(String firstName, String lastName, String city, int customerPhone, Policy policy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.customerPhone = customerPhone;
        this.policy = policy;
    }

    // Getters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public Policy getPolicy() {
        return policy;
    }

    // toString

    @Override
    public String toString() {
        return "First Name: " + firstName + '\n' +
                "Last Name: " + lastName + '\n' +
                "City: " + city + '\n' +
                "Customer Phone Number: " + customerPhone + '\n' +
                "" + policy;
    }
}
