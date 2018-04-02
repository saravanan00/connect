package com.chat.chatback;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class Blog {

	@SequenceGenerator(name="blogidseq",sequenceName="myblog_seq")
	
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogidseq")
		int blogId;
		String blogName;
		String blogContent;
		Date createDate;
		public int getBlogId() {
			return blogId;
		}
		public void setBlogId(int blogId) {
			this.blogId = blogId;
		}
		public String getBlogName() {
			return blogName;
		}
		public void setBlogName(String blogName) {
			this.blogName = blogName;
		}
		public String getBlogContent() {
			return blogContent;
		}
		public void setBlogContent(String blogContent) {
			this.blogContent = blogContent;
		}
		public Date getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}
		public int getLikes() {
			return likes;
		}
		public void setLikes(int likes) {
			this.likes = likes;
		}
		public String getLoginname() {
			return loginname;
		}
		public void setLoginname(String loginname) {
			this.loginname = loginname;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		int likes;
		String loginname;
		String status;
		
	}