package se.lexicon.dao;

import org.springframework.stereotype.Component;
import se.lexicon.dao.sequencer.PlayerIdGenerator;
import se.lexicon.model.Player;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component("playerDao")
public class PlayerDaoImpl implements PlayerDao {

    private Set<Player> players = new HashSet<>();

    @Override
    public Player add(Player player) {
        if (player.getId() == null) {
            player.setId(PlayerIdGenerator.generateId());
            players.add(player);
        }
        return player;
    }

    @Override
    public boolean delete(int playerId) {
        return false;
    }

    @Override
    public Player update(Player player) {
        return null;
    }

    @Override
    public Optional<Player> find(String id) {
        if (id == null) throw new IllegalArgumentException("id is not valid");
        return players.stream().filter(player -> player.getId().equalsIgnoreCase(id)).findFirst();
    }

    @Override
    public Optional<Player> findByAccountId(int accountId) {
        return  players.stream().filter(player -> player.getAccount().getId() == accountId).findFirst();
    }

    @Override
    public Set<Player> getAll() {
        return players;
    }
}
