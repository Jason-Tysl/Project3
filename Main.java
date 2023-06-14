class Main {
	public static void main(String[] args) {
		// Initialize two scanners: one for the parser (.code) and another for the executor (.data)
		Scanner parserScanner = new Scanner(args[0]);
		Scanner executorScanner = new Scanner(args[1]);
		
		// give the parser and executer their scanner
		Parser.scanner = parserScanner;
		Executor.scanner = executorScanner;
		
		Procedure procedure = new Procedure();
		
		procedure.parse();

		procedure.execute();
		
		// no need to print any more, leftover from parser
		// procedure.print();
	}
}