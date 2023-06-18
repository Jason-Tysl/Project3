Name: Jason Tysl

This is the readme for CSE 3341 Project 3, the Core Language executor.

Files: 
    The only new files are CoreType, Executor, and Memory. The rest are taken from the "Perfect Project 2"
    on Carmen. The rest of the files were added to, implementing something similar to the print method but
    an execute method. The main change is to the Id.java file which had lots of different functions because
    it was called from multiple other files not just one like most of them.

Assign.java - this file contains the parsing and executing for the three different productions of <assign>. 
    It also contains two semantic error checks that check if the id has been declared and if it
    is a record id when needed.

Cmpr.java - this file contains the parsing and executing for the three different productions of <cmpr>.

Cond.java - this file contains the parsing and executing for the three different productions of <cond>.

Core.java - this file contains the Core enum that is used to check if we're accessing the correct token.

CoreType.java - this file is a pseudo map that initiales integers to 0 and records to null.
    This space is also used to determine what types are stored where and gain access to them easier.

Decl.java - this file contains the parsing and executing for the two different productions of <decl>.

DeclInteger.java - this file contains the parsing and executing for the <decl-integer> production. It stores
    the id into the map to be checked later. It also checks for doubly declaring.

DeclRecord.java - this file contains the parsing and executing for the <decl-record> production. It stores
    the id into the map to be checked later. It also checks for doubly declaring.

DeclSeq.java - this file contains the parsing and executing for the two different productions of <decl-seq>.

Executor.java - this file contains the scanner that is used for input of data as well as the initialize function
    which initializes the memory spaces.

Expr.java - this file contains the parsing and executing for the three different productions of <expr>.

Factor.java - this file contains the parsing and executing for the five different productions of <factor>.
    It is the last production.

If.java - this file contains the parsing and executing for the two different productions of <if>.

Id.java - this file contains the parsing and executing for the two different productions of <index>.

Loop.java - this file contains the parsing and executing for the <loop>.

Main.java - this file creates two scanners which get used by the parser which parses the input file.
    The second scanner is used by the executor to execute the parsed data.

Memory.java - this file contains the memory map, stack of maps, and array that get used by the executor
    functions.

Out.java - this file contains the parsing and executing for the <out>.

Parser.java - the parser of the input file.

Procedure.java - this file contains the parsing and executing for the two productions of <procedure>.

README.txt - this file contains the creator's name and information about how the entire parser program works.

Scanner.java - this file contains the scanner that was taken from the "PerfectProject1.zip" from carmen. It
    scans and tokenizes all of the words from an input file.

Stmt.java - this file contains the parsing and executing for the five different productions of <stmt>.

StmtSeq.java - this file contains the parsing and executing for the two different productions of <stmt-seq>.
 
Term.java - this file contains the parsing and executing for the three different productions of <term>.

Special Features: N/A

Overall design: For most of the execute functions in each of the classes,
it is almost fully copied from the print function. Realistically it's the
same, except we don't have to worry about indents nor printing discarded 
tokens. The pattern is followed almost fully until we get to the end with
the ID's which is where a majority of the new work is done. The three
different memory spaces are globalMemory, localMemory, and heapMemory.
These separate spaces are used depending on where the variable is initialized
and specifically the heap is used for the record integer arrays. Space is 
allocated as each record is initialized, with the initial value being the 
first space, and the remainder of the array taking up the following spaces.
If a new array is declared, it is stacked on to the end of the array.
This array is accessed as needed, and the pointers to the array (index values)
are stored in global and local memory. It allows for multiple variable to 
"point" to the same space in the array, allowing you to change multiple variables
with only one line. Also, when looking for a variable, it checks the local space
first, and then if it's null, it looks through the globalMemory.

Testing & Bugs: I'm already turning this in a day late, so I didn't have time to 
fully test everything, but from what I can tell there are no bugs. Like I said,
most of the implementation was copied from Tim Carpenter's "Perfect Project 2" 
available on Carmen. One thing I'm not entirely sure is valid is the subtraction
order of operations but I wouldn't know how to fix that if it doesn't work.

