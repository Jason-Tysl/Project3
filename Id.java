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

	String IdToString() {
		return identifier;
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
	public void assignRecord(Id recordId) {
		// TODO: Might be right?

		// get coreTypes of both the left id and right id
		CoreType coreTypeIdentifier = Memory.findCoreTypeFromId(identifier);
		CoreType coreTypeRecId = Memory.findCoreTypeFromId(recordId.IdToString());
		// assign the right's value to the left's
		coreTypeIdentifier.value = coreTypeRecId.value;
	}

	// called in Assign.java
    public void assignNew(int arraySize) {
		// TODO: Might be right?

		CoreType coreType = Memory.findCoreTypeFromId(identifier);
		// add heap space for new record variable
		Memory.heapMemory.add(null);
		// set value of reference to the size of the heap
		coreType.value = Memory.heapMemory.size() - 1;

		// add remaining space for array (if it's 1, loop won't go because it already added the one space)
		for (int i = 0; i < arraySize - 1; i++) {
			Memory.heapMemory.add(null);
		}
    }

	// called in Assign.java (id[<expr>] := <expr> assignment)
    public void assignIndExpr(int indVal, int exprVal) {
		// TODO: Might be right?

		CoreType coreType = Memory.findCoreTypeFromId(identifier);

		// verify that it's a record
		if (coreType.type == Core.RECORD) {
			// get index in heap
			int heapIndex = coreType.value + indVal;
			// check bounds
			if (heapIndex < Memory.heapMemory.size()) {
				// set to replace null/existing values in heap
				Memory.heapMemory.set(heapIndex, exprVal);
			} else {
				System.out.println("ERROR: attemped accessing " + identifier + "[" + indVal + "]. Out of bounds.");
				System.exit(0);
			}
		} else {
			System.out.println("ERROR: Treating Integer as array (record).");
			System.exit(0);
		}
    }

	// called in Assign.java (id := <expr> assignment)
    public void assignExpr(int exprVal) {
		// TODO: Might be right?

		CoreType coreType = Memory.findCoreTypeFromId(identifier);
		
		// if the id is an int, simply set the value of the id to the new exprVal
		if (coreType.type == Core.INTEGER) {
			coreType.value = exprVal;
		} else if (coreType.type == Core.RECORD) {

			// check that you don't go out of bounds
			if (coreType.value < Memory.heapMemory.size()) {
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