package com.example.brand_post.Util.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusinessDatum {

@SerializedName("id")
@Expose
private String id;
@SerializedName("user_number")
@Expose
private String userNumber;
@SerializedName("name")
@Expose
private String name;
@SerializedName("email")
@Expose
private String email;
@SerializedName("website")
@Expose
private String website;
@SerializedName("mobile")
@Expose
private String mobile;
@SerializedName("logo")
@Expose
private String logo;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getUserNumber() {
return userNumber;
}

public void setUserNumber(String userNumber) {
this.userNumber = userNumber;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getWebsite() {
return website;
}

public void setWebsite(String website) {
this.website = website;
}

public String getMobile() {
return mobile;
}

public void setMobile(String mobile) {
this.mobile = mobile;
}

public String getLogo() {
return logo;
}

public void setLogo(String logo) {
this.logo = logo;
}

}