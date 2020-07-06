package Blog.Service;

import Blog.Model.Role;

import java.util.List;

public interface iService<T> {
    List<T> findAll();
    T findOne(Long id);
    T save(T model);
    T remove(Long id);
}
