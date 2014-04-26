package fatworm.logicplan;

import org.antlr.runtime.tree.CommonTree;

public class FetchTable extends Join {
	
	public String Tablename;
	
	public FetchTable () {
		Tablename = "";
	}
	
	public FetchTable(CommonTree t) {
		CommonTree temp = t;
		//System.out.println(t.getType());
		if (temp.getType() == Plan.AS)
			temp = (CommonTree) temp.getChild(0);
		Tablename = temp.toString();
	}
	
	public String tostring(int count) {
		String ret = "", tap = "";
		for (int i = 0; i < count; ++i)
			tap += '\t';
		
		ret = tap + "FetchTable Plan: " + Tablename + "\n";
		return ret;
	}
	
}
