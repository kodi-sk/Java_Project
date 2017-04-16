package models;

public class Company {
	private String Cname;
	private int Cid;
	private int Cpackage;
	private int count=0;
	
	public void setCname(String Cname){
		this.Cname=Cname;
	}
	public String getCname(){
		return Cname;
	}
	public void setCid(int Cid){
		this.Cid=Cid;
	}
	public int getCid(){
		return Cid;
	}
	public void setCpackage(int Cpackage){
		this.Cpackage=Cpackage;
	}
	public int getCpackage(){
		return Cpackage;
	}
	public void setCount(int count){
		this.count=count;
	}
	public int getCount(){
		return count;
	}
}
