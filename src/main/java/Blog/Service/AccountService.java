package Blog.Service;

import Blog.Model.Account;

public interface AccountService extends iService<Account> {
    Account findAccountByUsername(String username);
}
