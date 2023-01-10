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
					<button data-oper='modify' class="btn btn-default" 
					onclick="location.href='/board/modify?bno=${board.bno}'">
							게시글 수정</button>
					<button data-oper='list' class="btn btn-default" 
					onclick="location.href='/board/list'">게시글 목록</button>
			
			</div>
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->




<%@include file="../includes/footer.jsp"%>
