<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<style type="text/css">
.divTable {
	margin-top: 50px;
}

.jikoRow {
	height: 500px;
}
</style>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>




	<div class="container">
		<h1>Dashboard</h1>

		<div class="pull-right">
			<button id="startJikoForm" class="btn btn-success"
				data-toggle="modal" data-target="#jikoForm">Start Jiko</button>
		</div>




		<div class="divTable">

			<div class="modal fade" id="jikoForm" role="dialog">
				<div class="modal-dialog ">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Start Jiko</h4>
						</div>
						<div class="modal-body">
							<form modelAttribute="jikoStart" method="post" action='<c:url value="/runContainer"></c:url>'>
								

									<label>Environment variable</label><input type="text" name="env" id="env" 
										class="form-control" />
									


						
						</div>
						<div class="modal-footer">
							<button type="submit" id="startContainer" class="btn btn-success">Start</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
							</form>
					</div>
				</div>
			</div>
		</div>

		<div class="table-responsive">

			<input type="hidden" class="url"
				value="${pageContext.request.contextPath}" />
			<table id="containerInformation"
				class="table table-bordered table-striped table-hover">
				<thead>
					<th>Id</th>
					<th>Components</th>

				</thead>
				<tbody id="containerBvod">





					</td>
					</tr>

				</tbody>
			</table>
		</div>
	</div>
	</div>

	<script type="text/javascript">
		
		$(document).ready(function(){
			
			var url="/new";
			var row = $("<tr/>")
			 $.getJSON("/message", null, function (data) {
                 var content = "";
                 
                 $.each(data, function (i, o) {
                	 console.log("i", i);
                	 console.log("o", o);
                	 var id = o.id;
                	 var row = $('<tr></tr>');
                	 var subTable = $('<table></table>').addClass('table table-bordered table-striped table-hover');
                	 var btnAction = $('<button>',{
                		text : "Action" 
                	 });
                	 var $tr = $('<tr>').append(
            				 $('<th>').text("Name"),
            				 $('<th>').text("Container Id"),
             	            $('<th>').text("CPU Percentage"),
             	            $('<th>').text("Memory Usage"),
             	           $('<th>').text("Action")
             	           
             	          
             	           
             	        ).appendTo(subTable); 
                	 var healthData = o.health;
                	 $.each(healthData, function (index, object) {
                		 var cpu_percent = object.cpu_percent;
                		 var memory_usage=object.memory_usage/8388608;
                		 var name=object.name;
                		 var containerId=object.cid;
                		 
                		 
                		 var $tr = $('<tr>').append(
                				 $('<td>').text(name),
                				 $('<td>').text(containerId),
                 	            $('<td>').text(cpu_percent),
                 	            $('<td>').text(memory_usage),
                 	           $('<td>').html("<a href=\"stopContainer/"+containerId+"\" class=\"btn btn-warning\" id=\"stopContainer\">Stop</a>")
                 	          
                 	           
                 	        ).appendTo(subTable); 
                		 //$($tr).append("<td>hello</td>")
                		 
                		 
                		 
                		// var r ="<tr><td>"+name+"</td><td>"+containerId+"</td><td>"+memory_usage+"</td><td>"+cpu_percent+"</td><td>"+"<a href=\"stopContainer/"+containerId+"\" class=\"btn btn-warning\" id=\"stopContainer\">Stop</a>"+"</td></tr>";
                		 //$("#jikoDetails").append(r);
                		 //console.log("index", index);
                    	 //console.log("object", object);                 	
                    	
                	});
                	 row.append(
                			 $('<td>').text(id),
                			 $('<td>').append(subTable)
                			 ).appendTo("#containerInformation");
                	 
                	 //var $tr = $('<tr>').append(
                	  //          $('<td>').text(id)
                	           
                	       // ).appendTo("#containerInformation"); 
                	// var subTable = $('<table></table>');
                	 
                	 
                	 //var row ="<td>"+id+"</td>";
                	 //$(".jikoRow").append(row);
                	 
                	
                    
                     
                 });
             });

		});
	</script>
<!-- 	<script type="text/javascript">
		var container={};
		$("#startContainer").click(function(){
			alert("button clicked");
			container={
			image=$("#image").val()
			
					
			}
			$.ajax({
				type:"POST",
				url:"stopContainer/{containerId}",
				data:JSON.stringify(container),
				success:function(){
					console.log("successfully started container")
				}
			});
		});
		
			
		
	</script> -->
</body>
</html>