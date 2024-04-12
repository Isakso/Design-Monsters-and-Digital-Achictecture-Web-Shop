package BusinessObjects;

public class Customer { // customer class and its properties
    private int id;
    private String name;
    private String Address;
    private String Email;
    public Customer(){
    }
    public void setId(int id) {
        this.id= id;
    }
    public int getId() {
        return id;
    }
    public void setName(String name){
      this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getEmail() {
        return Email;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
}



