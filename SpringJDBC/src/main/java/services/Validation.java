package services;

import org.springframework.stereotype.Component;

public interface Validation {

	void CreateAcc();

	void CheckBal();

	void Deposit();

	void Withdraw();

	void Transfer();

}
