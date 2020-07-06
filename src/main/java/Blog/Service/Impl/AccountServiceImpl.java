package Blog.Service.Impl;

import Blog.Model.Account;
import Blog.Repository.AccountRepository;
import Blog.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Account findOne(Long id) {
        return accountRepository.findOne(id);
    }

    @Override
    public Account save(Account model) {
        return accountRepository.save(model);
    }

    @Override
    public Account remove(Long id) {
        Account account = accountRepository.findOne(id);
        accountRepository.delete(account);
        return account;
    }

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = this.findAccountByUsername(username);

        List<GrantedAuthority> roleList = new ArrayList<>();
        roleList.add( new SimpleGrantedAuthority(account.getRole().getName()));

        return new User(account.getUsername(), account.getPassword(), roleList);
    }
}
