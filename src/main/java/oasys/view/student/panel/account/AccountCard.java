package oasys.view.student.panel.account;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class AccountCard extends JPanel {
    private final CardLayout card = new CardLayout();
    private final Account account = new Account();
    private final MailBox mailBox = new MailBox();

    public AccountCard() {
        setLayout(card);
        add("account",account);
        add("mail",mailBox);
        card.show(this,"account");
        addListener();
    }

    private void addListener() {
        account.getMailBox().addActionListener(e -> card.show(this,"mail"));
        mailBox.getBack().addActionListener(e -> card.show(this,"account"));
    }
}
