package Blog.Repository;

import Blog.Model.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog,Long> {

}
