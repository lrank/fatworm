package fatworm.logicplan;

import org.antlr.runtime.tree.CommonTree;

public class Group extends Plan{
	
	Col_name name;
	
	public Group() {
		name = null;
	}
	
	public Group(CommonTree t) {
		//System.out.println(t.getType());
		name = new Col_name((CommonTree) t.getChild(0));
	}
	
	public String tostring(int count) {
		String ret = "", tap = "";
		for (int i = 0; i < count; ++i)
			tap += '\t';
		ret += tap + "Group By " + name.tostring(count + 1) + "\n";
		return ret;
	}
	
}
