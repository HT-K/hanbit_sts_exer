/**
 * 자바에서 Constants (상수들을 모아놓음) 와 같은 기능을 할 js 파일이다.
 */

function Global(arg) { // 자바에서 생성자와 같다.
	this.context = arg;
};

// prototype => 자바의 최상위 객체인 Object와 같이 만들어 놓겠다는 의미이다.
// prototype => 자바의 @override와 같이 사용할 수 있도록 설정된다.
// 자바로 따지면 toString()과 비슷하게 되는 것 (toStrng()은 개발자가 원하는 형태로 오버라이드하여 사용할 수 있다.)
// => 즉, 다른 .js파일에서 prototype으로 설정한 함수를 오버라이드 할 수 있게 된다!
Global.prototype.setContext = function(context) { 
	this.context = context;
}
Global.prototype.getContext = function() {
	return this.context;
}
