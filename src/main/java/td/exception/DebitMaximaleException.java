package td.exception;

public class DebitMaximaleException extends RuntimeException {

	public DebitMaximaleException() {
		super("le montant depasse le debit maximale");
	}
	
}
