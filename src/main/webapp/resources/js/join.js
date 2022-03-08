/**
 * 
 */
 //함수 밖에서 선언된 얘네는 전역변수라 부름
 const pwResult = document.getElementById("pwResult");
 const pw = document.getElementById('pw');
 const pw2 =document.getElementById('pw2');
 const id = document.getElementById('id');
 const idResult = document.getElementById("idResult")
 const pwResult2 = document.getElementById("pwResult2")
 
 const frm = document.getElementById("frm");
 const btn = document.getElementById("btn");

 const name = document.getElementById('name');
 const phone = document.getElementById('phone');
 const email = document.getElementById('email');

 let idCheck = false;   //check Ok :True, Check X : False
 let pwCheck = false;

 let nameCheck = false;
 let phoneCheck = false;
 let emailCheck = false;

 pw.addEventListener("change",function(){
     pwCheck=false;
     pw2.value='';
     pwResult2.innerHTML='';
     pw2.focus();
 })

btn.addEventListener("click", function(){
    if(idCheck && pwCheck && nameCheck && phoneCheck && emailCheck){
        frm.submit();
    }else{
        alert("필수요건을 확인 하세요.")
    }
})
 
 pw.addEventListener("keyup",function(){
 	let length = pw.value.length;
     let message = '잘못된 비번';
     if(length>=8 && length <=12){
         message = "정상적인 비번";
     }
     pwResult.innerHTML=message;
 });
 
// id.addEventListener("blur",function(){
//     if(!id.value){
//         alert("ID를 입력하세요")
//     }

// })

id.addEventListener("blur", function(){
    idCheck=false
    let v=id.value;

if(v==''){

    idResult.innerHTML='필수입력'
    idCheck=false;
}else{
    idCheck=true;
}

})


pw2.addEventListener("blur", function(){
    
    let v1 = pw.value;
    let v2 = pw2.value;
    let message = "비번이 일치하지 않음"
    
    if(v1==v2){
        message = "비번이 일치 함"
        pwCheck=true;
    }else{
        pwCheck=false;
    }
    pwResult2.innerHTML=message;
})

name.addEventListener("blur",function(){
    if(name.value==''){
        nameCheck=false;
    }else{
        nameCheck=true;
    }
})

phone.addEventListener("blur",function(){
    if(phone.value==''){
        phoneCheck=false;
    }else{
        phoneCheck=true;
    }
})

email.addEventListener("blur",function(){
    if(email.value==''){
        emailCheck=false;
    }else{
        emailCheck=true;
    }
})