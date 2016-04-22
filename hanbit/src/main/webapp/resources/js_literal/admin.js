/**
 * admin 페이지관련
 */

var admin = {
		/*context : '',
		setContext : function(context) {
			this.context = context;
		},
		getContext : function() {
			return this.context;
		},*/
		
		list : function(context) {
			alert("admin.list() 진입 체크");
			$.getJSON(context+'/admin/admin_list',function(data) { // 이름 그대로 JSON형태의 값을 가져오는 함수다. , 왼쪽에는 호출할 URL, 오른쪽에는 호출한 URL에서 받아온 JSON(=data)을 활용할 function()이 위치한다.
				var admin_list = 
					'<div class="container" style="width:1000px;height:450px; margin:0 auto;">'
					+	'<table class="table table-hover" id="admin_list" style="width:100%;margin-top: 30px">'
					+		'<tr class="danger">'
					+			'<th>아이디</th>'
					+			'<th>이름</th>'
					+			'<th>비밀번호</th>'
					+			'<th>주소</th>'
					+			'<th>생년월일</th>'
					+			'<th>역할</th>'
					+			'<th>담당과목</th>'
					+		'</tr>';
					// 이 부분(테이블의 일부)에는 컨트롤러에서 list로 가져온 값들이 들어가는 부분으로 자바의 for-each와 같은 제이쿼리의 $.each 구문으로 반복문을 돌리면서 테이블 생성 및 값을 넣는다.
					// 컨트롤러에서 받아온 리스트의 이름이 'list'라서 data.list라고 왼쪽에 써줘야하고
					// 받아온 리스트로 구현할 함수 function선언해주고 매개변수에는 각 리스트의 인덱스를 뜻하는 'index', 그 하나하나의 값을 뜻하는 'value'를 적어줘야한다.
					// 리스트 안의 값들에 접근할 때는 value.변수명을 해주면 가지고 온 리스트의 값들에 접근 할 수 있게 된다.
					$.each(data, function(index, value) { 
						admin_list +=
							'<tr>'
							+	'<td> '+ this.id+' </td>'
							+	'<td><a class="adminProfile" href="'+ context+ '/admin/admin_profile/'+ this.id +'"> '+ this.name +' </a></td>'
							+	'<td> '+ this.password +' </td>'
							+	'<td> '+ this.addr +' </td>'
							+	'<td> '+ this.birth +' </td>'
							+	'<td> '+ this.role +' </td>'
							+	'<td> '+ this.subjName +' </td>'
							+'</tr>';
					});	// each() End
					admin_list += '</table></div>';
					// 위에서 구한 것들을 div wrapper에 .html 해준다.
					// member_list가 지역변수라서 .html, .css 모두 이곳에 써줘야한다.
					$('#content').html(admin_list); // content div 안에 있는 내용을 모두 .empty()하고 그안에 매개변수에 있는 내용을 띄워준다
			        $('#admin_list th').css('text-align', 'center');
			        $('#admin_list tr td').css('text-align', 'center');
					
			        $('.adminProfile').click(function(e) {
						e.preventDefault(); // 이 함수로 인해 a태그의 기능(URL을 호출해서 페이지 이동 하려는 것)이 무력화된다.
						var url = $(this).attr('href'); // a 태그에 있는 href의 내용 즉 url을 var url에 저장한다.
						admin.adminProfile(url);
					});
			}); // getJSON() End
		},
		
		memberProfile : function(url) { // member.js 에서 url을 받아온다.
			$.getJSON(url, function(data) {
				var member_profile = 
					'<div class="container">'
					+	'<table class="table" id="member_profile" style="margin-top: 30px">'
					+		'<tr class="danger">'
					+				'<th>프로필 이미지</th>'
					+				'<th>항목</th>'
					+				'<th>내용</th>'
					+		'</tr>'
					+		'<tr>'
					+			'<td rowspan="9">'
					+				'<img src="'+member.getContext()+'/resources/img/member/cho.jpg" />'
					+			'</td>'
					+			'<td>아이디</td>'
					+			'<td>'+data.id+'</td>'
					+		'</tr>'
					+		'<tr>'
					+			'<td>비밀번호</td>'
					+			'<td>'+data.password+'</td>'
					+		'</tr>'
					+		'<tr>'
					+			'<td>이름</td>'
					+			'<td>'+data.name+'</td>'
					+		'</tr>'
					+		'<tr>'
					+			'<td>생년월일</td>'
					+			'<td>'+data.birth+'</td>'
					+		'</tr>'
					+		'<tr>'
					+			'<td>주소</td>'
					+			'<td>'+data.addr+'</td>'
					+		'</tr>'
					+		'<tr>'
					+			'<td>이메일</td>'
					+			'<td>'+data.email+'</td>'
					+		'</tr>'
					+		'<tr>'
					+			'<td>등록일</td>'
					+			'<td>'+data.regDate+'</td>'
					+		'</tr>'
					+	'</table>'
					+'</div>';
					
				$('#content').html(member_profile); // content div 안에 있는 내용을 모두 .empty()하고 그안에 매개변수에 있는 내용을 띄워준다
				$('#member_profile th').css('text-align', 'center');
		        $('#member_profile tr td').css('text-align', 'center');
			});
		},
		
		adminProfile : function(url) {
			
		}
}