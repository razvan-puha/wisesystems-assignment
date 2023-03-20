package co.wisesystems.demo.service1.controller;

import co.wisesystems.demo.service1.dto.BankAccountDto;
import co.wisesystems.demo.service1.dto.PersonRequestBody;
import co.wisesystems.demo.service1.service.BankAccountService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank_accounts")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BankAccountController {

    BankAccountService bankAccountService;

    @GetMapping
    public List<BankAccountDto> getBankAccounts() {
        return bankAccountService.getBankAccounts();
    }

    @PostMapping
    public void createBankAccount(@RequestBody PersonRequestBody requestBody) {
        bankAccountService.createBankAccount(requestBody);
    }
}