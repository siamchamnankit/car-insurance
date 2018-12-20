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
#loading {
	display: none;
	color: pink;
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
			
			if (iExpireWithIn <= 0 || iExpireWithIn > 12) {
				alert ("Insurance Expire within should be between 1 and 12");
				return;
			}
			
			$("#content-result").hide();
			$("#loading").show();
			
			var url = _mappingPath+"/customer/customerExpireList/search";
			var customerName = $("#cName").val();
			if ($("#cName").length == 0) {
				customerName = "";
			}
			var data = {cName 			: 	customerName,
						iExpirePeriod	: 	$("#expireWithIn").val(),
						currentDate		: 	$.datepicker.formatDate('dd/mm/yy', new Date())
						};
			$.ajax({
				  type: "POST",
				  url: url,
				  data: data,
				  success: function(oData) {
					  console.log(oData);
					  $("#tb-result tbody tr").remove();
					  $.each(oData, function(i, o) {
						  /*var row = "<tr class=\"row-data\" data-customer-id=\""+o.customerId+"\"><td>"+(i+1)+"</td><td>"+
						  o.customerName + "</td><td>"+
						  o.insurnaceId+"</td><td>"+
						  o.expireDate+"</td></tr>";
						  
						  $("#tb-result tbody").append(row);
						  */
						  
						  var row = $('<tr>').addClass("rowData");
						  row.data({"customer-id" : o.customerId,
							  		"insurance-type" : o.insuranceType });
						  row.data();
						  row.attr("onclick", "showDetail(this);");
						  var col1 = $('<td>').text((i+1));
						  var col2 = $('<td>').text(o.customerName);
						  var col3 = $('<td>').text(o.insurnaceName);
						  var col3 = $('<td>').text(o.insuranceName);
						  var col4 = $('<td>').text(o.insuranceType);
						  var col5 = $('<td>').text(o.expireDate);
						  
						  $("#tb-result tbody").append(row.append(col1).append(col2).append(col3).append(col4).append(col5));
						  
						  if ((i+1) == oData.length) {
							  $("#content-result").show();
							  $("#loading").hide();
						  }
					  });
					  $("#total-record").html(oData.length);
				  }
				});
			
			
		});
		
		window.showDetail = function viewCustomer(obj) {
			var row = $(obj);
			var customerId = row.data("customer-id");
			var insuranceType = row.data("insurance-type");
			
			window.location.href = _mappingPath+"/customer/customerInsurance?customerId="+customerId+"&insuranceType=" + insuranceType;
			//alert(customerId);
		}
		
		$("#btnReset").click(function() {
			$("#content-result").hide();
			$("#tb-result tbody tr").remove();
			$("input:text").val("");
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
				<td><input id="expireWithIn" name="expireWithIn" type="number" min="1" max="12"
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
			<tr id="loading">
				<td>Loading..... Please wait!!!</td>
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
					<th>Insurance Name</th>
					<th>Insurance Type</th>
					<th>Expire Date</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
		<p id="result-summary">
			Total found <span id="total-record">0</span> records
		</p>
	</div>

</body>
</html>
