package ru.stqa.pdt.addressbook;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String company;
  private final String address;
  private final String phone;
  private final String email;
  private final String title;

  public ContactData(String firstname, String middlename, String lastname, String company, String address, String phone, String email, String title) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.company = company;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.title = title;
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
}
