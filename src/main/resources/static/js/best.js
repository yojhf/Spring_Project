 $(document).ready(function(){
        $.getJSON("/api/v1/bestmenu", function(result){
            var html = "";
            $.each(result, function(i, field){
                //$("div").append(field + " ");
                // console.log(field.menu);
                // console.log(field.price); // console.log(field["price"]); 사용가능
                // console.log(field.img);
                html += "<h3>" + field.menu + "</h3>";
                html += "<h5>" + field.price + "</h5>";
                html += "<img src = ''" + field.img + ">";

        });
        $("#bestmenu").html(html);
    });
 });

