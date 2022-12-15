var survey_options = document.getElementById('survey_options');
var add_more_fields = document.getElementById('add_more_fields');
var remove_fields = document.getElementById('remove_fields');

var test = document.getElementById('Collector');


function add_field(){
  

	  let table = document.getElementById("Collector");
	   
	  // Create a row using the inserRow() method and
	  // specify the index where you want to add the row
	  let row = table.insertRow(-1); // We are adding at the end
	
	  // Create table cells
	  let c1 = row.insertCell(0);
	  let c2 = row.insertCell(1);
	  let c3 = row.insertCell(2);
	  // Add data to c1 and c2
	  var select = document.getElementById('select_jani');
	  var value = select.options[select.selectedIndex].value;
	  var text = select.options[select.selectedIndex].text;
	
	  c1.innerText = value;
	  c2.innerText = text;
  	var btn = document.createElement("button");
  	//alert(123);
  	btn.onclick =  function(){
	    test();
	};
  	btn.innerHTML = "Remove";
  	c3.appendChild(btn);
}

function test(){
	alert("test");
}


function dele_field(num_row){
	let table = document.getElementById("Collector");
	if(table.rows.length >1){
		table.deleteRow(num_row);
	}else{
		alert("please stop, pleaseeeeee!!!!!!!!!!!");
	}
}



function changeCollector(){
	var select = document.getElementById('allCollector');
	var value = select.options[select.selectedIndex].value;
	//var text = select.options[select.selectedIndex].text;
	
	document.getElementById("idCollector").value = value;
}
