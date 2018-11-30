package com.test.nubicall.backendnubi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.nubicall.backendnubi.entity.User;
import com.test.nubicall.backendnubi.service.IUserService;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BackendNubiApplicationTests {

	@Autowired
	IUserService userService;
	
	
	User user;
	
	@Test
	public void contextLoads() {
	}
	
	@Before
	public void setUp() {
		user = new User();
		user.setEmail("criferlo@hotmail.com");
		user.setFirstName("Cristhian");
		user.setLastName("Lombana");
		user.setPassword("123");
		user.setPhone("3105747258");
		user.setUsername("criferlo");
		user.setUserStatus("Active");		
		//UUID is not set for user		
	}
	
	@Test
	public void a_deleteUser() {
		User user = userService.getUser("criferlo");		
		
		if(user!=null) {
			boolean res = userService.deleteUser("criferlo");
			assertThat(res).isEqualTo(true);
		}else {
			boolean res = userService.deleteUser("criferlo");
			assertThat(res).isEqualTo(false);
		}
	}
	
	@Test
	public void b_saveUser() {
		User user = userService.saveUser(this.user);
		assertThat(user).isNotEqualTo(null);
	}
	
	@Test
	public void c_getUser() {		
			User _user = userService.getUser("criferlo");
			assertThat(_user).isNotEqualTo(null);		
		
	}
	

}
