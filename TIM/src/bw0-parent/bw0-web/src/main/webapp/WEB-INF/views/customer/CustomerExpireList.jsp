<!DOCTYPE html>
<html>
<head>
<title>Customer List</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	#content-result {display:none;}
    th { background: #ff7cb0;}
    #tb-result td, #tb-result th { padding: 5px; }
    #tb-result tr:hover { background : #a0c4ff; cursor: pointer;}
    #expireWithIn { text-align: right; background: #a0f8ff;}
    input:text { border: 1px solid #000; }
</style>
<script>
$(function(){
  $("#btnSearch").click(function() {
  		var iExpireWithIn = $("#expireWithIn").val();
        if (iExpireWithIn == "") {
        	alert("Insurance Expire within should not be empty");
            return;
        }
  		$("#content-result").show();
  	});
    
    $("#tb-result tbody tr").click(function() {
    	var customerId = $(this).data("customer-id");
        alert(customerId);
    });
});
</script>
</head>
<body>
<h1>Customer List</h1>
<table>
<tbody>
<tr>
<td>Customer Name:&nbsp;</td>
<td><input id="cName" name="cName" type="text" /></td>
</tr>
<tr>
<td>Customer Lastname</td>
<td><input id="cLastName" name="cLastName" type="text" /></td>
</tr>//*[@id="tb-result"]/tbody/tr[1]
<tr>
<td>Insurance Expire within:&nbsp;</td>
<td><input id="expireWithIn" name="expireWithIn" type="number" value="1" /></td>
</tr>
<tr>
<td colspan="2"><input id="btnSearch" type="button" value="Search" /> &nbsp;&nbsp;<input id="btnReset" type="reset" value="Clear" /></td>
</tr>
</tbody>
</table>
<hr />
<div id="content-result">
<table id="tb-result" border="1" cellpadding="0" cellspacing="0">
  <thead>
  	<tr>
    	<th>No.</th>
      	<th>Customer Name</th>
      	<th>Insurance Type</th>
      	<th>Expire Date</th>
    </tr>
  </thead>
<tbody>
<tr data-customer-id="c001">
<td>1</td>
<td>Name&nbsp;&nbsp;&nbsp;Lastname</td>
<td>Type 1</td>
<td>20/02/2019</td>
</tr>
<tr data-customer-id="c002">
<td>2</td>
<td>Name&nbsp;&nbsp;&nbsp;Surname/td>
<td>Type 1</td>
<td>01/03/2019</td>
</tr>
</tbody>
</table>
<p id="result-summary">Total found <span id="total-record">2</span> records</p>
</div>

</body>
</html>
