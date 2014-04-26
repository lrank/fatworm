package fatworm.logicplan;

import org.antlr.runtime.tree.CommonTree;

public class Condition extends Plan {
	
	public Bool_expr bool_expr;
	
	public Condition() {
		bool_expr = null;
	}
	
	public Condition(CommonTree t) {
		CommonTree child = (CommonTree) t.getChild(0);
		if (child.getType() == Plan.AND ||
			child.getType() == Plan.OR)
			bool_expr = new Bool_expr(child);
		else
			bool_expr = new Primary(child);
	}
	
	public String tostring(int count) {
		if (bool_expr instanceof Bool_expr)
			return bool_expr.tostring(count + 1);
		else
			return ((Primary) bool_expr).tostring(count + 1);
	}
}
