package se.lexicon.service;

import se.lexicon.model.Player;

public interface WalletService {

    Player openAccount(Player player);

    Player deposit(int amount, String playerId);

    Player withdraw(int amount, String playerId);

    Player findPlayerByAccountId(int accountId);

    boolean activeAccountByAccountId(int accountId);


}
