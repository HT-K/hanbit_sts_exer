<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
	<style type="text/css">
		#login{
			margin-top: 5em;
		}
	</style>
	<div id="login">
		<div class="loginTop text-center" >
			<img src="${context}/resources/img/member/cho.jpg" id="cho" />
		</div>
		<br>
		<form>
		<div class="loginCenter row" style="margin-left: 43.5%;">
				<fieldset class="loginField">
					<div class="form-group">
					 	<label for="input_id" class="control-label sr-only">아이디</label>
					 	<div class="col-sm-3">
							<input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="control-label sr-only">비밀번호</label>
					 	<div class="col-sm-3">
							<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요"/>
						</div>
					</div>
				</fieldset>
			
		</div>
		<div class="input_button text-center">
			<img src="${context}/resources/img/member/login.jpg" id="loginButton" alt="" />
			<button id="cancelBtn">취소</button>
			<!-- <button class="btn btn-primary" id="loginButton">로그인</button> -->
		</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		// $로 cho라는 아이디를 가진 태그자체를 객체로 리턴받고 첫번째 .css를 만나 border 속성을 set하고 두번쨰, 세번째 전부 set한 후 ';' 세미콜론을 만나면 끝난다.
		$('#cho').css('border','0').css('height', '160px').css('width', '160px'); // border가 속성이고 0이 value다.
		$('#loginButton').css('width', '150px');
		$('form').addClass('form-horizontal').attr('method','post'); // form 태그에 클래스 입히기
		
		$('#loginButton').click(function() { // 로그인 버튼 클릭 시 $() 로 form 태그를 찾아서 객체로 리턴받아 action을 걸고 post방식으로 보낸다.
			$('form').attr('action','${context}/admin/login.do').submit();
		});
		$('#cancelBtn').addClass('btn btn-primary').click(function() { // 취소 버튼 클릭 시
			$('form').reset();
		});
	});
</script>
</html>