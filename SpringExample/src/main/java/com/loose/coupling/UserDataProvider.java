package com.loose.coupling;

//interface where methods will be overridden
//like a contract to implement a data provider
// new developer can use this interface and implment methods
public interface UserDataProvider {
    String getUserDetails();
}
