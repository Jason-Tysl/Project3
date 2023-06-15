class Expr {
	Term term;
	Expr expr;
	int option;
	
	void parse() {
		term  = new Term();
		term.parse();
		if (Parser.scanner.currentToken() == Core.ADD) {
			option = 1;
		} else if (Parser.scanner.currentToken() == Core.SUBTRACT) {
			option = 2;
		}
		if (option != 0) {
			Parser.scanner.nextToken();
			expr = new Expr();
			expr.parse();
		}						
	}
	
	void print() {
		term.print();
		if (option == 1) {
			System.out.print("+");
			expr.print();
		} else if (option == 2) {
			System.out.print("-");
			expr.print();
		}
	}

    public int execute() {
		int result = 0;

		if (option == 1) {
			result = term.execute() + expr.execute();
		} else if (option == 2) {
			result = term.execute() - expr.execute();
		} else {
			result = term.execute();
		}
		
		return result;
    }
}