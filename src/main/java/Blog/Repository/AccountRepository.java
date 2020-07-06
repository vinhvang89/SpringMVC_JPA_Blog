package Blog.Repository;

import Blog.Model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {
    Account findAccountByUsername(String username);
}
