package co.wisesystems.demo.service1.service;

import co.wisesystems.demo.service1.client.PersonClient;
import co.wisesystems.demo.service1.dto.BankAccountDto;
import co.wisesystems.demo.service1.dto.PersonDto;
import co.wisesystems.demo.service1.dto.PersonRequestBody;
import co.wisesystems.demo.service1.entity.BankAccount;
import co.wisesystems.demo.service1.exception.ResourceCreatedException;
import co.wisesystems.demo.service1.exception.TooManyResultsException;
import co.wisesystems.demo.service1.repository.BankAccountRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BankAccountService {

    BankAccountRepository bankAccountRepository;
    PersonClient personClient;

    public List<BankAccountDto> getBankAccounts() {
        return bankAccountRepository.findAll().stream()
            .map(bankAccount -> {
                PersonDto person = personClient.getPersonById(bankAccount.getPersonId());
                return BankAccountDto.of(
                    bankAccount.getId(),
                    bankAccount.getCreatedOn(),
                    person.getName(),
                    person.getPersonalCode(),
                    person.getEmail()
                );
            })
            .toList();
    }

    public void createBankAccount(PersonRequestBody requestBody) {
        List<PersonDto> persons = personClient.getPersonsBy(requestBody.getName(), requestBody.getPersonalCode(), requestBody.getEmail());
        if (persons.size() != 1) {
            throw new TooManyResultsException("The search returned too many results! Please provide details to identify only a single person!");
        }

        BankAccount bankAccount = new BankAccount();
        bankAccount.setPersonId(persons.get(0).getId());
        bankAccount.setCreatedOn(LocalDateTime.now());

        bankAccountRepository.save(bankAccount);
        throw new ResourceCreatedException("The bank account was created successfully!");
    }
}