package com.chat.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chat.DAO.BlogDAO;
import com.chat.model.Blog;
import com.chat.model.BlogComment;

public class BlogDAOTestCase {
	static BlogDAO blogDAO;

	@BeforeClass
	public static void intialize(){
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.blog.*");
		context.refresh();
		
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}

	@Test
	public void addBlogTest(){
		Blog blog=new Blog();
		blog.setBlogName("Generated");
		blog.setBlogContent(" Generate whatever u want");
		blog.setLikes(0);
		blog.setLoginname("sar");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("status");
		blog.setBlogId(953);
		assertTrue("Problem in Blog Insetion",blogDAO.addBlog(blog));
		
	}

	@Test
	public void deleteBlogTest(){
		
		assertTrue("Problem in Blog Deletion",blogDAO.deleteBlog(953));
		
	}

	@Test
	public void rejectBlogTest(){
		Blog blog=blogDAO.getBlog(953);
		assertTrue("Problem in Blog Rejection",blogDAO.rejectedBlog(blog));
		
	}

	@Test
	public void approvalBlogTest(){
		Blog blog=blogDAO.getBlog(953);
		assertTrue("Problem in Blog Approval",blogDAO.approvedBlog(blog));
		
	}

	@Test
	public void listBlogbyUserTest(){
		List<Blog> listblog=blogDAO.listBlogs("ray");
		assertTrue("Problem in listing blog",listblog.size()>0);
		
		for(Blog blog:listblog)
		{
			System.out.println(blog.getBlogName()+"::::");
			System.out.println(blog.getBlogContent()+":::");
			System.out.println(blog.getBlogName());
		}
		
	}

	@Test
	public void incrementBlogLikeTest(){
		Blog blog=blogDAO.getBlog(953);
		assertTrue("Problem in Increment Like",blogDAO.increamentLike(blog));
		
	}
	@Test
	public void addCommentTest(){
		BlogComment comment=new BlogComment();
		comment.setLoginName("ray");
		comment.setCommentText("this is the comment line");
		comment.setBlogId(953);
		comment.setCommentDate(new java.util.Date());
		assertTrue("Problem in Blog Approval",blogDAO.addBlogComment(comment));
	}
	}