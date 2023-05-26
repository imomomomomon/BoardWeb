<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

	<link href="${pageContext.request.contextPath}/css/write.css" rel="stylesheet">

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
	<c:set var="newline" value="\n"/>
	<script type="text/javascript">
		let write;
		let curPage;
		$(function () {
			{
				$('#hidden_id').val("test1");//나중에 아이디값으로 바꿔야함
				write = '${param.state}';
			}

			if(write == '') {
				write = 'insert';
				getCategoryList();
			} else {
				setInfo();
			}
		})
		function btnConfirm(){
			if(write === 'update')
				updateInfo();
			if(write === 'insert')
				insertInfo();
		}
		function setInfo() {
			let infoNo = '${param.infoNo}';
			curPage = '${param.infoNo}';
			$.ajax({
				url:'${pageContext.request.contextPath}/getInfo.do',
				type:'GET',
				data:{'cmd':'getInfo','infoNo':infoNo},
				dataType:'json',
				success:function(data){
					setValueInInfo(data[0]);
					getCategoryList(data[0].category);
				},error:function(){
					console.log('error');
				}
			});
			function setValueInInfo(jsondata) {
				$('#hidden_no').val(jsondata.no);
				$('#input_title').val(jsondata.title);
				{
					let bef = /\<br\>/g;
					let aft = "\r\n"
					$('#textarea_contents').val(jsondata.contents.replace(bef,aft));
				}
			}
		}
		function getCategoryList(select){
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
					printCatergoryList(arr,select);
				},error:function(){
					console.log('error : Get Category');
				}
			});
		}
		function printCatergoryList(arr,select) {
			for (let i = 1; i < arr.length; i++) {
				let option;
				if(arr[i] === select)
					option = $("<option selected='selected'>"+arr[i]+"</option>");
				else
					option = $("<option>"+arr[i]+"</option>");
				$('#select_category').append(option);
			}
			{//etc 밑으로 내리기
				let option;
				if(arr[0] === select)
					option = $("<option selected='selected'>"+arr[0]+"</option>");
				else
					option = $("<option>"+arr[0]+"</option>");
				$('#select_category').append(option);
			}
		}
		function updateInfo() {
			let formData = new FormData($('#multiForm')[0]);

			$.ajax({
				url:'${pageContext.request.contextPath}/updateInfo.do?cmd=updateInfo',
				type:'POST',
				enctype:'multipart/form-data',
				data:formData,
				processData:false,
				contentType:false,
				success:function(data){
					location.href = "${pageContext.request.contextPath}/jsp/info.jsp?infoNo="+curPage;
				},error:function(){
					console.log('error update Info');
				}
			});
		}
		function insertInfo() {
			let formData = new FormData($('#multiForm')[0]);

			$.ajax({
				url:'${pageContext.request.contextPath}/insertInfo.do?cmd=insertInfo',
				type:'POST',
				enctype:'multipart/form-data',
				data:formData,
				processData:false,
				contentType:false,
				success:function(data){
					if(data === '1')
						location.href = "${pageContext.request.contextPath}/jsp/board.jsp";
				},error:function(){
					console.log('error insert Info');
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
	<form id="multiForm" role="form" method="post" enctype="multipart/form-data">
	<div id="write-field">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<table>
				<tr>
					<td class="td1">카테고리</td>
					<td class="td2">
						<input name="no" id="hidden_no" type="hidden">
						<input name="id" id="hidden_id" type="hidden">
						<select name="category" id="select_category" class="form-control" style="display: inline-block;">
					</select></td>
				</tr>

				<tr>
					<td class="td1">제목</td>
					<td class="td2"><input type="text"
						name="title" value="" id="input_title"
						class="form-control input-sm bskr-font subject" /></td>
				</tr>


			</table>
			<div class="form-group">
				<table>
					<tr>
						<td class="td1"></td>
						<td class="td2"><textarea name="contents" id="textarea_contents"
								class="form-control col-sm-5" rows="20"></textarea></td>
					</tr>
					<tr>
					<td class="td1"></td>
						<td class="td2"><input name="file" type="file" id="InputFile"></td>
					</tr>
				</table>
			</div>

			<div class="bottombox">
				<input type="button" value="취소" class="btn btn-default btn-sm"
					onclick="return cancelCheck();" />&nbsp;
				<button id="submitPost" type="button" class="btn btn-primary btn-sm"
					onclick="btnConfirm()">
					<i class="glyphicon glyphicon-ok"></i> 확인
				</button>
			</div>
		</div>
	</div>
	</form>
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
	<script src="${pageContext.request.contextPath}js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}js/bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}js/clean-blog.min.js"></script>

</body>

</html>
