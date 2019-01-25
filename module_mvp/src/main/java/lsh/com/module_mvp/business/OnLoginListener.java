package lsh.com.module_mvp.business;

import lsh.com.module_mvp.entity.User;

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();

}
