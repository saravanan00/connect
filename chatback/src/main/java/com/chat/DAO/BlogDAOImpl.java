package com.chat.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.chat.model.Blog;
import com.chat.model.BlogComment;

public class BlogDAOImpl implements BlogDAO{
@Autowired
SessionFactory sessionFactory;
	public boolean addBlog(Blog blog) {
		// TODO Auto-generated method stub
		  try
		  {
		  sessionFactory.getCurrentSession().save(blog);
		  return true;
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		  System.out.println("Exception Arised..........:"+e);
		  return false;
		  }
		  
		 }
		
	

	public boolean deleteBlog(int blogId) {
		try {
			   sessionFactory.getCurrentSession().delete(blogId);
			   //Product product1=(Product)session.get(Product.class,product.getProductId());
			   
			   return true;
			   }
			   catch(Exception e) {
			    System.out.println("Exception Arised:"+e);
			   return false;
			   }
			  // TODO Auto-generated method stub
			  
			 }


	public boolean updateBlog(int blogId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Blog> listBlogs(String username) {
		 try
		  {
		   Session session=sessionFactory.openSession();
		   Query query=session.createQuery("from Blog where loginname=:username");
		   query.setParameter("username",username);
		   List<Blog> listBlogs=query.list();
		   return listBlogs;
		  }
		  catch(Exception e)
		  {
		   return null;
		  }
		     
	}

	public boolean approvedBlog(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		return true;
	}

		

	public boolean rejectedBlog(Blog blog) {
		
		// TODO Auto-generated method stub
		 try
		  {
		   blog.setStatus("NA");
		   sessionFactory.getCurrentSession().update(blog);
		   return true;
		  }
		  catch(Exception e)
		  {
		   return false;
		  }
	}

	public Blog getBlog(int blogId) { 
		try
	  {
		  Session session=sessionFactory.openSession();
		  Blog blog=(Blog)session.get(Blog.class,blogId);
		  return blog;
		  }
		  catch(Exception e)
		  {
		   return null;
		  }
		  
	}

	public List<Blog> listAllBlogs() {
		 try
		  {
		   Session session=sessionFactory.openSession();
		   Query query=session.createQuery("from Blog ");
		   
		   List<Blog> listBlogs=query.list();
		   return listBlogs;
		  }
		  catch(Exception e)
		  {
		   return null;
		  }
	}

	public boolean increamentLike(Blog blog) {
		 try
		  {
		   int likes=blog.getLikes();
		   likes++;
		   blog.setLikes(likes);
		   sessionFactory.getCurrentSession().update(blog);
		   return true;
		  }
		 catch(Exception e)
		  {
		  return false;
		  }
		 }
		

	public boolean addBlogComment(BlogComment blogComment) {
		 try
		  {
		  sessionFactory.getCurrentSession().save(blogComment);
		  return true;
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		  System.out.println("Exception Arised..........:"+e);
		  return false;
		  }
		  
		  
		 }
		

	public boolean deleteBlogComment(BlogComment blogComment) {
		try {
			   sessionFactory.getCurrentSession().delete(blogComment);
			   //Product product1=(Product)session.get(Product.class,product.getProductId());
			   
			   return true;
			   }
			   catch(Exception e) {
			    System.out.println("Exception Arised:"+e);
			   return false;
			   }
	}

	public BlogComment getBlogComment(int commentId) {
		 try
		  {
		  Session session=sessionFactory.openSession();
		  BlogComment blogComment=(BlogComment)session.get(BlogComment.class,commentId);
		  return blogComment;
		  }
		  catch(Exception e)
		  {
		   return null;
		  }
		  
		 
		 }
		

	public List<BlogComment> listBlogComments(int blogId) {
		 try
		  {
		   Session session=sessionFactory.openSession();
		   Query query=session.createQuery("from BlogComment");
		   
		   List<BlogComment> listBlogComments=query.list();
		   return listBlogComments(0);
		  }
		  catch(Exception e)
		  {
		   return null;
		  }
		  
		 }
		}

