

//ID,PW,NAME,PHONE,EMAIL
//검사
const id=document.getElementById('id')
const pw=document.getElementById('pw')
const pw2 =document.getElementById('pw2')
const name = document.getElementById('name');
const phone =document.getElementById('phone')
const email = document.getElementById('email')
const btn = document.getElementById('btn');
const frm = document.getElementById('frm');
const idResult = document.getElementById('idResult')
const pwResult = document.getElementById('pwResult')
const pwResult2 = document.getElementById('pwResult2')

let idCheck = false;
let nameCheck = false;

// name.addEventListener("blur", function(){
//     let v = name.value;
//     nameCheck=true;
//     console.log('ss')
//     if(v==''){
//         nameCheck=false;
//         alert("이름을 입력하세요.")

//     }
// })

//--------pw와 pw2가 같은지 검증
let pwCheck=true;
pw2.addEventListener("blur", function(){
    pwCheck=true;
    let message = "pw가 일치합니다."
    if(pw.value!=pw2.value){
        pwCheck=true;
        message = "pw가 일치하지 않습니다."
        pw2.value='';
        
    }else{
        pwCheck=false;
    }
    pwResult2.innerHTML=message;
})


//--검증이 끝나고 pw를 수정 했을 경우
pw.addEventListener('change',function(){
    pwCheck=true;
    pw2.value='';
    pwResult2.value='';
    pw2.focus();

})

//--------pw길이 검증
pw.addEventListener('blur',function(){
    if(pw.value.length<8||pw.value.length>12){
        pwResult.innerHTML="PW의 글자수가 맞지 않습니다."
        
     

    }
})

//----id 입력 후
id.addEventListener('blur', function(){
    if(this.id.value==''){
        idResult.innerHTML="ID를 입력하세요"
        
    }
})



//가입버튼
btn.addEventListener("click",function(){
    if(id.value==''){
        alert('ID를 입력하세요.')
        id.focus();
    return;
    }

    if(pw.value==''|| pw.value.length<8 || pw.value.length>12){
        alert('pw가 정확하지 않습니다.')
        pw.focus();
        return;
    }

    if(pwCheck){
        alert("pw가 일치하지 않습니다.")
        pw2.focus();
        return;
    }

    if(name.value==''){
        alert('name를 입력하세요.')
        name.focus();
        return;
    }

    if(phone.value==''){
        alert('phone를 입력하세요.')
        phone.focus();
        return;
    }

    if(email.value==''){
        alert('email를 입력하세요.')
        email.focus();
        return;
    }
})

// btn.addEventListener("click", function(){
//     if(nameCheck){
//         frm.submit();


//     }else{
//         alert("필수요건을 확인 하세요.")
//     }
// })