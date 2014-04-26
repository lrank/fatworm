package fatworm.logicplan;

import org.antlr.runtime.tree.CommonTree;

public class Bool_expr extends Plan{
	
	public Bool_expr left, right;
	int logic;
	
	public Bool_expr() {
		logic = 0;
		left = right = null;
	}
	
	public Bool_expr(CommonTree t) {
		logic = t.getType();
		CommonTree l = (CommonTree)t.getChild(0), r = (CommonTree)t.getChild(1);

		if (l.getType() == Plan.AND ||
			l.getType() == Plan.OR)
			left = new Bool_expr(l);
		else
			left = new Primary(l);

		if (r.getType() == Plan.AND ||
			r.getType() == Plan.OR)
			right = new Bool_expr(r);
		else
			right = new Primary(r);
		
	}
	
	public String tostring(int count) {
		String ret = "", tap = "";
		for (int i = 0; i < count; ++i)
			tap += '\t';
		
		if (logic == 6)
			ret += tap + "and\n";
		else if (logic == 73)
			ret += tap + "or\n";
		else
			ret += tap + logic + "\n";
		if (left instanceof Bool_expr)
			ret += left.tostring(count + 1);
		else
			ret += ((Primary) left).tostring(count + 1);
		
		if (right instanceof Bool_expr)
			ret += right.tostring(count + 1);
		else
			ret += ((Primary) right).tostring(count + 1);
		
		return ret;
	}
	
}
