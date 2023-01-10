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
				  <form action="/board/modify" method="POST">
					<div class="form-group">
						<label>번호</label> <input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly="readonly">
					</div>
				
					<div class="form-group">
						<label>제목</label> <input class="form-control" name="title" value='<c:out value="${board.title}"/>' >
					</div>

					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="10" name="content" >${board.content}</textarea>
					</div>

					<div class="form-group">
						<label>작성자</label> <input class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly="readonly">
					</div>
					
					<div class="form=group">
						<label>등록일자</label>
						<input class="form-control" name="regDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regDate}"/>' readonly>
					</div>
					
					<div class="form=group">
						<label>수정일자</label>
						<input class="form-control" name="updateDate" 
							   value='<fmt:formatDate pattern="yyyy/MM/dd" 
							   value="${board.updateDate}"/>' readonly>
					</div>
					
					<button type="submit" data-oper='modify' class="btn btn-default">
							게시글 수정</button>
							
					<button type="submit" data-oper='remove' class="btn btn-danger">
							게시글 삭제</button>
							
					<button type="submit" data-oper='list' class="btn btn-info">
							게시글 목록</button>
				  </form>
			</div>
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function(){
	var formObj = $("form");
	$('button').on("click", function(e){
		e.preventDefault();
		
		var operation = $(this).data("oper");
		
		console.log(operation);
		
		if(operation === 'remove') {
			formObj.attr("action", "/board/remove")
				   .attr("method", "POST");
			formObj.submit();
		} else if(operation === 'modify'){
			formObj.attr("action", "/board/modify")
					.attr("method", "POST");
			formObj.submit();
		} else if(operation === 'list' ){
			self.location = "/board/list";
		}
		
		
	})
})
</script>
<%@include file="../includes/footer.jsp"%>
