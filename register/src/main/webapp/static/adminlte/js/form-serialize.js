$.fn.serializeObject = function()    
		{    
		   var o = {};    
		   var a = this.serializeArray();    
		   $.each(a, function() {    
		       if (o[this.name]) {    
		           if (!o[this.name].push) {    
		               o[this.name] = [o[this.name]];    
		           }    
		           o[this.name].push(this.value || '');    
		       } else {    
		           o[this.name] = this.value || '';    
		       }    
		   });    
		   return o;    
		};  
		
		
function cleanForm(form){
			
			$(':input',form)    
			 .not(':button, :submit, :reset, :hidden')    
			 .val('')    
			 .removeAttr('checked')    
			 .removeAttr('selected');    
			
		};