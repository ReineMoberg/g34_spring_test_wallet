package se.lexicon.dao;

import org.springframework.stereotype.Component;
import se.lexicon.dao.sequencer.AccountSequencer;
import se.lexicon.model.Account;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Component("accountDao")
public class AccountDaoImp implements AccountDao {

    private Set<Account> accounts = new HashSet<>();

    @Override
    public Account add(Account account) {
        if (account.getId() == 0) {
            account.setId(AccountSequencer.nextId());
            accounts.add(account);
        } else {
            throw new IllegalArgumentException("account id should be 0");
        }
        return account;
    }

    @Override
    public Optional<Account> find(int id) {
        if (id == 0){
            throw new IllegalArgumentException("account id is not valid");
        }
       Optional<Account> result = accounts.stream().filter(account -> account.getId() == id).findFirst();
        return result;
    }

    @Override
    public boolean delete(int id) {
       return accounts.removeIf(account -> account.getId() == id);
    }

    @Override
    public Account update(Account account) {
        if (account == null) throw new IllegalArgumentException("account is null");
        Optional<Account> original = find(account.getId());
        if (original.isPresent()){
            Account acc= original.get();
            acc.setAccountType(account.getAccountType());
            return acc;
        }
        return null;
    }

    @Override
    public Account activeAccount(int accountId) {
        Account account= find(accountId).orElseThrow(IllegalAccessError::new);
        account.setStatus(true);
        return account;
    }
}
