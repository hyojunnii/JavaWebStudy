//window.onload = function () {
//  console.log(1111);
//};

//window.onload = function () {
//  console.log(2222);
//};

//jQuery(document).ready(function () {
//  console.log("제이쿼리 잘 되나요");
//});

//jQuery(document).ready(function () {
//  console.log("네~~");
//});

$(function () {
  console.log("제이쿼리 잘 되나요");

  console.log($("#target")[0]); //jquery는 배열형태로 가져옴

  //const h3 = $("h3");
  //for (let i = 0; i < h3.length; ++i) {
  //  h3[i].style.backgroundColor = "red";
  //}

  $("h3").css("backgroundColor", "red");

  $("#target").css("backgroundColor", "red");
  $("#target").css("width", "100px");
  $("#target").css("height", "100px");
});
