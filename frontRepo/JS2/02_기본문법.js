//1. 변수와 자료형
//전역변수 선언
str1 = "전역변수";

var str2 = "전역변수"; //함수 밖에 있으면 전역변수

//페이지가 모두 로드되면 자동으로 실행되는 함수 구현
window.onload = function () {
  var str1 = "지역변수";
  var str3 = "지역변수";
  var str4;

  console.log(str1); //지역
  console.log(window.str1); //전역
  console.log(this.str1); //전역

  console.log("--------------------");

  console.log(str2); //전역
  console.log(window.str2); //전역
  console.log(this.str2); //전역

  console.log("--------------------");

  console.log(str3); //지역
  console.log(window.str3); //un
  console.log(this.str3); //un

  console.log("--------------------");

  console.log(str4); //un
  console.log(typeof str4); //un

  console.log(this);

  console.log("-----중복 선언 테스트------");

  //var, let, const
  // 1) 중복 선언

  var num = 0;
  console.log(num);

  var num = 10;
  console.log(num);

  var num = 100;
  console.log(num);

  console.log("--------------------------");

  let numLet = 10;
  console.log(numLet);

  // let numLet = 20;
  //console.log(numLet)

  numLet = 20;
  console.log(numLet);

  console.log("--------------------------");

  const numConst = 0;
  console.log(numConst);

  // numConst = 10;
  // console.log(numConst);

  // 2) 유효 범위 (스코프)
  // - 함수 안에서 var 키워드로 선언된 변수는 함수 유효 범위를 갖는다.
  // - 함수 안에서 let,const 키워드로 선언된 변수는 블록 유효 범위를 갖는다.

  if (true) {
    var temp = 10; //if문에서 안죽고 함수전체에서 동작 (var)
    console.log("if문 안쪽 temp : " + temp);
  }
  console.log("if문 바깥 temp : " + temp);
}; //window.onload function

//자료형 테스트
function typeTest() {
  let name = "심원용"; //문자열
  let age = 20; //숫자
  let height = 183.7; //숫자
  let check = false; //논리
  let food = ["치킨", "피자", "제육"]; //배열, 객체
  //객체
  let user = {
    name: "심원용",
    age: 20,
    height: 183.7,
    weight: 88.8,
    food: ["치킨", "피자", "제육"],
  };
  //함수
  let plus = function (a, b) {
    return a + b;
  };
  let etc = "";

  console.log(typeof name);
  console.log(typeof age);
  console.log(typeof height);
  console.log(typeof check);
  console.log(typeof food);
  console.log(typeof user);
  console.log(typeof plus);
  console.log(typeof let);
}

//강제 형변환
function castingTest() {
  console.log("--------casting---------");

  var result = 2 + "3";
  console.log(result); //23

  var result = 2 + Number("3");
  console.log(result); //5

  var result = String(2) + Number("3");
  console.log(result); //23

  var result = 2 + parseInt("3");
  console.log(result); //5

  var result = 2 + parseFloat("3");
  console.log(result); //5
}

function forInTest() {
  let arr = ["apple", "banana", "tomato"];

  //for in
  for (let i in arr) {
    console.log(i);
    console.log(arr[i]);
  }

  console.log("-------------------");

  //ES6에 추가된 for문
  for (let x of arr) {
    console.log(x);
  }
}
