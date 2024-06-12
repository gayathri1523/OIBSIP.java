function addTask() {
  var taskInput = document.getElementById("taskInput");
  var taskText = taskInput.value;
  if (taskText.trim() === "") {
    alert("Please enter a task!");
    return;
  }
  var listItem = document.createElement("li");
  listItem.textContent = taskText;
  listItem.onclick = function() {
    toggleTask(this);
  };
  var deleteButton = document.createElement("button");
  deleteButton.textContent = "Delete";
  deleteButton.onclick = function(event) {
    event.stopPropagation();
    deleteTask(this.parentNode);
  };
  listItem.appendChild(deleteButton);
  document.getElementById("pendingTasks").appendChild(listItem);
  taskInput.value = "";
}

function toggleTask(task) {
  if (task.classList.contains("completed")) {
    task.classList.remove("completed");
    document.getElementById("pendingTasks").appendChild(task);
  } else {
    task.classList.add("completed");
    document.getElementById("completedTasks").appendChild(task);
  }
}

function deleteTask(task) {
  task.parentNode.removeChild(task);
}
