<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC >
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Start Simple Web</title>
<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/css/clean-blog.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/board.css" rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/boradList.js"></script>
	<script type="text/javascript">
		let state;
		$(function () {
			getCategoryList();
			{
				state = "${sessionScope.state}";
				if(state === "") {
					state = "all";
					selectList();
				}
				else if(state === "search") {
					const category = "${sessionScope.category}";
					const search = "${sessionScope.search}";
					getPageBean(null,category,search);
				}
			}
		})
		function btnList() {
			state = "all";
			setSessionState("all");
			selectList(1);
		}
		function btnSearch() {
			state = "search";
			setSessionState("search");
			selectList();
		}
		function setSessionState(value) {
			$.ajax({
				url:'${pageContext.request.contextPath}/session.do',
				type:'POST',
				data:{'cmd':'session','name':'state','action':'replace',
						'value':value},
				success:function(data){
				},error:function(){
					console.log('error : Set SessionState');
				}
			});
		}
		function btnInsert() {
			location.href = "${pageContext.request.contextPath}/jsp/write.jsp";
		}
		function btnIncrease(dir) {
			let activeNum = document.getElementById("btn_pagingActive").firstChild.innerHTML;
			if(dir == 0) {
				btn_selectList(Number(activeNum)-1);
			} else {
				btn_selectList(Number(activeNum)+1);
			}
		}
		function btn_selectList(page) {
			if(state === "search"){
				const category = "${sessionScope.category}";
				const search = "${sessionScope.search}";
				getPageBean(page,category,search);
			} else {
				getPageBean(page);
			}
		}
		function activceGoInfo(num) {
			location.href = "${pageContext.request.contextPath}/jsp/info.jsp?infoNo="+num;
		}
		function selectList(page) {
			if(state === "search"){
				setValueForSearching(page);
			} else {
				getPageBean(page);
			}
		}
		function setValueForSearching(page) {
			let category = document.getElementById("section_category").value;
			let search = document.getElementById("input_search").value;
			if(page == null) getPageBean(1,category,search);
			else getPageBean(page,category,search);
		}
		function getPageBean(page,category,search) {
			$.ajax({
				url:'${pageContext.request.contextPath}/getPageBean.do',
				type:'GET',
				data:{'cmd':'getPageBean','pageNum':page,
					'category':category,'search':search},
				dataType:'json',
				success:function(data){
					document.getElementById("pagination").replaceChildren();
					printPageNum(Number(data.cur), Number(data.start), Number(data.end));
					getBoardList(category,search);
				},error:function(){
					console.log('error : Get PageBean');
				}
			});
		}
		function getBoardList(category,search){
			$.ajax({
				url:'${pageContext.request.contextPath}/boradList.do',
				type:'GET',
				data:{'cmd':'boradList','category':category,'search':search},
				dataType:'json',
				success:function(data){
					document.getElementById("list-group").replaceChildren();
					for (let i = 0; i < data.length; i++) {
						printList(data[i]);
					}
				},error:function(){
					console.log('error : Get BoardList');
				}
			});
		}
		function getCategoryList(){
			$.ajax({
				url:'${pageContext.request.contextPath}/category.do',
				type:'GET',
				data:{'cmd':'category'},
				success:function(data){
					let arr = data.split(',');
					{
						arr[0] = arr[0].slice(1);
						for (let i = 1; i < arr.length; i++) {
							arr[i] = arr[i].trim();
						}
						arr[arr.length-1]
								= arr[arr.length-1].slice(0,arr[arr.length-1].length-1);
					}
					printCatergoryList(arr);
				},error:function(){
					console.log('error : Get Category');
				}
			});
		}

	</script>


</head>
<body>


<jsp:include page="header.jsp"></jsp:include>


	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header"
		style="background-image: url('${pageContext.request.contextPath}/img/about-bg.jpg'); height: 200px">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading"
						style="margin-top: 10px; padding-top: 35px; padding-bottom: 35px">
						<h2>SAMPLE</h2>
						<span class="subheading">BULLETIN BOARD</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="board-field">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<div class="board-toolbar" 	style="text-align: right; margin-bottom: 20px">
				<select id="section_category" class="section-heading">
				</select>
				<input id="input_search" type="text" class="input-lg">
				<a href="Javascript:btnSearch()" class="btn btn-primary btn-sm"><i
						class="glyphicon glyphicon-search" style="margin-right: 15px"></i>검색</a>
				<a href="Javascript:btnList()" class="btn btn-primary btn-sm"><i
						class="glyphicon glyphicon-blackboard" style="margin-right: 15px"></i>목록</a>
				<a href="Javascript:btnInsert()" class="btn btn-primary btn-sm"><i
						class="glyphicon glyphicon-pencil" style="margin-right: 15px"></i>쓰기</a>
			</div>
			<div id="list-group" class="list-group">
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<ul id="pagination" class="pagination">
				</ul>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<ul class="list-inline text-center">
						<li><a href="#"> <span class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-envelope-o fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li><a href="#"> <span class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-home fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li><a href="#"> <span class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-github fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
					</ul>
					<p class="copyright text-muted">Copyright &copy;2016 SIST. All
						rights reserved | code by milib</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/js/clean-blog.min.js"></script>

</body>

</html>
