<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시판</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">게시글 조회</div>
			<div class="panel-body">
				<!-- <div class="row">
                                <div class="col-lg-6"> -->
				
					<div class="form-group">
						<label>번호</label> <input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly="readonly">
					</div>
				
					<div class="form-group">
						<label>제목</label> <input class="form-control" name="title" value='<c:out value="${board.title}"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="10" name="content" readonly>${board.content}</textarea>
					</div>

					<div class="form-group">
						<label>작성자</label> <input class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly="readonly">
					</div>
					<button data-oper='modify' class="btn btn-default">
							게시글 수정</button>
					<button data-oper='list' class="btn btn-default">게시글 목록</button>
					
					
					<form id="operForm" action="/board/modify" method="get">
						<input type="hidden" id='bno' name='bno' value='${board.bno}'>
						<input type="hidden" id="pageNum" name="pageNum" value="${cri.pageNum}">
						<input type="hidden" id="amount" name="amount" value="${cri.amount}">
						<input type="hidden" id="type" name="type" value ="${cri.type}">
						<input type="hidden" id="keyword" name="keyword" value="${cri.keyword}">
						
					</form>
			
			</div>
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->


<script type="text/javascript" src="/resources/js/reply.js"></script>
<script>
	console.log("-----------------");
	console.log(" reply JS test ");
	console.log(" add test ");
	
	const bnoValue = '<c:out value="${board.bno}"/>';
	
	replyService.add(
		{reply:"JS TEST", replyer:"tester", bno:bnoValue},
		function(result){
			alert("RESULT: " + result);
		}
	);
	
	console.log("---getList test----- ");
	
	replyService.getList({bno:bnoValue, page:1}, function(list){
		for(var i = 0, len=list.length||0; i<len; i++){
			console.log(list[i]);
		}
	});
	
	console.log("------ remove test --------");
	replyService.remove(17, function(result){
		console.log(result);
		if(result==="success"){
			alert("삭제 성공!");
		}
	}, function(err){
		alert('삭제 실패!');
	
	});
	
	replyService.update(
			{rno: 13, bno: bnoValue, reply:"update test by get.jsp"
			}, function(result){
				alert("수정 완료!")
			});
	
</script>



<script>
	$(document).ready(function(){
		
		console.log(replyService)
		
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action", "/board/modify").submit();
		});
		
		$("button[data-oper='list']").on("click", function(e){
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list");
			operForm.submit();
		})
	})

</script>



<%@include file="../includes/footer.jsp"%>
