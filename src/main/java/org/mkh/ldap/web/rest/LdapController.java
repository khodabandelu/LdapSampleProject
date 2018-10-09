package org.mkh.ldap.web.rest;

import org.mkh.ldap.dao.PersonRepository;
import org.mkh.ldap.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LdapController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/getFirst")
    public String getFirst() {
        Iterable<Person> source = personRepository.findAll();
        List<Person> target = new ArrayList<>();
        source.forEach(target::add);
       return target.get(0).toString();
    }

}
