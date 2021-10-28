import java.text.DecimalFormat;

public class CreditCalculator {
	
	private final double loanAmount;
	private final double percent;
	private final int month;
	
	public CreditCalculator(double loanAmount, double percent, int month) {
		this.loanAmount = loanAmount;
		this.percent = percent;
		this.month = month;
	}
	
	public double monthlyPayment() {
		double annuityRatio = (monthlyInterestRate() * Math.pow((1 + monthlyInterestRate()), month)) /
				(Math.pow((1 + monthlyInterestRate()), month) - 1);
		return formatDouble(loanAmount * annuityRatio);
	}
	
	public double totalLoanAmount() {
		
		return monthlyPayment() * month;
	}
	
	public double overpayment() {
		return formatDouble(totalLoanAmount() - loanAmount);
	}
	
	private double formatDouble(double value) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		String strRes = decimalFormat.format(value);
		String strRes2 = strRes.replace(",", ".");
		return Double.parseDouble(strRes2);
	}
	
	private double monthlyInterestRate() {
		return percent / 12 / 100;
	}
}
