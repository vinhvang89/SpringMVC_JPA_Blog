package Blog.Service;

import Blog.Model.Blog;
import Blog.Model.Comment;

public interface BlogService extends iService<Blog> {
    Comment addComment(Comment comment,Long blogId);
    Blog addLike(Long blogId);
}
