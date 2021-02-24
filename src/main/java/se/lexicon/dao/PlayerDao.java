package se.lexicon.dao;

import se.lexicon.model.Player;

import java.util.Optional;
import java.util.Set;

public interface PlayerDao {

    Player add(Player player);

    boolean delete(int playerId);

    Player update(Player player);

    Optional<Player> find(String id);

    Optional<Player> findByAccountId(int accountId);

    Set<Player> getAll();


}
