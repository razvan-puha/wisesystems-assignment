package co.wisesystems.demo.service1.repository;

import co.wisesystems.demo.service1.entity.BankAccount;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends ListCrudRepository<BankAccount, Integer> {

}