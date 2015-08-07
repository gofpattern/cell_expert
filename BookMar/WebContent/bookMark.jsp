<!DOCTYPE html>
<html>

  <head>
    <link rel="stylesheet" href="style.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript">
    function createInput(){
        var bookmark = prompt("Please enter name of the bookmark", "bookmark name");
    
      
        var $input = $('<input type="button" />').attr("id",bookmark);
        $input.attr("id",bookmark);
        $input.attr("value",bookmark);
        $input.appendTo($("body"));
		var $input = $('<input type="text"/>');
		$input.attr("id",bookmark);
        $input.attr("name",bookmark);
        $input.appendTo($("body"));
		$("body").append('</br>');
		
        
        
    }
    </script>
  </head>

  <body>
    <button onclick="createInput();" >Create BookMark</button>
	<form action="/BookMarkApp/IBookMark" method="GET">
	
		 <input type="submit"value="Submit" />
	</form>
	</br>
  </body>

</html>