package org.mkh.ldap.dao;

import org.mkh.ldap.domain.Person;
import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends LdapRepository<Person> {
}
