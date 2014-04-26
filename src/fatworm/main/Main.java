package fatworm.main;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;

import java.io.*;

import fatworm.util.*;
import fatworm.parser.*;
import fatworm.logicplan.*;

public class Main{
	
	void main() {
	}
	
	public static void main(String[] args) throws Exception {
		String input = "";
		File file = new File("input.txt");
		Reader reader = new InputStreamReader(new FileInputStream(file));
		int tempchar;
		while ((tempchar = reader.read()) != -1) {
            if (((char) tempchar) != '\n') {
                input += ((char) tempchar);
            } else input += " ";
        }
        reader.close();
		
		parse(input);
	}
	
	private static void parse(String sql) throws Exception {
		FatwormLexer lexer = new FatwormLexer(new ANTLRStringStream(sql));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FatwormParser parser = new FatwormParser(tokens);
		FatwormParser.statement_return rs = parser.statement();
		CommonTree t = (CommonTree) rs.getTree();
		System.out.println(t.toStringTree());

		System.out.println("\n==========parsetree===========");
		String temptree = t.toStringTree();
		parseprinter pp = new parseprinter(temptree);
		System.out.println(pp.tostring());
		
		System.out.println("\n==========plan tree===========");
		Project p = new Project(t);
		System.out.println(p.tostring(0));
	}
}
