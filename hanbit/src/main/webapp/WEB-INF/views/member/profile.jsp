<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="detail">
		<div class="joinTop">
			<h2 class="text-center">${sessionScope.user.name} 상세정보</h2>
		</div>
		<div class="joinCenter row">
			<form class="form-horizontal">
				<fieldset class="joinField">
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">프로필 이미지 등록</label>
					 	<div class="col-sm-2">
							<img src="${img}/member/${sessionScope.user.profileImg}" alt="" style="width:200px;height:230px"/>
						</div>
					 	<div class="col-sm-2">
							<input type="file" id="profile_img" name="profile_img" />
						</div>
					</div>
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${member.id}" readonly="readonly"/> <!-- input type으로 주면 그 값을 변경 시킬 수 있는데 지금 화면에서는 변경을 못하게 해야하므로 이렇게 적어준다. -->
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="password" name="password" value="${member.password}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">이름</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="name" name="name" value="${member.name}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">주소</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="addr" name="addr" value="${member.addr}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="birth" name="birth" value="${member.birth}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_role" class="col-sm-4 control-label">회원등급</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="role" name="role" value="${member.role}" readonly="readonly"/>
						</div>
					</div>
				</fieldset>
			</form>
			<div class="input_button text-center">
					<button class="btn btn-primary" id="updateBtn">수정 폼으로 이동</button>
					<button class="btn btn-primary" id="deleteBtn">회원탈퇴</button>
			</div>
		</div>
	</div>
</body>