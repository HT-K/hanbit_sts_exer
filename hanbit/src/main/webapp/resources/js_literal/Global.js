/**
 * 자바에서 Constants (상수들을 모아놓음) 와 같은 기능을 할 js 파일이다.
 */

function Global(arg) { // 자바에서 생성자와 같다.
	this.context = arg;
};
// prototype => 자바의 @override와 같다
// prototype => 자바의 최상위 객체인 Object와 같이 만들어 놓는다는 의미이다.
// => 다른 .js파일에서 prototype으로 설정한 함수를 오버라이드 할 수 있게 된다!
Global.prototype.setContext = function(context) { 
	this.context = context;
}
Global.prototype.getContext = function() {
	return this.context;
}
