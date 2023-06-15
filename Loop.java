import java.util.*;

class Loop implements Stmt {
	Cond cond;
	StmtSeq ss;
	
	public void parse() {
		Parser.scanner.nextToken();
		cond = new Cond();;
		cond.parse();
		Parser.expectedToken(Core.DO);
		Parser.scanner.nextToken();
		ss = new StmtSeq();
		ss.parse();
		Parser.expectedToken(Core.END);
		Parser.scanner.nextToken();
	}
	
	public void print(int indent) {
		for (int i=0; i<indent; i++) {
			System.out.print("\t");
		}
		System.out.print("while ");
		cond.print();
		System.out.println(" do");
		ss.print(indent+1);
		for (int i=0; i<indent; i++) {
			System.out.print("\t");
		}
		System.out.println("end");
	}
	
	public void execute() {
		// loop while the real condition is true
		boolean realCondition = cond.execute();
		while (realCondition) {
			// create new local space to allow for the statement sequence
			Memory.localMemory.push(new HashMap<String, CoreType>());
			ss.execute();
			Memory.localMemory.pop();
		}
	}
}