package lsh.com.module_mvp.business;

public interface IUserBiz
{
    public void login(String username, String password, OnLoginListener loginListener);
}
