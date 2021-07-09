//define a toggler function for modals


// document.querySelector('#modal-add-cross').addEventListener('click',toggleModal);
const toggleModal = () =>{
    document.querySelector('.Modaladd').classList.toggle('modal--hidden');
};

//let's create an event listener on the first button in our class
document.querySelector('#click').addEventListener('click',toggleModal);
// here we're listening to click event and we are calling toggleModal function

//because we've got form inside let's give id to the form 
//let's access that element
document.querySelector('#learn-more').addEventListener('submit',(event)=>{
    event.preventDefault();
    toggleModal();
});
//event.preventDefault() stops the form from submitting, becasue we may call some js to capture the email


// //last eventlistener for x
document.querySelector('.modal_close-bar').addEventListener('click',toggleModal);




// // js script for delete modal open and close 
const toggleModaldel = () =>{
    document.querySelector('.modal-delete').classList.toggle('modal-delete--hidden');
};

// //let's create an event listener on the first button in our class
document.querySelector('#del-btn-id').addEventListener('click',toggleModaldel);
// // here we're listening to click event and we are calling toggleModal function

// //because we've got form inside let's give id to the form 
// //let's access that element
document.querySelector('#modal-del-can-btn').addEventListener('click',toggleModaldel);
// //event.preventDefault() stops the form from submitting, becasue we may call some js to capture the email


// //last eventlistener for x
document.querySelector('#modal-delete-cross').addEventListener('click',toggleModaldel);





// Js Script for Edit Modal open and close
const toggleModaledit = () =>{
    document.querySelector('.modal-edit').classList.toggle('modal-edit--hidden');
};

// Now let's create an event listener for edit button on home screen 
document.querySelector('#edit-btn-id').addEventListener('click',toggleModaledit);
// Now let's create for cancel buttons in the form 
document.querySelector('#edit-form-id').addEventListener('submit',(event)=>{
    event.preventDefault();
    toggleModaledit();
});
// Now let's create an event listener for x
document.querySelector('#modal-edit-cross').addEventListener('click',toggleModaledit);


////jquery
//var pageno = 1;
//const fetchTableData = () => {
//    $.get('/H2HBABBA2587/fetch', { page: pageno }, function(data, textStatus, jqXHR) {//success function
//        buildTable(data)
//    });
//}
//
//(
//    function() {
//        fetchTableData();
//    }
//
//)()
//
//
////// build table function
//function buildTable(data) {
//    const table = document.getElementById('table_body');
//    for (let i in data) {
//        if(i%2==0)
//       {
//           let evenRow = `<tr class="evenrow">
//           <td><input type="checkbox" name="name1" />&nbsp;</td>
//           <td>${data[i].name_customer}</td>
//           <td>${data[i].cust_number}</td>
//           <td>${data[i].invoice_id}</td>
//           <td class="invoiceamt"><span class="invoicetxt">${data[i].total_open_amount}</span></td>
//           <td>${data[i].due_in_date}</td>
//           <td class="paymentdate"><span class="textppd">${data[i].predicted_clear_date}</span></td>
//           <td>${data[i].notes}</td>
//       </tr>`
//       table.innerHTML += evenRow;
//       }
//       else{
//           let oddRow = `<tr class="oddrow">
//           <td><input type="checkbox" name="name1" />&nbsp;</td>
//           <td>${data[i].name_customer}</td>
//           <td>${data[i].cust_number}</td>
//           <td>${data[i].invoice_id}</td>
//           <td class="invoiceamt"><span class="invoicetxt">${data[i].total_open_amount}</span></td>
//           <td>${data[i].due_in_date}</td>
//           <td class="paymentdate"><span class="textppd">${data[i].predicted_clear_date}</span></td>
//           <td>${data[i].notes}</td>
//       </tr>`
//       table.innerHTML+= oddRow;
//       }
//    }
//   
//}

//jquery
var pageno = 1;
const fetchTableData = () => {
  $.get('/H2HBABBA2587/fetch', { page: pageno }, function(data, textStatus, jqXHR) {//success function
      buildTable(data)
  });
}

(
  function() {
      fetchTableData();
  }

)()

