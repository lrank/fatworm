package fatworm.logicplan;

abstract public class Plan{
	public Plan parent;
	
	public static final int EOF=-1;
	public static final int T__105=105;
	public static final int T__106=106;
	public static final int T__107=107;
	public static final int T__108=108;
	public static final int T__109=109;
	public static final int T__110=110;
	public static final int T__111=111;
	public static final int T__112=112;
	public static final int T__113=113;
	public static final int T__114=114;
	public static final int T__115=115;
	public static final int T__116=116;
	public static final int T__117=117;
	public static final int T__118=118;
	public static final int T__119=119;
	public static final int A=4;
	public static final int ALL=5;
	public static final int AND=6;
	public static final int ANY=7;
	public static final int AS=8;
	public static final int ASC=9;
	public static final int AUTO_INCREMENT=10;
	public static final int AVG=11;
	public static final int B=12;
	public static final int BOOLEAN=13;
	public static final int BY=14;
	public static final int C=15;
	public static final int CHAR=16;
	public static final int COUNT=17;
	public static final int CREATE=18;
	public static final int CREATE_DATABASE=19;
	public static final int CREATE_DEFINITION=20;
	public static final int CREATE_INDEX=21;
	public static final int CREATE_TABLE=22;
	public static final int CREATE_UNIQUE_INDEX=23;
	public static final int D=24;
	public static final int DATABASE=25;
	public static final int DATETIME=26;
	public static final int DECIMAL=27;
	public static final int DEFAULT=28;
	public static final int DELETE=29;
	public static final int DESC=30;
	public static final int DIGIT=31;
	public static final int DISTINCT=32;
	public static final int DROP=33;
	public static final int DROP_DATABASE=34;
	public static final int DROP_INDEX=35;
	public static final int DROP_TABLE=36;
	public static final int E=37;
	public static final int EXISTS=38;
	public static final int F=39;
	public static final int FALSE=40;
	public static final int FLOAT=41;
	public static final int FLOAT_LITERAL=42;
	public static final int FROM=43;
	public static final int G=44;
	public static final int GROUP=45;
	public static final int H=46;
	public static final int HAVING=47;
	public static final int I=48;
	public static final int ID=49;
	public static final int IN=50;
	public static final int INDEX=51;
	public static final int INSERT=52;
	public static final int INSERT_COLUMNS=53;
	public static final int INSERT_SUBQUERY=54;
	public static final int INSERT_VALUES=55;
	public static final int INT=56;
	public static final int INTEGER_LITERAL=57;
	public static final int INTO=58;
	public static final int J=59;
	public static final int K=60;
	public static final int KEY=61;
	public static final int L=62;
	public static final int LETTER=63;
	public static final int M=64;
	public static final int MAX=65;
	public static final int MIN=66;
	public static final int N=67;
	public static final int NOT=68;
	public static final int NOT_EXISTS=69;
	public static final int NULL=70;
	public static final int O=71;
	public static final int ON=72;
	public static final int OR=73;
	public static final int ORDER=74;
	public static final int P=75;
	public static final int PRIMARY=76;
	public static final int PRIMARY_KEY=77;
	public static final int Q=78;
	public static final int R=79;
	public static final int S=80;
	public static final int SELECT=81;
	public static final int SELECT_DISTINCT=82;
	public static final int SET=83;
	public static final int STRING_LITERAL=84;
	public static final int SUM=85;
	public static final int T=86;
	public static final int TABLE=87;
	public static final int TIMESTAMP=88;
	public static final int TRUE=89;
	public static final int U=90;
	public static final int UNIQUE=91;
	public static final int UPDATE=92;
	public static final int UPDATE_PAIR=93;
	public static final int USE=94;
	public static final int USE_DATABASE=95;
	public static final int V=96;
	public static final int VALUES=97;
	public static final int VARCHAR=98;
	public static final int W=99;
	public static final int WHERE=100;
	public static final int WS=101;
	public static final int X=102;
	public static final int Y=103;
	public static final int Z=104;

	
	// which database we are in
	public String database;
	
	public Plan() {
		this.parent = null;
	}
	
	public Plan(Plan parent) {
		this.parent = parent;
	}
	
	abstract public String tostring(int count);
}
