package com.twitterauthflow.controller;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Controller
public class AuthorizeController {
	@RequestMapping(value="/authorize", method=RequestMethod.GET)
	  public String authorize(
	      @RequestParam("oauth_verifier") String code, 
	     HttpServletRequest request) throws ClientProtocolException, IOException,Exception  { 
		
		System.out.println(code);
		 HttpSession session = request.getSession();
	    Twitter twitter = (Twitter) session.getAttribute("twitter");
	    AccessToken accessToken =(AccessToken) session.getAttribute("accessToken");
	    RequestToken requestToken =(RequestToken) session.getAttribute("requestToken");
	    
	    accessToken = twitter.getOAuthAccessToken(requestToken, code);
	    System.out.println(accessToken.getToken());
	    
	    twitter.setOAuthAccessToken(accessToken);
	    Query query = new Query("@narendramodi");
	    QueryResult result = twitter.search(query);
	    for (Status status : result.getTweets()) {
	        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
	    }
	      session.setAttribute("authCode", code);
	  
	   
	    
	    return "mail";
}
	
}


