package com.twitterauthflow.auth;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import org.springframework.web.util.UriComponentsBuilder;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
public class AuthHelper {
	public static String getLoginUrl(UUID state,HttpSession session2) throws TwitterException {
		Twitter twitter = TwitterFactory.getSingleton();
		session2.setAttribute("twitter",twitter );  
		  RequestToken requestToken = twitter.getOAuthRequestToken();
		    AccessToken accessToken = null;
		   String authurl=requestToken.getAuthorizationURL();
		    session2.setAttribute("requestToken",requestToken); 
		    session2.setAttribute("accessToken",accessToken); 
		    UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromHttpUrl(authurl);
	    return urlBuilder.toUriString();
	  }
}
