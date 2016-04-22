/**
 * subject
 */

var subject = {
		/*context : '', 
		// 달러{context} 경로를 jsp에서 받아와서 위 context에 저장한다.
		setContext : function(context) {
			this.context = context;
		},
		getContext : function() {
			return this.context;
		},*/
		
		list : function(context) {
			alert("suject list 진입 체크");
			$.getJSON(context+'/subject/list',function(data) { // 이름 그대로 JSON형태의 값을 가져오는 함수다. , 왼쪽에는 호출할 URL, 오른쪽에는 호출한 URL에서 받아온 JSON(=data)을 활용할 function()이 위치한다.
				var subject_list = 
					'<div class="container" style="width:1000px;height:450px; margin:0 auto;">'
					+	'<table class="table table-hover" id="subject_list" style="width:100%;margin-top: 30px">'
					+		'<tr class="danger">'
					+			'<th style="text-align: center;">No</th>'
					+			'<th>과목명</th>'
					+			'<th>담당교수</th>'
					+		'</tr>';
					// 이 부분(테이블의 일부)에는 컨트롤러에서 list로 가져온 값들이 들어가는 부분으로 자바의 for-each와 같은 제이쿼리의 $.each 구문으로 반복문을 돌리면서 테이블 생성 및 값을 넣는다.
					// 컨트롤러에서 받아온 리스트의 이름이 'list'라서 data.list라고 왼쪽에 써줘야하고
					// 받아온 리스트로 구현할 함수 function선언해주고 매개변수에는 각 리스트의 인덱스를 뜻하는 'index', 그 하나하나의 값을 뜻하는 'value'를 적어줘야한다.
					// 리스트 안의 값들에 접근할 때는 value.변수명을 해주면 가지고 온 리스트의 값들에 접근 할 수 있게 된다.
					$.each(data.list, function(index, value) { 
						subject_list +=
							'<tr>'
							+	'<td> '+ value.subjSeq +' </td>'
							+	'<td><a href="'+ context+ '/subject/'+ value.subjSeq +'"> '+ value.subjName +' </a></td>'
							+	'<td><a href="'+ context+ '/admin/'+ value.profId +'"> '+ value.profName +' </a></td>'
							+'</tr>';
					}); // each() End
					subject_list += '</table></div>';
					// 위에서 구한 것들을 div wrapper에 .html 해준다.
					// subject_list가 지역변수라서 .html, .css 모두 이곳에 써줘야한다.
					$('#content').html(subject_list);
					 $('#subject_list th').css('text-align', 'center');
			         $('#subject_list tr td').css('text-align', 'center');
			}); // getJson() End
		} // list() End
}