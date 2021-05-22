$(document).ready(function(){
	

	

		$.ajax({
			url: '/getStock',
			type: 'GET',
			success: function(data){
	
			
				
				$.each(data, function(i , stock){
					
					var stockRow = '<tr>'+
										'<td>' +  stock.id + '</td>' +
										'<td>' + stock.name + '</td>' +
										'<td>' + stock.price + '</td>' +
										'<td>' + stock.productType + '</td>' +
										'<td>' + stock.quantitys + '</td>' +
										'</tr>';

						$('#stockTable tbody').append(stockRow);


				});
			
			
			},
			error: function(data){
				alert("Not Found");
			}
			
		});
	
	
});