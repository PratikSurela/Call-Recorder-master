package vn.harry.callrecorder.response.ClientList;

import com.google.gson.annotations.SerializedName;


public class ResponseObjectItem{

	@SerializedName("kycsubbrocker")
	private Object kycsubbrocker;

	@SerializedName("kycmasterid")
	private String kycmasterid;

	@SerializedName("kycaccountname")
	private String kycaccountname;

	@SerializedName("mobilenumber")
	private String mobilenumber;

	@SerializedName("kycode")
	private String kycode;

	@SerializedName("accounttype")
	private Object accounttype;

	@SerializedName("kycstatus")
	private Object kycstatus;

	@SerializedName("email")
	private String email;

	public void setKycsubbrocker(Object kycsubbrocker){
		this.kycsubbrocker = kycsubbrocker;
	}

	public Object getKycsubbrocker(){
		return kycsubbrocker;
	}

	public void setKycmasterid(String kycmasterid){
		this.kycmasterid = kycmasterid;
	}

	public String getKycmasterid(){
		return kycmasterid;
	}

	public void setKycaccountname(String kycaccountname){
		this.kycaccountname = kycaccountname;
	}

	public String getKycaccountname(){
		return kycaccountname;
	}

	public void setMobilenumber(String mobilenumber){
		this.mobilenumber = mobilenumber;
	}

	public String getMobilenumber(){
		return mobilenumber;
	}

	public void setKycode(String kycode){
		this.kycode = kycode;
	}

	public String getKycode(){
		return kycode;
	}

	public void setAccounttype(Object accounttype){
		this.accounttype = accounttype;
	}

	public Object getAccounttype(){
		return accounttype;
	}

	public void setKycstatus(Object kycstatus){
		this.kycstatus = kycstatus;
	}

	public Object getKycstatus(){
		return kycstatus;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"ResponseObjectItem{" + 
			"kycsubbrocker = '" + kycsubbrocker + '\'' + 
			",kycmasterid = '" + kycmasterid + '\'' + 
			",kycaccountname = '" + kycaccountname + '\'' + 
			",mobilenumber = '" + mobilenumber + '\'' + 
			",kycode = '" + kycode + '\'' + 
			",accounttype = '" + accounttype + '\'' + 
			",kycstatus = '" + kycstatus + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}