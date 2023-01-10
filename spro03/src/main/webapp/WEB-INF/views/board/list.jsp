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
			<div class="panel-heading">
				게시판 목록

				<button id="regBtn" type="button" class="btn btn-xs pull-right">게시글
					등록</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>내용</th>
							<th>작성자</th>
							<th>등록일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="board">
							<tr>
								<td><c:out value="${board.bno}" /></td>
								<td><a href="/board/get?bno=${board.bno}" ><c:out value="${board.title}" /></a></td>
								<td><c:out value="${board.writer}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.regDate}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.updateDate}" /></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
				<!-- /.table-responsive -->
				
				 <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">
                                        	처리가 완료되었습니다.   
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
<!--                                             <button type="button" class="btn btn-primary">Save changes</button>
 -->                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>

<script type="text/javascript">
	$(document).ready(function() {
		var result = '<c:out value="${result}"/>';
		
		checkModal(result);
		
		history.replaceState({},null,null); //뒤로가기 할때 내용 삭제
		
		function checkModal(result){
			if(result==='' || history.state){ //히스토리가 트루이면
				return;
			}
			
			if(parseInt(result)>0){
				$(".modal.body").html("게시글 " + parseInt(result) + " 번 글이 등록되었습니다.");
				
			}
			
			$("#myModal").modal("show");
		}
		
		$("#regBtn").on("click", function() {
			self.location = "/board/register";
		});
	})
</script>

<%@include file="../includes/footer.jsp"%>
