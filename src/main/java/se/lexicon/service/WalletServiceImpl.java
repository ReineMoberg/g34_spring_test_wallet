package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.PlayerDao;
import se.lexicon.model.Account;
import se.lexicon.model.Player;

import java.util.Optional;

@Component("walletService")
public class WalletServiceImpl implements WalletService {

    private PlayerDao playerDao;
    private AccountDao accountDao;

    @Autowired
    public void setPlayerDao(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Player openAccount(Player player) {
        if (player == null) throw new IllegalArgumentException("player is null");
        if (player.getAccount() == null) throw new IllegalArgumentException("account is null");
        Account createdAccount = accountDao.add(player.getAccount());

        Player createdPlayer = playerDao.add(player);
        createdPlayer.setAccount(createdAccount);
        return createdPlayer;
    }

    @Override
    public Player deposit(int amount, String playerId) {
        if (playerId == null) throw new IllegalArgumentException("playerId is null");
        if(amount <= 0) throw new IllegalArgumentException("amount is not valid");
        Optional<Player> searchPlayer =playerDao.find(playerId);
        if (!searchPlayer.isPresent()) throw new IllegalArgumentException("player is not valid");
        if (!searchPlayer.get().getAccount().isStatus()) throw  new IllegalArgumentException("player account is not active");
        Player result = searchPlayer.get();
        Account account= result.getAccount();
        account.setBalance(amount+account.getBalance());
        result.setAccount(account);
        return result;
    }

    @Override
    public Player withdraw(int amount, String playerId) {
        return null;
    }

    @Override
    public Player findPlayerByAccountId(int accountId) {
        return null;
    }

    @Override
    public boolean activeAccountByAccountId(int accountId) {
        if (accountId == 0) throw new IllegalArgumentException("account ins not valid");
        accountDao.activeAccount(accountId);
        return true;
    }
}
