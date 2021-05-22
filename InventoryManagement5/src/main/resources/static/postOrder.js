$(document).ready(function(){
	var i=0;
	var k=0;
	$("#btn").click(function(){
			
			$("#fig").append("<div>Stocks id :<input type='number' id='id"+i+"'> Stock name :<input type='text' id='name"+i+"'> </div>");
			i++;
		});
	
		$("#btn1").click(function(){
			
			$("#fig1").append("<div>Quantity :<input type='number' id='quantity"+k+"'> Stock id :<input type='number' id='sid"+k+"'> </div>");
			k++;
		});
	
	$("#btn2").on("click",function(){
		var stock=[];
		for(var j=0;j<i;j++){
		var stocks={};
		id="id"+j;
		name="name"+j;
		console.log(id);	
		stocks.id =document.getElementById(id).value;
		stocks.name =document.getElementById(name).value;
		stock.push(stocks);	
		
		var product=[];
		for(var l=0;l<k;l++){
		var products={};
		var stockAvail={}
		quantity="quantity"+l;
		id="sid"+l;
		alert(id);
		console.log(id);	
		quantity =document.getElementById(quantity).value;
		stockAvail.id =document.getElementById(id).value;
		alert(stockAvail.id);
		 products= {
			"quantity": quantity,
			stockAvail: stockAvail,
		}
		product.push(products);	
		
		}
		console.log(product);
		}
		
		 var customer={
			"id": $("#id").val(),
		}
		
	var dataPost={
		
		product: product,
		customer: customer,
		stock: stock
		}
		alert(dataPost.name+" "+dataPost.boxOfficeCollection+" "+dataPost.rating);
		postFilm(dataPost);
		
		
	});
	
	
	function postFilm(dataPost){
		$.ajax({
			url: '/saveOrder',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(dataPost),
			dataType: 'Json',
			success: function(data){
				console.log(data);
			}
			
		});
	}
	
});