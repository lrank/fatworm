package fatworm.logicplan;

import org.antlr.runtime.tree.CommonTree;

public class Col_name extends Plan{
	
	String col_name, name;
	
	public Col_name(CommonTree t) {
		if (t.getChildCount() > 1) {
			col_name = ((CommonTree) t.getChild(0)).toString();
			name = ((CommonTree) t.getChild(1)).toString();
		} else {
			col_name = null;
			name = t.toString();
		}
	}
	
	public String tostring(int count) {
		String ret = "";
		if (col_name != null)
			ret += col_name + ".";
		return ret + name;
	}
}
