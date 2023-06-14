class Decl implements Stmt {
	DeclInteger declInt;
	DeclRecord declRec;
	
	public void parse() {
		if (Parser.scanner.currentToken() == Core.INTEGER) {
			declInt = new DeclInteger();
			declInt.parse();
		} else {
			declRec = new DeclRecord();
			declRec.parse();
		}
	}
	
	public void print(int indent) {
		if (declInt != null) {
			declInt.print(indent);
		} else {
			declRec.print(indent);
		}
	}
}