package collections.assign5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import collections.BankAccount;

/**
 * This program demonstrates HashMap
 */

public class AccountHashMap {
	public static void main(String[] args) {
		// Create a HashMap to store Account objects.
		Map<String, BankAccount> accountMap = new HashMap<String, BankAccount>();

		// Create some account objects
		BankAccount johnAccount = new BankAccount(1000);
		BankAccount sallyAccount = new BankAccount(3000);
		BankAccount peterAccount = new BankAccount(3000);
		BankAccount bobAccount = new BankAccount(3000);
		BankAccount jillAccount = new BankAccount(3000);
		BankAccount fredAccount = new BankAccount(3000);

		// Put some mappings into the HashMap. In each mapping,
		// account number is the key and bankaccount object is the value
		accountMap.put("101", johnAccount);
		accountMap.put("102", sallyAccount);
		accountMap.put("103", peterAccount);
		accountMap.put("104", bobAccount);
		accountMap.put("105", jillAccount);
		accountMap.put("106", fredAccount);

		displayAccountsWithEqualBalances(accountMap);
	}

	public static void displayAccountsWithEqualBalances(Map<String, BankAccount> accountMap) {
		Map<Double, String> duplicateBalances = new HashMap<Double, String>();
		for (Map.Entry<String, BankAccount> temp : accountMap.entrySet()) {
			if (!duplicateBalances.containsKey(temp.getValue().getBalance()))
				duplicateBalances.put(temp.getValue().getBalance(), temp.getKey());
			else
				duplicateBalances.replace(temp.getValue().getBalance(),
						duplicateBalances.get(temp.getValue().getBalance()) + ", " + temp.getKey());
		}
		for (Map.Entry<Double, String> temp : duplicateBalances.entrySet())
			if (!(temp.getValue().length() == 3))
				System.out.println("Account numbers " + temp.getValue() + " have an equal balance of " + temp.getKey());
	}
}