class Factor {
	Id id;
	Expr index;
	int constant;
	Expr expr;
	Boolean input;
	
	void parse() {
		if (Parser.scanner.currentToken() == Core.ID) {
			id = new Id();
			id.parse();
			if (Parser.scanner.currentToken() == Core.LBRACE) {
				Parser.scanner.nextToken();
				index = new Expr();
				index.parse();
				Parser.expectedToken(Core.RBRACE);
				Parser.scanner.nextToken();
				
			}
		} else if (Parser.scanner.currentToken() == Core.CONST) {
			constant = Parser.scanner.getConst();
			Parser.scanner.nextToken();
		} else if (Parser.scanner.currentToken() == Core.LPAREN) {
			Parser.scanner.nextToken();
			expr = new Expr();
			expr.parse();
			Parser.expectedToken(Core.RPAREN);
			Parser.scanner.nextToken();
		} else if(Parser.scanner.currentToken() == Core.IN) {
			Parser.scanner.nextToken();
			Parser.expectedToken(Core.LPAREN);
			Parser.scanner.nextToken();
			Parser.expectedToken(Core.RPAREN);
			Parser.scanner.nextToken();
			input = true;
		} else {
			System.out.println("ERROR: Expected ID, CONST, LPAREN, or IN, recieved " + Parser.scanner.currentToken());
			System.exit(0);
		}
	}
	
	void print() {
		if (id != null) {
			id.print();
			if (index != null) {
				System.out.print("[");
				index.print();
				System.out.print("]");
			}
		} else if (expr != null) {
			System.out.print("(");
			expr.print();
			System.out.print(")");
		} else if (input != null) {
			System.out.print("in()");
		} else {
			System.out.print(constant);
		}
	}

	public int execute() {
		//TODO: Might be right?
		int result = 0;
		if (id != null) {
			// if it's an array, get array, otherwise use base
			if (index != null) {
				result = id.getIdValArray(index.execute());
			} else {
				result = id.getIdVal();
			}
		} else if (expr != null) {
			result = expr.execute();
		} else if (input != null) {
			result = Executor.readIn();
		} else {
			result = constant;
		}
		
		return result;
	}
}