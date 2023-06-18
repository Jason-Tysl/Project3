class Cond {
	Cmpr cmpr;
	Cond cond;
	int option;
	
	void parse() {
		option = 0;
		if (Parser.scanner.currentToken() == Core.NOT){
			option = 1;
			Parser.scanner.nextToken();
			cond = new Cond();
			cond.parse();
		} else {
			cmpr = new Cmpr();
			cmpr.parse();
			if (Parser.scanner.currentToken() == Core.OR) {
				option = 2;
				Parser.scanner.nextToken();
				cond = new Cond();
				cond.parse();
			} else if (Parser.scanner.currentToken() == Core.AND) {
				option = 3;
				Parser.scanner.nextToken();
				cond = new Cond();
				cond.parse();
			}
		}
	}
	
	void print() {
		if (cmpr == null) {
			System.out.print("not ");
			cond.print();
		} else {
			cmpr.print();
			if (cond != null) {
				if (option == 2) System.out.print(" or ");
				if (option == 3) System.out.print(" and "); //changed option == 2 to option == 3
				cond.print();
			}
		}
	}

    public boolean execute() {
		boolean result = false;
		if (cmpr == null) {
			result = !cond.execute();
		} else {
			result = cmpr.execute();
			if (cond != null) {
				if (option == 2) {
					result = cmpr.execute() || cond.execute();
				} else if (option == 3) {
					result = cmpr.execute() && cond.execute();
				}
			}
		}
		
        return result;
    }
}