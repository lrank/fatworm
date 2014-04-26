package fatworm.logicplan;

import org.antlr.runtime.tree.CommonTree;

import java.io.*;
import java.util.*;

public class Select extends Plan{
	
	public boolean distinct = false;
	public ArrayList<CommonTree> names;
	public Plan from;
	public Condition where, having;
	public Group group;
	public Order order;
	
	public Select() {
		names = null;
		from = null;
		where = null;
		group = null;
		having = null;
		order = null;
	}
	
	public Select(CommonTree t) {
		group = null;
		having = null;
		order = null;
		
		if (t.getType() == 82)
			distinct = true;
		names = new ArrayList<CommonTree>();
		for (int i = 0; i < t.getChildCount(); ++i) {
			CommonTree child = (CommonTree)t.getChild(i);
			
			//System.out.println(child.getType());
			
			if (child.getType() == Plan.FROM) {
				if (child.getChildCount() == 1) {
					CommonTree temp = (CommonTree) child.getChild(0);
					
					if (temp.getType() == Plan.AS)
						temp = (CommonTree) temp.getChild(0);
					
					if (temp.getType() == Plan.SELECT || temp.getType() == Plan.SELECT_DISTINCT)
						from = new Select(temp);
					else
						from = new FetchTable(temp);
				}
				else from = new Join(child);
			}
			else if (child.getType() == Plan.WHERE)
				where = new Condition(child);
			else if (child.getType() == Plan.GROUP)
				group = new Group(child);
			else if (child.getType() == Plan.HAVING)
				having = new Condition(child);
			else if (child.getType() == Plan.ORDER)
				order = new Order(child);
			else names.add(child);
		}
	}
	
	public String tostring(int count) {
		String ret = "", tap = "";
		for (int i = 0; i < count; ++i)
			tap += '\t';
		
		
		/*if (from instanceof Select)
			ret = tap + "Select {\n" +
					tap + "\tFrom\n" +
					((Select)from).tostring(count + 1) +
					tap + "\tWhere\n" +
					where.tostring(count + 1);
		else if (from instanceof Join)
			ret = tap + "Select {\n" +
				tap + "\tFrom\n" +
				((Join)from).tostring(count + 1) +
				tap + "\tWhere\n" +
				where.tostring(count + 1);
		else if (from instanceof FetchTable)
			ret = tap + "Select {\n" +
				tap + "\tFrom\n" +
				((FetchTable)from).tostring(count + 1) +
				tap + "\tWhere\n" +
				where.tostring(count + 1);*/

		if (distinct == false)
			ret = tap + "Select {\n";
		else
			ret = tap + "Select Distinct{\n";
		ret += tap + "\tFrom\n" +
			from.tostring(count + 1);
		if (where != null)
			ret += tap + "\tWhere\n" +
			where.tostring(count + 1);
		
		if (group != null)
			ret += group.tostring(count + 1);
		if (having != null)
			ret += tap + "\tHaving\n" +
					having.tostring(count + 1);
		if (order != null)
			ret += order.tostring(count + 1);
		
		ret += tap + "} to {\n";
		for (int i = 0; i < names.size(); ++i)
			ret += tap + '\t' + i + ": "+ names.get(i).toStringTree() + '\n';
		ret += tap + "}\n";
		
		return ret;
	}
}
