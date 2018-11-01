package model;

public class Admin {
	private Integer uid;
	private String uname;
	private String pwd;
	private Integer historyTotal;
	private Integer historyCorrect;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getpwd() {
		return pwd;
	}
	public void setpwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getHistoryTotal() {
		return historyTotal;
	}
	public void setHistoryTotal(Integer historyTotal) {
		this.historyTotal = historyTotal;
	}
	public Integer getHistoryCorrect() {
		return historyCorrect;
	}
	public void setHistoryCorrect(Integer historyCorrect) {
		this.historyCorrect = historyCorrect;
	}
	@Override
	public String toString() {
		return "Admin [uid=" + uid + ", uname=" + uname + ", pwd=" + pwd + ", historyTotal=" + historyTotal
				+ ", historyCorrect=" + historyCorrect + "]";
	}
	public Admin(Integer uid, String uname, String pwd, Integer historyTotal, Integer historyCorrect) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.pwd = pwd;
		this.historyTotal = historyTotal;
		this.historyCorrect = historyCorrect;
	}
	public Admin(){}
	
}
