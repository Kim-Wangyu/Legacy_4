/**
 * 
 */
 
 const check=document.getElementsByClassName('check');
 const checkAll=document.getElementById('checkAll');
 const btn = document.getElementById('btn');
 
 
 checkAll.value = false;
 
 checkAll.addEventListener('click',function(){
 	
 	for(c of check){
 		c.checked =checkAll.checked
 	}

 }); 	


for(ch of check){
	ch.addEventListener("click",function(){
		let final=true;
 	
		for(c of check){
			if(!c.checked){
				final=false;
			}
		}
		checkAll.checked=final;
	})
};


btn.addEventListener("click", function(){

	// let c= true;

	// for(ch of check){
	// 	if(!ch.checked)
	// 	c=false;
	// }

	if(checkAll.checked){
	location.href="./join"
	}else{
		alert("약관 동의 필요");
	}
});