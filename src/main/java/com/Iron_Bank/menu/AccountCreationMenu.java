package com.Iron_Bank.menu;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.Iron_Bank.exception.NegativeNumberException;
import com.Iron_Bank.model.UserPaU;
import com.Iron_Bank.service.AccountServices;

public class AccountCreationMenu implements Menu {

	private static Logger log = Logger.getLogger(AccountCreationMenu.class);

	@Override
	public void display() {
		MainMenu mm = new MainMenu();
		UserPaU users = new UserPaU();
		AccountServices asrv = new AccountServices();
		double debt = 0.00;
		int element = 0;
		int value = 1;
		try {
			element = Integer.parseInt(sc.next());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		log.trace(element);
		do {
			log.info("Here are your options");
			log.info("");
			log.info("1.) Going back one menu option");
			log.info("2.) Allows you to add money to your account");

			log.info("3.) Allows you to look up your saving account id and checking account id");
			switch (element) {
			case 1:
				log.info("booting you back to the menu without adding money to your newly created account");
				mm.display();
			case 2:
				value = users.getUsers_id();
				int counter = 0;
				while (counter > 2) {
					String accountType = null;
					String accountchar = sc.next();
					log.info("please select from one of the folloing options");
					log.info("");
					log.info("S: Saving  account");
					log.info("C : Checking account");
					log.info("Cr : credit account");

					switch (accountchar) {
					case "S":
						log.info("Saving account");
						accountType = "Saving";
						break;
					case "C":
						log.info("Checking account");
						accountType = "Checking";
						break;
					case "Cr":
						log.info("credit account");
						accountType = "Credit";
						break;
					default:
						log.info("There are no other choices");
						accountType = "Saving";
					}
					log.info("adding money to your account");
					try {
						debt = Double.parseDouble(sc.next());
						debt=isnonNegative(debt);
					} catch (NegativeNumberException  | NumberFormatException e) {
						log.error("Your number is not a number but a letter", e);
					}
					log.info(debt);
					asrv.accountCreation(value, accountType, debt);
					counter++;
				}
				if (counter > 2) {
					return;
				} else {

				}
			case 3:
				log.info("Your id of the account based on the Username");
			}
			value++;
		} while (element != 1);
	}

	public Double isnonNegative(double debt) throws NegativeNumberException {

		if (debt > 0.0) {
			throw new NegativeNumberException();
		} else {
			;
		}
		return debt;

	}

}
