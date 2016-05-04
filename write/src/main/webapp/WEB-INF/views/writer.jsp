<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<style>
    .cvs{width:300px; height:300px; border-radius: 10px;  position: absolute;
        top: 50px;
        left: 50px; z-index: 100;}
    .uper{width:400px; height:400px; border-radius: 10px;  z-index: -10 ; background-color: #111111}
    .cvs2{width:300px; height:300px; border-radius: 10px;  position: absolute; background-color: #fc8c84;
        top: 50px;
        left: 50px; z-index: 50;}
    .cvs3{width:300px; height:300px; border-radius: 10px;  position: absolute; background-color: beige;
        top: 50px;
        left: 50px; z-index: 70;}
    .hanList{
        width:300px; height:300px; border-radius: 10px;  position: absolute; background-color: aliceblue;
        top: 50px;
        left:450px; z-index: 50;
    }
</style>
<div class="uper">
    <canvas class="cvs">

    </canvas>
    <canvas class="cvs2">
    </canvas>

    <canvas class="cvs3">
    </canvas>

</div>
<div class="hanList">
    <table class="tbl">

    </table>

</div>

<div>
    <img src="11.jpg"  id = 'canvasImg'>
</div>
<button class="canvasbtn">이미지로 만들기</button>
<div class="cntdiv">

</div>

<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
<script>

var writerService = (function () {

    var headerObj = {"Content-Type":"application/json"};

    var list = function (Wnum) {

        $.getJSON("http://localhost:7944/writer/"+Wnum, function (data) {
            console.log("Writer: "+ data);
        });

    };

    return {
        list:list
    }



});
</script>

<script>


    var c = document.querySelector(".cvs");
    var ctx = c.getContext("2d");
    ctx.beginPath();
    ctx.moveTo(c.width/2, 0);
    ctx.lineTo(c.width/2, c.height);
    ctx.stroke();
    var c2 = document.querySelector(".cvs2");
    var ctx2 = c2.getContext("2d");

    var c3 = document.querySelector(".cvs3");
    var ctx3 = c3.getContext("2d");
    ctx3.beginPath();
    ctx3.moveTo(c.width/2, 0);
    ctx3.lineTo(c.width/2, c.height);
    ctx3.moveTo(0, c.height/2);
    ctx3.lineTo(c.width, c.height/2);
    ctx3.stroke();

    var drag = false;
    var clickcnt = 0;
    var px,py,lx,ly;
    var  prevX = 0, currX = 0, prevY = 0, currY = 0;
    var pointList = new Array();
    var pointcnt = 1;
    var edgeList = new Array();

    function drawCircle(pre,cur) {
        ctx.beginPath();
        ctx.moveTo(pre.x, pre.y);
        ctx.lineTo(cur.x, cur.y);
        ctx.stroke();
    }

    function erase() {

        ctx.clearRect(0, 0, c.width, c.height);
        document.getElementById("canvasimg").style.display = "none";
    }

    function canvasX(clientX) {
        var bound = document.querySelector(".cvs").getBoundingClientRect();
        return (clientX - bound.left) * (document.querySelector(".cvs").width / bound.width);
    }
    function canvasX2(clientX) {
        var bound = document.querySelector(".cvs2").getBoundingClientRect();
        return (clientX - bound.left) * (document.querySelector(".cvs2").width / bound.width);
    }

    function canvasY2(clientY) {
        var bound = document.querySelector(".cvs2").getBoundingClientRect();
        return (clientY - bound.top) * (document.querySelector(".cvs2").height / bound.height);
    }

    function canvasY(clientY) {
        var bound = document.querySelector(".cvs").getBoundingClientRect();
        return (clientY - bound.top) * (document.querySelector(".cvs").height / bound.height);
    }
    function mkimg() {
        var myImage = document.getElementById('canvasImg');
        myImage.src = document.querySelector(".cvs2").toDataURL();
    }


    $('.cvs').on('mousedown',function (event) {
        px = canvasX2(event.clientX);
        py = canvasY2(event.clientY);

        pointList[clickcnt]=new Array();

        var point = {x:px, y:py};
        console.log(point);
        pointList[clickcnt][0]=point;

        edgeList.push(point);


        drag= true;
    });

    $('.cvs').on('mouseup',function (event) {

        drag= false;

        ctx2.moveTo(px,py);
        lx = canvasX2(event.clientX);
        ly = canvasY2(event.clientY);
        ctx2.lineTo(lx,ly);
        ctx2.stroke();
        clickcnt++;
        pointcnt = 1;

        var point = {x:lx, y:ly};
        edgeList.push(point);

        console.log("횟수  "+clickcnt);

    });


    $('.cvs').on('mousemove',function (event) {
        if(drag) {
            var x = canvasX(event.clientX);
            var y = canvasY(event.clientY);
            var point = {x:x, y:y};
            pointList[clickcnt][pointcnt]=point;
            drawCircle( pointList[clickcnt][pointcnt-1], pointList[clickcnt][pointcnt] );
            pointcnt++;
        }
    })

    $('.canvasbtn').on('click',function (event) {
        var str ="";

        if(clickcnt>0){

            writerService.list(clickcnt, function (result) {
                str+="<tr>";
                for(var i=1; i<=result.length;i++){
                    str += "<td>"+result[i-1].chinesetext+result[i-1].meantext+"</td>"
                    if(i%4==0){
                        str+="</tr><tr>"
                    }

                }
                $('.tbl').html(str);
                mkimg();
                erase();
            });
            clickcnt = 0;
        }


    })

</script>
</body>
</html>


    