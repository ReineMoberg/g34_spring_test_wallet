package se.lexicon.dao.sequencer;

import java.util.UUID;

public class PlayerIdGenerator {

    private  static  String playerIdGenerator;

    public static String generateId(){
        playerIdGenerator = UUID.randomUUID().toString();
        return playerIdGenerator;
    }

    public static String getPlayerIdGenerator(){
        return playerIdGenerator;
    }
}
