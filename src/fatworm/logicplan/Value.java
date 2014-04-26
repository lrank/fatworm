package fatworm.logicplan;

import org.antlr.runtime.tree.CommonTree;

public class Value {
	
	int cop = 0;
	CommonTree ct;
	
	public Value() { 
		ct = null;
	}
	
	public Value(CommonTree t) {
		cop = t.getType();
		ct = t;
	}
	
	public String tostring(int count) {
		String tap = "";
		for (int i = 0; i < count; ++i)
			tap += '\t';
		
		return tap + ct.toStringTree() + "\n";
	}
}
