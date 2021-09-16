package com.semanticsquare.thrillio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.managers.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		//////Test1: porn in the URL -- false
		
		Weblink weblink = BookmarkManager.getInstance().createWeblink(2000,"Taming Tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",	"http://www.javaworld.com"); 
		boolean isKindFriendlyEligible = weblink.isKidFriendlyEligible();
		assertFalse(isKindFriendlyEligible,"For porin in URL - isKidFrienldyEligible() must return false ") ;

		
		////Test2: porn in title -- false
		
		weblink = BookmarkManager.getInstance().createWeblink(2000,"Taming porn, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",	"http://www.javaworld.com");
		
		isKindFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertFalse(isKindFriendlyEligible,"For porn in title must return false");
		
		
		/////test3: adult in host -- false
		
	    weblink = BookmarkManager.getInstance().createWeblink(2000,"Taming tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",	"http://www.adult.com");
		
		isKindFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertFalse(isKindFriendlyEligible,"For adult in host must return false");
		
		
		////test 4: adult in url but not in the host part -- true
		
		 weblink = BookmarkManager.getInstance().createWeblink(2000,"Taming tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",	"http://www.adult.com");
			
			isKindFriendlyEligible = weblink.isKidFriendlyEligible();
			
			assertTrue(isKindFriendlyEligible,"For adult in url but not host ");
		
		///test 5: adult in title only
			
			weblink = BookmarkManager.getInstance().createWeblink(2000,"Taming adult, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",	"http://www.adult.com");
			
			isKindFriendlyEligible = weblink.isKidFriendlyEligible();
			
			assertTrue(isKindFriendlyEligible,"For adult in title must return true ");
		
	}

}
