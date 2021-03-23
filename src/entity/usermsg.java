package entity;

public class usermsg {
	private int u_id;
	private String name;
	private String gender;
	private String password;
	private String phone;
	private String address;
	private String email;
	private int r_id;
	private String r_name;
	private String authority;
	
	public usermsg(int u_id,String name, String gender, String password,String phone,String email,String address,int r_id) {
		// TODO Auto-generated constructor stub
		this.u_id=u_id;
		this.name=name;
		this.gender=gender;
		this.password=password;
		this.phone=phone;
		this.address=address;
		this.r_id=r_id;
		this.email=email;
	}
	public usermsg(int u_id,String name, String gender, String password,String phone,String email,String address,String r_name,String authority,int r_id) {
		// TODO Auto-generated constructor stub
		this.u_id=u_id;
		this.name=name;
		this.gender=gender;
		this.password=password;
		this.phone=phone;
		this.address=address;
		this.email=email;
		this.r_name=r_name;
		this.authority=authority;
		this.r_id=r_id;
	}
	public usermsg(){
		
	}

	public int getId() {
		return u_id;
	}

	public void setId(int u_id) {
		this.u_id = u_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
