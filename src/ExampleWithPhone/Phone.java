package ExampleWithPhone;

public class Phone {
    private int id;
    private String ownerPhone;
    private String PhoneNumber;

    public Phone(int id, String ownerPhone, String phoneNumber) {
        this.id = id;
        this.ownerPhone = ownerPhone;
        PhoneNumber = phoneNumber;
    }

    public Phone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
