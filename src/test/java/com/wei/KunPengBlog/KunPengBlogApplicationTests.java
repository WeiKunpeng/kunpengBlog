package com.wei.KunPengBlog;

import com.wei.KunPengBlog.bean.User;
import com.wei.KunPengBlog.dao.UseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KunPengBlogApplicationTests {


	@Autowired
	UseDao useDao;

	@Test
	public void contextLoads() {


	}

}
