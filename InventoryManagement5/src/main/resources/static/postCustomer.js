$(document).ready(function(){
	$("#myform").submit(function(){
		alert("hello");
		postCustomer();
		});
		
		function postCustomer(){
		
			var dataPost={
			name: $("#name").val(),
				}
		console.log(name);
		$.ajax({
			url: '/saveCustomer',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(dataPost),
			dataType: 'json',
			success : function(data){
				console.log(data);
			}
		});
					
		}
		

	
});