package ru.stqa.pdt.addressbook.model;

public class ContactData {
  private  final String id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String company;
  private final String address;
  private final String phone;
  private final String email;
  private final String title;
  private String group;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public String getId() {
    return id;
  }

  public ContactData(String firstname, String middlename, String lastname, String company, String address, String phone, String email, String title, String group) {
    this.id = null;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.company = company;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.title = title;
    this.group = group;
  }

  public ContactData(String id, String firstname, String middlename, String lastname, String company, String address, String phone, String email, String title, String group) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.company = company;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.title = title;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getTitle() {
    return title;
  }

  public String getGroup() {
    return group;
  }

}
