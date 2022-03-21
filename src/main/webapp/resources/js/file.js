const fileResult = document.getElementById('fileResult');
const fileAdd = document.getElementById("fileAdd");
const del = document.getElementsByClassName("del");


let i=0;

let num=0;   //id용도


fileAdd.addEventListener("click",function(){
    console.log("fileAdd Click");
    i=i+1;
    
    if(i<6){

        let div = document.createElement("div");    //div
        div.setAttribute("id", "del"+num);
        

    let data = document.createElement("input");
    data.setAttribute("type","file");
    data.setAttribute("name","files");

    let button = document.createElement("button");
    button.setAttribute("type","button");
    button.className="del";
    button.setAttribute("data-num","del"+num)
    button.innerHTML="DEL";

        div.append(data);
        div.append(button);

    fileResult.append(div);
    num++


    }else{
        alert("5개 이상 못만듬");
        i--;
    }
});
 
fileResult.addEventListener("click",function(event){
    
    let cn = event.target;
    i--;

    if(cn.classList.contains('del')){
       let delNum = cn.getAttribute("data-num");
       document.getElementById(delNum).remove();
    }
})