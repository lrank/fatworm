package fatworm.logicplan;

import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;
import org.antlr.runtime.*;

public class Project extends Plan{
	
	public Select select;
	
	public Project() {
		select = null;
	}
	
	public Project(CommonTree tree) {
		if (tree.getType() == 81 || tree.getType() == 82)
			select = new Select(tree);
	}
	
	public String tostring(int count) {
		String ret = "", tap = "";
		for (int i = 0; i < count; ++i)
			tap += '\t';
		
		ret = tap + "Project {\n" +
				select.tostring(count + 1) + 
				tap + "}\n";
		
		return ret;
	}
}
