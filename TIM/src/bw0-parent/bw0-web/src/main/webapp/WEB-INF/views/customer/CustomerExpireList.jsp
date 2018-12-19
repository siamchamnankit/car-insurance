<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="views" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sc2" uri="/WEB-INF/tld/sc2.tld"%>

<!DOCTYPE html>
<html>
<head>
<style>
#content-result {
	display: none;
}

th {
	background: #ff7cb0;
}

#tb-result td, #tb-result th {
	padding: 5px;
}

#tb-result tr:hover {
	background: #a0c4ff;
	cursor: pointer;
}

#expireWithIn {
	text-align: right;
	background: #a0f8ff;
}

input:text {
	border: 1px solid #000;
}
</style>
<script>
	$(function() {
		$("#btnSearch").click(function() {
			var iExpireWithIn = $("#expireWithIn").val();
			if (iExpireWithIn == "") {
				alert("Insurance Expire within should not be empty");
				return;
			}
			
			var url = "/bw0-web/customer/customerExpireList/search";
			var data = {cName 			: 	$("#cName").val(),
						iExpirePeriod	: 	$("#expireWithIn").val()
						};
			$.ajax({
				  type: "POST",
				  url: url,
				  data: data,
				  success: function(oData) {
					  console.log(oData);
					  // Generate table
					  $.each(oData, function(i, o) {
						  var row = "<tr data-customer-id=\""+o.customerId+"\"><td>"+(i+1)+"</td><td>"+
						  o.customerName + "</td><td>"+
						  o.insurnaceId+"</td><td>"+
						  o.expireDate+"</td></tr>";
						  
						  $("#tb-result tbody").append(row);
					  });
					  $("#total-record").html(oData.length);
				  }
				});
			
			$("#content-result").show();
		});
		
		$("#btnReset").click(function() {
			$("#content-result").hide();
			$("#tb-result tbody tr").remove();
			$("input:text").val("");
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
			<c:if test="${form.enableCriteriaName }">
			<tr>
				<td>Customer Name:&nbsp;</td>
				<td><input id="cName" name="cName" type="text" /></td>
			</tr>
			</c:if>
			<tr>
				<td>Insurance Expire within:&nbsp;</td>
				<td><input id="expireWithIn" name="expireWithIn" type="number"
					value="${form.iExpirePeriod }" />&nbsp;Months</td>
			</tr>
			<tr>
				<td colspan="2">
					<input id="btnSearch" type="button"
					value="Search" /> &nbsp;&nbsp;
					<input id="btnReset" type="reset"
					value="Clear" />
				</td>
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
				
			</tbody>
		</table>
		<p id="result-summary">
			Total found <span id="total-record">2</span> records
		</p>
	</div>

</body>
</html>
