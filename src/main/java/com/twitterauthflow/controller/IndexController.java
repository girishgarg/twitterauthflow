package com.twitterauthflow.controller;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.twitterauthflow.auth.AuthHelper;

import twitter4j.TwitterException;
@Controller
public class IndexController {

	  @RequestMapping("/index")
	  public String index(Model model, HttpServletRequest request) throws TwitterException   {
		  UUID state = UUID.randomUUID();
		 HttpSession session = request.getSession();
		 String loginUrl = AuthHelper.getLoginUrl(state,session);
		  model.addAttribute("loginUrl", loginUrl);
		  // Name of a definition in WEB-INF/defs/pages.xml
		  return "index";
		}
}
