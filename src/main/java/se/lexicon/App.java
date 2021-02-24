package se.lexicon;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.model.Account;
import se.lexicon.model.AccountType;
import se.lexicon.model.Player;
import se.lexicon.service.WalletService;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        WalletService walletService = context.getBean("walletService", WalletService.class);

        Account playerTestAccount = new Account(AccountType.ACC_TEST, 0);
        Player testPlayer = new Player("Test", "test.test@test.se", "0123456", playerTestAccount);
        Player createdPlayer = walletService.openAccount(testPlayer);
        System.out.println("createdPlayer = " + createdPlayer);
        System.out.println("-------------------------------------");

        walletService.activeAccountByAccountId(createdPlayer.getAccount().getId());

        Player depositTestPlayer = walletService.deposit(100, createdPlayer.getId());
        System.out.println("depositTestPlayer = " + depositTestPlayer);

    }
}
