package Blog.Service.Impl;

import Blog.Model.Blog;
import Blog.Model.Comment;
import Blog.Repository.BlogRepository;
import Blog.Repository.CommentRepository;
import Blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog findOne(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public Blog save(Blog blog) {
        blogRepository.save(blog);
        return blog;
    }

    @Override
    public Blog remove(Long id) {
        Blog blog = blogRepository.findOne(id);
        blogRepository.delete(blog);
        return blog;
    }

    @Override
    public Comment addComment(Comment comment, Long blogId) {
        return null ;
    }

    @Override
    public Blog addLike(Long blogId) {
        Blog blog = blogRepository.findOne(blogId);
        int likes = blog.getLikes() + 1;
        blog.setLikes(likes);
        return blogRepository.save(blog);
    }
}

