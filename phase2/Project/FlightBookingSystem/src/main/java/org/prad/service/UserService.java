package org.prad.service;

import org.prad.entity.User;
import org.prad.entity.UserAccount;

public interface UserService {

    public Long addUserAccount(UserAccount user);
    public UserAccount findUser(String userName);
    public boolean validateUser(UserAccount user);
    public String userType(UserAccount user);
}
