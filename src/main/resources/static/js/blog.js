 $(document).ready(function(){
     $("button").click(function(){
         let url = "/api/v1/blogmenu?keyword=" + $("#keyword").val()
        $.getJSON(url, function(result){
            var html = "<h4>검색결과</h4>";
            $.each(result.items, function(i, field){
                //$("div").append(field + " ");
                // console.log(field.menu);
                // console.log(field.price); // console.log(field["price"]); 사용가능
                // console.log(field.img);
                html += "<a href = '" + field.link + "'target='_blank'>" + field.title + "</a><br>";
                // html += "<h5>" + field.price + "</h5>";
                // html += "<img src = ''" + field.img + ">";
                console.log(field.title);
            });
            $("#bloglist").html(html);
        });
    });
 });