let tableHeader = `<tr class="oddrow">
                    <th><input type="checkbox" onclick="selectAllRow(this)" name="name1" />
                        <span class="graybox"></span>
                    </th>

                    <th>Customer Name</th>
                    <th>Customer #</th>
                    <th>Invoice #</th>
                    <th>Invoice Amount</th>
                    <th class="duedate"><span class="duedateheading">Due Date</span></th>
                    <th>Predicted Payment Date</th>
                    <th>Notes</th>
                </tr>`
	




//// build table function
function buildTable(data) {
  const table = document.getElementById('table_body');
  table.innerHTML += tableHeader ; 
  
  for (let i in data) {
      if(i%2==0)
     {
         let evenRow = `<tr class="evenrow">
         <td><input type="checkbox" value="${data[i].FIELD1}" onclick="selectedRow(this)" name="name1" class="checkbox" />&nbsp;</td>
         <td>${data[i].name_customer}</td>
         <td>${data[i].cust_number}</td>
         <td>${data[i].invoice_id}</td>
         <td class="invoiceamt"><span class="invoicetxt">${data[i].total_open_amount}</span></td>
         <td>${data[i].due_in_date}</td>
         <td class="paymentdate"><span class="textppd">${data[i].predicted_clear_date}</span></td>
         <td>${data[i].notes}</td>
     </tr>`
     table.innerHTML += evenRow;
     }
     else{
         let oddRow = `<tr class="oddrow">
         <td><input type="checkbox" value="${data[i].FIELD1}" onclick="selectedRow(this)" class = "checkbox" name="name1" />&nbsp;</td>
         <td>${data[i].name_customer}</td>
         <td>${data[i].cust_number}</td>
         <td>${data[i].invoice_id}</td>
         <td class="invoiceamt"><span class="invoicetxt">${data[i].total_open_amount}</span></td>
         <td>${data[i].due_in_date}</td>
         <td class="paymentdate"><span class="textppd">${data[i].predicted_clear_date}</span></td>
         <td>${data[i].notes}</td>
     </tr>`
     table.innerHTML+= oddRow;
     }
  }
 
}




function selectedRow(result){
  if(result.checked)
  {
      result.parentNode.parentNode.style.backgroundColor = "#2A5368";
     
  }
  else
  {
      result.parentNode.parentNode.style.backgroundColor = "";
  }
}

function selectAllRow(result) {
	var x = document.getElementById("table_body").querySelectorAll("tr");
	if(result.checked)
	{
		for(let i=0;i<x.length;i++)
		{
			x[i].style.backgroundColor = "#2A5368";
		}
		$(".checkbox").prop('checked', true);
	}
	else
	{
		for(let i=0;i<x.length;i++)
		{
			x[i].style.backgroundColor = "";
		}
  $(".checkbox").prop('checked', false);
}
}



// Pagination functions
function nextpg(){
	pageno+=1;
	const table= document.getElementById('table_body');
	table.innerHTML="";
	fetchTableData();
}

function prevpg(){
	if(pageno>1)
	{
		pageno-=1;
		const table = document.getElementById('table_body');
		table.innerHTML="";
		fetchTableData();
	}
}

//addInvoice functionality
function addInvoice(){
	var customerName = document.getElementById("cname").value;
	var customerNo = document.getElementById("cnum").value;
	var dueDate = document.getElementById("duedate").value;
	var invoiceNo = document.getElementById("invno").value;
	var invoiceAmt = document.getElementById("invamt").value;
	var notes = document.getElementById("notes").value;
	if(customerName=="" || customerNo == "" || dueDate == "" || invoiceNo=="" || invoiceAmt=="")
	{
		alert("Don't leave any field empty!");
		return;
	}
	
	 $.post('/H2HBABBA2587/add', {custName: customerName , 
		 						custNum:customerNo,
		 						invNo:invoiceNo,
		 						invAmt:invoiceAmt,
		 						due_Date:dueDate,
		 						note:notes}, function(){
		 							alert("Data is sent Successfully");
		 						});
}
function clearAddModal() {
	document.getElementById("cname").value="";
	document.getElementById("cnum").value="";
	document.getElementById("duedate").value="";
	document.getElementById("invno").value="";
	document.getElementById("invamt").value="";
	document.getElementById("notes").value="";
	
}

