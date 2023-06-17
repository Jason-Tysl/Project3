class Term {
	Factor factor;
	Term term;
	int option;
	
	void parse() {
		factor  = new Factor();
		factor.parse();
		if (Parser.scanner.currentToken() == Core.MULTIPLY) {
			option = 1;
		} else if (Parser.scanner.currentToken() == Core.DIVIDE) {
			option = 2;
		}
		if (option != 0) {
			Parser.scanner.nextToken();
			term = new Term();
			term.parse();
		}						
	}
	
	void print() {
		factor.print();
		if (option == 1) {
			System.out.print("*");
			term.print();
		} else if (option == 2) {
			System.out.print("/");
			term.print();
		}
	}

    public int execute() {
		int result = 0;

		if (option == 1) {
			result = factor.execute() * term.execute();
		} else if (option == 2) {
			int termExec = term.execute();
			if (termExec == 0) {
				System.out.println("ERROR: Divide by 0 attempted.");
				System.exit(0);
			}
			result = factor.execute() / termExec;
		} else {
			result = factor.execute();
		}
		
        return result;
    }
}