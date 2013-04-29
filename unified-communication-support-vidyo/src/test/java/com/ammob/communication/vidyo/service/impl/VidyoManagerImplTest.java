package com.ammob.communication.vidyo.service.impl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ammob.communication.core.model.User;
import com.ammob.communication.vidyo.model.Member;

public class VidyoManagerImplTest {
	
    private VidyoManagerImpl manager = null;
    private User user = null;
    
    private String url = "http://v.seekoom.com";
    private String username = "hotmob";
    private String password = "121212";
    
    @Before
    public void setUp() {
        manager = new VidyoManagerImpl();
        user = new User(username);
        user.setPassword(password);
        user.setWebsite(url);
    }

    @After
    public void tearDown() {
        manager = null;
    }
    
	@Ignore
	public void testSearch() {
		ObjectMapper mapper = new ObjectMapper();
		List<Member> dd = manager.getVidyoMemberList(user, null, 0, 20);
		for(Member member : dd){
			System.out.println(member.getDisplayName() + " : " + member.getMemberStatus());
		}
		try {
			System.out.println(mapper.writeValueAsString(dd)); //返回字符串
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testJoinVidyoRoom() {
		ObjectMapper mapper = new ObjectMapper();
		boolean dd = manager.joinVidyoRoom(user, 474);
		try {
			System.out.println(mapper.writeValueAsString(dd)); //返回字符串
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
