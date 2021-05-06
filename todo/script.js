function addTodo(){

    var i=0;
    document.getElementById("todo_table").style.display ="block";

    document.getElementById("todo_table");
    
    var todo = document.getElementById("todoinput").value;
        

    var tableTodo = document.getElementById("todo_table");

    var row = tableTodo.insertRow(i);

    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    
    cell1.innerHTML = todo;
    cell2.innerHTML = "X";
    cell2.className = "delete";
    cell2.id = "delete"+i;
    i++;

}

const tableEle = document.querySelector("table.todo");
function onDelete(e){

    if(!e.target.classList.contains("delete")){
        return;
    }
    const btn = e.target;
    btn.closest('tr').remove();

}
tableEle.addEventListener('click', onDelete );

function clearAll()
{

    document.getElementById("todo_table").innerHTML =null;
}

