package se.lexicon.dao;

import se.lexicon.model.Account;

import java.util.Optional;

public interface AccountDao {

    Account add(Account account);

    Optional<Account> find(int id);

    boolean delete(int id);

    Account update(Account account);

    Account activeAccount(int accountId);
}
