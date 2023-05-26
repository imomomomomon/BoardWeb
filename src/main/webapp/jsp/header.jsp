<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script type="text/javascript">
		$(function () {
			checkSessionId();
		})
		function checkSessionId() {
			let id = '${sessionScope.id}';
			if(id === '') {
				$('li#li_login').show();
				$('li#li_logout').hide();
			} else {
				$('li#li_logout').show();
				$('li#li_logout').click(doLogout);
				$('li#li_login').hide();
			}
		}
		function doLogout(){
			$.ajax({
				url:'${pageContext.request.contextPath}/session.do',
				type:'POST',
				data:{'cmd':'session','name':'id','action':'delete'},
				success:function(data){
					location.reload();
				},error:function(){
					console.log('error : Do Logout');
				}
			});
		}
	</script>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="signin.jsp">Start Simple Web</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/jsp/board.jsp">Board</a></li>
					<li id="li_logout"><a href="#">LogOut</a></li>
					<li id="li_login"><a href="signin.jsp">LogIn</a></li>
					<li><a href="mypage.jsp">Mypage</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<!-- Page Header -->
</body>
</html>