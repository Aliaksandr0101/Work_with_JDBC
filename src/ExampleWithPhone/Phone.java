package ExampleWithPhone;

public class Phone {
    private int id;
    private String ownerPhone;
    private String phoneNumber;

    public Phone(int id, String ownerPhone, String phoneNumber) {
        this.id = id;
        this.ownerPhone = ownerPhone;
        this.phoneNumber = phoneNumber;
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
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", ownerPhone='" + ownerPhone + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
