class BOUser
{
String dob,type,name,address,working_since,email,mobile,qualification,gender,fathers_name;
int id;
BODesignation designation; 
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getDOB() {
	return dob;
}
public void setDOB(String dob) {
	this.dob = dob;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getWorking_since() {
	return working_since;
}
public void setWorking_since(String working_since) {
	this.working_since = working_since;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public BODesignation getDesignation() {
	return designation;
}
public void setDesignation(BODesignation designation) {
	this.designation = designation;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getFathers_name() {
	return fathers_name;
}
public void setFathers_name(String fathers_name) {
	this.fathers_name = fathers_name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String toString () {
	return String.valueOf (id);
}
}