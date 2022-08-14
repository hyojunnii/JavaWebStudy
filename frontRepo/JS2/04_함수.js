function test1() {
  alert("test1 호출..");
}

const btn1 = document.getElementById("btn1");
btn1.addEventListener("click", function () {
  alert("익명함수 실행됨..");
});

//자동 실행 함수
// (function () {
//   alert("자동실행 함수 호출됨...");
// })();

//arrow function test
var arrowFunc = (a) => {
  var result = a * 10;
  return result;
};

// console.log(arrowFunc(10));

const btn2 = document.getElementById("btn2");

btn2.addEventListener("click", function () {
  console.log("가변 인자 테스트 버튼 클릭됨..");
  //   argTest("값전달", "두번째값", "세번째값");
  sum(10, 20, 30);
});

function argTest(v) {
  alert(v);
  console.log(arguments);
}

function sum() {
  var result = 0;
  for (let i = 0; i < arguments.length; ++i) {
    result += arguments[i];
  }
  console.log(result);
}

const btn3 = document.getElementById("btn3");
btn3.addEventListener("click", function () {
  var result = getAnonymousFunc();
  console.log(result);
  result();
});

function getAnonymousFunc() {
  var count = 3; //참조가 끊어지지 않아서 계속 살아있음
  return function () {
    alert(count);
  };
}

var old = getOldFunc();

function getOldFunc() {
  var age = 20;
  return function () {
    alert(age);
    age++;
  };
}
