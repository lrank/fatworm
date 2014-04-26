package fatworm.logicplan;

import org.antlr.runtime.tree.CommonTree;

public class Primary extends Bool_expr {
	
	public Select subquery;
	public Value v1, v2;
	public int type = 0, cop = 0;
	
	public Primary() {
		subquery = null;
		v1 = v2 = null;
	}
	
	public Primary(CommonTree t) {
		subquery = null;
		v1 = v2 = null;
		type = t.getType();
		if (type == Plan.NOT_EXISTS)
			subquery = new Select((CommonTree) t.getChild(0));
		else if (type == Plan.EXISTS)
			subquery = new Select((CommonTree) t.getChild(0));
		else if (type == Plan.IN) {
			v1 = new Value((CommonTree) t.getChild(0));
			subquery = new Select((CommonTree) t.getChild(1));
		}
		else if (type == Plan.ANY) {
			v1 = new Value((CommonTree) t.getChild(0));
			cop = ((CommonTree) t.getChild(1)).getType();
			subquery = new Select((CommonTree) t.getChild(2));
		}
		else if (type == Plan.ALL) {
			v1 = new Value((CommonTree) t.getChild(0));
			cop = ((CommonTree) t.getChild(1)).getType();
			subquery = new Select((CommonTree) t.getChild(2));
		}
		else {
			v1 = new Value((CommonTree) t.getChild(0));
			cop = t.getType();
			v2 = new Value((CommonTree) t.getChild(1));
		}
	}
	
	public String tostring(int count) {
		String tap = "";
		for (int i = 0; i < count; ++i)
			tap += '\t';

		if (type == Plan.NOT_EXISTS)
			return tap + "NOT EXISTS\n" +
					subquery.tostring(count + 1);
		else if (type == Plan.EXISTS)
			return tap + "EXISTS\n" +
					subquery.tostring(count + 1);
		else if (type == Plan.IN)
			return v1.tostring(count + 1) +
					tap + "IN\n" +
					subquery.tostring(count + 1);
		else if (type == Plan.ANY)
			return v1.tostring(count + 1) +
					tap + cop + "ANY\n" +
					subquery.tostring(count + 1);
		else if (type == Plan.ALL)
			return v1.tostring(count + 1) +
					tap + cop + "ALL\n" +
					subquery.tostring(count + 1);
		else {
			String ret = "";
			if (cop == 117)
				ret += tap + "=\n";
			else if (cop == 118)
				ret += tap + ">\n";
			else if (cop == 119)
				ret += tap + ">=\n";
			else if (cop == 114)
				ret += tap + "<\n";
			else if (cop == 115)
				ret += tap + "<=\n";
			else if (cop == 116)
				ret += tap + "<>\n";
			else
				ret += tap + cop + "\n";
			ret += v1.tostring(count + 1);
			ret += v2.tostring(count + 1);
			return ret;
		}
	}
}
