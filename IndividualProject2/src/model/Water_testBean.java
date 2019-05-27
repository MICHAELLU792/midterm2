package model;

public class Water_testBean {
	private String name;
	private String observatory;
	private String testdate;
	private String level;
	private double RPI;
	private double DO;
	private String Ammonia;
	private double SS;
	
	public Water_testBean(String name,String observatory,String testdate,String level,
			String RPI,String DO,String Ammonia,String SS) {
		this.name=name;
		this.observatory=observatory;
		this.testdate=testdate;
		this.level=level;
		this.RPI=Double.parseDouble(RPI);
		this.DO=Double.parseDouble(DO);
		this.Ammonia=Ammonia;
		this.SS=Double.parseDouble(SS);
	}
	
	public Water_testBean() {
		super();
	}
	
	public String getName() {return name;} 
	public String getObservatory() {return observatory;}
	public String getTestdate() {return testdate;}
	public String getLevel() {return level;}
	public double getRPI() {return RPI;}
	public double getDO() {return DO;}
	public String getAmmonia() {return Ammonia;}
	public double getSS() {return SS;}
	
	public void setName(String name) {this.name=name;} 
	public void setObservatory(String observatory) {this.observatory=observatory;}
	public void setTestdate(String testdate) {this.testdate=testdate;}
	public void setLevel(String level) {this.level=level;}
	public void setRPI(double RPI) {this.RPI=RPI;}
	public void setDO(double DO) {this.DO=DO;}
	public void setAmmonia(String Ammonia) {this.Ammonia=Ammonia;}
	public void setSS(double SS) {this.SS=SS;}
}
