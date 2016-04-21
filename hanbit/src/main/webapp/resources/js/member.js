/**
 * record
 */
var member = {
	context : '',
	setContext : function(context) {
		this.context = context;
	},
	getContext : function() {
		return this.context;
	},
	
	list : function() {
		alert("member.list() 진입 체크");
		$.getJSON(member.getContext()+'/member/member_list',function(data) { // 이름 그대로 JSON형태의 값을 가져오는 함수다. , 왼쪽에는 호출할 URL, 오른쪽에는 호출한 URL에서 받아온 JSON(=data)을 활용할 function()이 위치한다.
			var member_list = 
				'<div class="container" style="width:1000px;height:450px; margin:0 auto;">'
				+	'<table class="table table-hover" id="member_list" style="width:100%;margin-top: 30px">'
				+		'<tr class="danger">'
				+			'<th style="text-align: center;">아이디</th>'
				+			'<th>이름</th>'
				+			'<th>전공</th>'
				+			'<th>수강과목</th>'
				+			'<th>주소</th>'
				+			'<th>생년월일</th>'
				+		'</tr>';
				// 이 부분(테이블의 일부)에는 컨트롤러에서 list로 가져온 값들이 들어가는 부분으로 자바의 for-each와 같은 제이쿼리의 $.each 구문으로 반복문을 돌리면서 테이블 생성 및 값을 넣는다.
				// 컨트롤러에서 받아온 리스트의 이름이 'list'라서 data.list라고 왼쪽에 써줘야하고
				// 받아온 리스트로 구현할 함수 function선언해주고 매개변수에는 각 리스트의 인덱스를 뜻하는 'index', 그 하나하나의 값을 뜻하는 'value'를 적어줘야한다.
				// 리스트 안의 값들에 접근할 때는 value.변수명을 해주면 가지고 온 리스트의 값들에 접근 할 수 있게 된다.
				$.each(data, function(index, value) { 
					member_list +=
						'<tr>'
						+	'<td> '+ this.id+' </td>'
						+	'<td><a class="memberProfile" href="'+ member.getContext()+ '/admin/member/profile/'+ this.id +'"> '+ this.name +' </a></td>'
						+	'<td> '+ value.major +' </td>'
						+	'<td> '+ value.subject +' </td>'
						+	'<td> '+ this.addr +' </td>'
						+	'<td> '+ this.birth +' </td>'
						+'</tr>';
				});	// each() End
				member_list += '</table></div>';
				// 위에서 구한 것들을 div wrapper에 .html 해준다.
				// member_list가 지역변수라서 .html, .css 모두 이곳에 써줘야한다.
				$('#content').html(member_list); // content div 안에 있는 내용을 모두 .empty()하고 그안에 매개변수에 있는 내용을 띄워준다
		        $('#member_list th').css('text-align', 'center');
		        $('#member_list tr td').css('text-align', 'center');
				
		        $('.memberProfile').click(function(e) {
					e.preventDefault(); // 이 함수로 인해 a태그의 기능(URL을 호출해서 페이지 이동 하려는 것)이 무력화된다.
					var url = $(this).attr('href'); // a 태그에 있는 href의 내용 즉 url을 var url에 저장한다.
					admin.memberProfile(url);
				});
		}); // getJSON() End
	}, // list() End
	
	update : function() {
		alert("수정 버튼 클릭 체크");
		$.ajax({ // 객체를 파라미터로 보낸다.
			url : member.getContext() + "/member/update",
			date : {
				//"id" : $('#id').val(),
				profileImg : $('#profile_img').val(),
				password : $('#password').val(),
				addr : $('#addr').val()
			},
			// dataType 과 type은 보낼 때 값과 보내는 방식을 의미
			dataType : 'json',
			type : 'post',
			// 아래 두개 타입은 컨트롤러에 갔다 올 때 받아오는 값의 형태를 의미
			contentType : 'application/json',
			mimeType : 'application/json',
			success : function(data) {
				alert('수정 성공' + data.profileImg);
			},
			error : function(xhr, status, msg) { // 실패하면 이곳으로, 왼쪽 매개변수는 정해져 있다.
				alert('에러 발생 상태 : '+status+' 내용 : '+msg);
			}
		});
	}
};