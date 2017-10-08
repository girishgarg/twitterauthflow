<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${error ne null}">
  <div class="alert alert-danger">${error}</div>
</c:if>
<div class="jumbotron">
  <h1>twitter integeration Tutorial integeration tutorial</h1>
  <p>This sample uses the API to read Tweets from twitter.</p>
  <p><a class="btn btn-lg btn-primary" href="<spring:url value="${loginUrl}" />">Click here to login</a></p>
</div>