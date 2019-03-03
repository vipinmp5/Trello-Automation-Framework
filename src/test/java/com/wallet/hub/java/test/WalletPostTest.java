package com.wallet.hub.java.test;
import static org.testng.Assert.assertTrue;



import org.testng.annotations.Test;

import com.wallet.hub.java.pages.*;
import com.wallet.hub.java.util.PropertyManager;
import com.wallet.hub.java.util.Utility;

@Module(module = "WalletHub")
public class WalletPostTest extends BaseTest {

		
	
	@Test
	@TestInfo(risk=TestInfo.Risk.HIGH)
	public void WalletTestStarHover() throws Exception
		{
		  String BaseUrl=PropertyManager.getInstance().getBaseUrl();
		  String UserName=PropertyManager.getInstance().getWalletUsername();
		  String LoginMailId=UserName+"@"+PropertyManager.getInstance().getWalletEmailDomain();
		  String Password=PropertyManager.getInstance().getWalletPassword();
		  String PolicyName=PropertyManager.getInstance().getPolicyName();
		
		  String Review=Utility.randomAlphaNumeric(200);
		
	   assertTrue(page.GetInstance(WalletInsuranceLandingPage.class).goToLandingPage(BaseUrl).goToLoginPage().
			   LoginToWalletHub(LoginMailId, Password).mouseHoverTo4thStarAndClick5th().
			   SelectPolicy(PolicyName).EnterReview(Review).SubmitReview().goToProfilePage(BaseUrl,UserName).
			   getReviewContent(page.GetInstance(ReviewSubmissionConfirmPage.class).getReviewID()).
			   equalsIgnoreCase(Review));
		    
		    
		    
			
		 
		   	}
	@Test
	@TestInfo(risk=TestInfo.Risk.MEDIUM)
	public void FacebookWallPostAssertionTest() throws Exception
		{
		  String UserName=PropertyManager.getInstance().getFacebookUserName();
		  String Password=PropertyManager.getInstance().getFacebookPassword();
		  String FacebookName=PropertyManager.getInstance().getFacebookName();
		  String PostText=PropertyManager.getInstance().getPostData();
		  
			driver.get("http://www.facebook.com/");
			assertTrue(page.GetInstance(FacebookLoginPage.class).
					LoginToFaceBookAccount(UserName,Password).
					verifyHomePage(FacebookName).
					WallPost(PostText).
					getLatestPostContentFromWall().
					equalsIgnoreCase(PostText));
			
			
		}
		
		
		

		
	
}
