let input = document.querySelector(".task-input");
let ul = document.querySelector(".task-list");
function deletetask(e){
    e.currentTarget.remove();
}
input.addEventListener("keypress",function(e){
    if(e.key == "Enter"){
        let task = input.value;
        if(!task){
            alert("Error: Empty Task!");
            return;
        }
        input.value = "";
        let li = document.createElement("li");
        li.innerHTML = task;
        li.addEventListener("dblclick",deletetask);
        ul.appendChild(li);
    }
});