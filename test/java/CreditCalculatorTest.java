import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCalculatorTest {
	
	double loanAmount = 150_000;
	double percent = 19.5;
	int month = 12;
	CreditCalculator creditCalculator = new CreditCalculator(loanAmount, percent, month);
	
	@Test
	public void CalculationOfMonthlyPaymentTest() {
		double expected = 13_859.31;
		double result = creditCalculator.monthlyPayment();
		assertEquals(expected, result);
	}
	
	@Test
	public void CalculationOfTheTotalAmountToBeReturnedToTheBankTest() {
		double expected = 166_311.72;
		double result = creditCalculator.totalLoanAmount();
		assertEquals(expected, result);
	}
	
	@Test
	public void OverpaymentCalculationTest() {
		double expected = 16_311.72;
		double result = creditCalculator.overpayment();
		assertEquals(expected, result);
	}
}
