package java8test;


import java.util.List;




public class Account {
	
	  private Integer accountId ;	  
	  
	  private double money;
	  
	  private String addre;
	  
	  /**
	   * 一对多关系（外键关联注解配置） 
	   */
//	  private List<Customer> customer;
	  
	  public Account(){}
	  
	  public Account(Integer accountId,String name,double money )
	  {
		  this.accountId = accountId;
		  this.money = money;
	  }
	  	 
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	public String getAddre() {
		return addre;
	}

	public void setAddre(String addre) {
		this.addre = addre;
	}


	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", money=" + money + ", addre=" + addre + ", customer=";
	}

	
}
