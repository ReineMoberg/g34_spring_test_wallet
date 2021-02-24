package se.lexicon.dao.sequencer;

public class AccountSequencer {

    private static int accountSequencer;

    public static int nextId() {
        return ++accountSequencer;
    }

    public static int getAccountSequencer(){
        return accountSequencer;
    }

}
