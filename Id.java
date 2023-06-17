class Id {
	String identifier;
	
	void parse() {
		Parser.expectedToken(Core.ID);
		identifier = Parser.scanner.getId();
		Parser.scanner.nextToken();
	}
	
	void print() {
		System.out.print(identifier);
	}

	// called in DeclInteger.java
    public void executeInteger() {
		//TODO: Might be right?

		// allocate memory for the integer
		Memory.allocate(identifier, Core.INTEGER);
    }

	// called in DeclRecord.java
    public void executeRecord() {
		//TODO: Might be right?

		// allocate memory for the record
		Memory.allocate(identifier, Core.RECORD);
    }

	// called in Assign.java
	public void assignRecord(Id assignFrom) {

	}

	// called in Assign.java
    public void assignNew(int execute) {

    }

	// called in Assign.java
    public void assignIndExpr(Expr index, Expr expr) {

    }

	// called in Assign.java
    public void assignExpr(Expr expr) {

    }

	// called in Factor.java
	public int getIdVal() {
		int result = 0;
		
		return result;
	}

	public int getIdValArray(Expr index) {
		int result = 0;
		
		return result;
	}
}