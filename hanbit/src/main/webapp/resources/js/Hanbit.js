/**
 * Hanbit 팩토리 : 즉시 실행함수 
 */

// 팩토리 패턴의 예이다.
// $는 제이쿼리를 뜻하고 fn은 prototype를 줄인 것이다.
// $.fn.extend 안에 함수를 만들면 $.fn.함수이름으로 호출할 수 있게 된다.
// 예를 들면 var article = $.fn.article(); ==> Article.jsp에 있는 function Article(){} 의 객체를 생성한 것이다.
// 우리는 article(var 변수)로 function Article(){} 안에 만들어진 함수에 접근할 수 있게 된다!
(function() {
	$.fn.extend({
		/*admin : function() {
			return new Admin();
		},*/
		article : function() {
			return new Article();
		},
		global : function(arg) {
			return new Global(arg);
		},
		/*grade : function() {
			return new Grade();
		},*/
		member : function() {
			return new Member();
		},
		/*record : function() {
			return new Record();
		},
		subject : function() {
			return new Subject();
		}*/
	});
})();

/*//$는 제이쿼리를 뜻하고 fn은 prototype를 줄인 것이다. attr은 attribute를 줄인 것
$.fn.attr = function() {
	
}*/

