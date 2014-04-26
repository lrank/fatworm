package fatworm.logicplan;

import org.antlr.runtime.tree.CommonTree;

import java.util.ArrayList;

public class Order extends Plan{
	
	ArrayList<CommonTree> list;
	ArrayList<Integer> asc;
	
	public Order() {
		
	}
	
	public Order(CommonTree t) {
		list = new ArrayList<CommonTree>();
		asc = new ArrayList<Integer>();
		for (int i = 0; i < t.getChildCount(); ++i) {
			CommonTree child = (CommonTree) t.getChild(i);
			if (child.getType() == Plan.ASC) {
				list.add( (CommonTree) child.getChild(0));
				asc.add(0);
			}
			if (child.getType() == Plan.DESC) {
				list.add( (CommonTree) child.getChild(0));
				asc.add(1);
			}
			else {
				list.add( child );
				asc.add(0);
			}
		}
	}
	
	public String tostring(int count) {
		String ret = "", tap = "";
		for (int i = 0; i < count; ++i)
			tap += '\t';
		
		ret += tap + "Order By {\n";
		for (int i = 0; i < list.size(); ++i) {
			CommonTree t = list.get(i);
			ret += tap + "\t" + t.toString();
			if (asc.get(i) == 0)
				ret += " ASC\n";
			else
				ret += " DESC\n";
		}
		ret += tap + "}\n";
		
		return ret;
	}
}
