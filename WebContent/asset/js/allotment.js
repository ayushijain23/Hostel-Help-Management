/**
 * 
 */
$('document').ready(function(){
	
	$.getJSON('headacheJSON',{ajax:true},
			function(data){
		  
		 $('#hostelid').empty();
		    $('#hostelid').append($('<option>').text('-Select-'));
		   
		    $.each(data,function(i,item){
		    
		  $('#hostelid').append($('<option>').text(item.HOSTELNAME).attr('value',item.HOSTELID));	
		    	
		    	
		    });
		
	
	});
	$('#hostelid').change(function(){
		
		$.getJSON('roombyhostelidJSON',{hostelid:$('#hostelid').val(),ajax:true},
				function(data){
		       
			$('#roomno').empty();
		    $('#roomno').append($('<option>').text('-Select-'));
		   
		    $.each(data,function(i,item){
		    
		  $('#roomno').append($('<option>').text(item.ROOMNO).attr('value',item.ROOMNO));	
		    	
		    	
		    });
		
		
		});	
		
		
	});
});