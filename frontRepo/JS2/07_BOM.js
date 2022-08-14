console.log(window);

function f01() {
  result = window.open("http://192.168.0.150:5500/new.html", "naver", "width=300px", "height=300px", "resizable=none");
  window.setTimeout(function () {
    console.log(result.document);
    result.document.getElementById("v").value = "부모가 보낸 값";
  }, 1000);
}

function f02() {
  window.open("https://www.google.com", "zzz", "width=300px", "height=300px", "resizable=none");
}

function sendValue() {}

function sayHello() {
  window.setTimeout(function () {
    console.log("hello");
  }, 2000);
}

function sayBye() {
  window.setInterval(function () {
    console.log("bye");
  }, 2000);
}

function locationTest() {
  for (var k in location) {
    // console.log(k + ": " + location[k]);
    console.log(`${k}: ${location[k]}`);
  }
}
