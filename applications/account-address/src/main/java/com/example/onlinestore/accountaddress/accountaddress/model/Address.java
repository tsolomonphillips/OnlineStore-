package com.example.onlinestore.accountaddress.accountaddress.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long addressId;

    private String street;
    private String aptBuilding;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    public Address()
    {

    }

    public Address(Long addressId, String street, String aptBuilding, String city,
                   String state, String zipCode, String country, Account account)
    {
        this.addressId = addressId;
        this.street = street;
        this.aptBuilding = aptBuilding;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.account = account;
    }

    public Long getAddressId()
    {
        return addressId;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getAptBuilding()
    {
        return aptBuilding;
    }

    public void setAptBuilding(String aptBuilding)
    {
        this.aptBuilding = aptBuilding;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public void setAddressId(Long addressId)
    {
        this.addressId = addressId;
    }

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }
}
