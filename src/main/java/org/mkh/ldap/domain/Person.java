package org.mkh.ldap.domain;

import org.springframework.ldap.odm.annotations.*;

import javax.naming.Name;
import java.io.Serializable;

@Entry(objectClasses = {"person", "top"}, base = "CN=Users,DC=PDKF,DC=ir")
public class Person implements Serializable {

    @Id
    private Name dn;

    @Attribute(name = "cn")
    @DnAttribute(value = "cn", index = 1)
    private String fullName;

    @Attribute(name = "name")
    private String name;

    @Attribute(name = "givenName")
    private String givenName;


    // No @Attribute annotation means this is bound to the LDAP attribute
    // with the same value
//   private String firstName;

    @DnAttribute(value = "ou", index = 0)
    @Transient
    private String company;

    @Transient
    private String someUnmappedField;
    // ...more attributes below


    public Name getDn() {
        return dn;
    }

    public void setDn(Name dn) {
        this.dn = dn;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSomeUnmappedField() {
        return someUnmappedField;
    }

    public void setSomeUnmappedField(String someUnmappedField) {
        this.someUnmappedField = someUnmappedField;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @Override
    public String toString() {
        String person = "personId: " + getDn()
                + " name: " + getName()
                + " givenName: " + getGivenName()
                + " fullname: " + getFullName()
                + " company: " + getCompany();
        return person;
    }
}