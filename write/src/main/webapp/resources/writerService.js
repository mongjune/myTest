/**
 * Created by kwon on 2016-05-03.
 */
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



})();