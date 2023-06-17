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
		CoreType coreType = Memory.findCoreTypeFromId(identifier);
		// add heap space for new record variable
		Memory.heapMemory.add(null);
		// set value of reference to the size of the heap
		coreType.value = Memory.heapMemory.size();
    }

	// called in Assign.java (id[<expr>] := <expr> assignment)
    public void assignIndExpr(int indVal, int exprVal) {

    }

	// called in Assign.java (id := <expr> assignment)
    public void assignExpr(int exprVal) {
		CoreType coreType = Memory.findCoreTypeFromId(identifier);
		
		// if the id is an int, simply set the value of the id to the new exprVal
		if (coreType.type == Core.INTEGER) {
			coreType.value = exprVal;
		} else if (coreType.type == Core.RECORD) {
			// check that you don't go out of bounds
			if (coreType.value > Memory.heapMemory.size()) {
				// use set to replace the null value that you initialized earlier
				Memory.heapMemory.set(coreType.value, exprVal);
			}
		}
    }

	// called in Factor.java
	public int getIdVal() {
		int result = 0;
		
		return result;
	}

	// called in Factor.java
	public int getIdValArray(Expr index) {
		int result = 0;
		
		return result;
	}
}