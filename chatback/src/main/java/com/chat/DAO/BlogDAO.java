package com.chat.DAO;

import java.util.List;

import com.chat.model.Blog;
import com.chat.model.BlogComment;

public interface BlogDAO  {
		public boolean addBlog(Blog blog);
		public boolean deleteBlog(int blogId);
		public boolean updateBlog(int blogId);
		
		public List<Blog> listBlogs(String username);
		public boolean approvedBlog(Blog blog);
		public boolean rejectedBlog(Blog blog);
		public Blog getBlog(int blogId);
		public List<Blog> listAllBlogs();
		public boolean increamentLike(Blog blog);
		
		public boolean addBlogComment(BlogComment blogComment);
		public boolean deleteBlogComment(BlogComment blogComment);
		public BlogComment getBlogComment(int commentId);
		public List<BlogComment> listBlogComments(int blogId);
}
	



