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
			<div class="panel-heading">게시글 등록</div>
			<div class="panel-body">
				<!-- <div class="row">
                                <div class="col-lg-6"> -->
				<form action="/board/register" method="POST">
					<div class="form-group">
						<label>제목</label> <input class="form-control" name="title">
						<!-- <p class="help-block">Example block-level help text here.</p> -->
					</div>

					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="10" name="content"></textarea>
					</div>

					<div class="form-group">
						<label>작성자</label> <input class="form-control" name="writer">
						<!-- <p class="help-block">Example block-level help text here.</p> -->
					</div>
					<button type="submit" class="btn btn-default">게시글 등록</button>
					<button type="reset" class="btn btn-default">다시 작성</button>
				</form>
			</div>
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->


<%@include file="../includes/footer.jsp"%>
