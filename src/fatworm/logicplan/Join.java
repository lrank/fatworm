package fatworm.logicplan;

import org.antlr.runtime.tree.CommonTree;

public class Join extends Plan {
	
	public Join left, right;
	
	public Join() {
		left = right = null;
	}
	
	public Join(CommonTree t) {
		this.left = new FetchTable((CommonTree) t.getChild(0));
		CommonTree temp = t;
		temp.deleteChild(0);
		if (temp.getChildCount() == 1)
			this.right = new FetchTable((CommonTree) temp.getChild(0));
		else this.right = new Join(temp);
	}
	
	public String tostring(int count) {
		String ret = "", tap = "";
		for (int i = 0; i < count; ++i)
			tap += '\t';
		
		ret = tap + "Product\n" +
				left.tostring(count + 1) +
				tap + "and\n" +
				right.tostring(count + 1);
		
		return ret;
	}
}
