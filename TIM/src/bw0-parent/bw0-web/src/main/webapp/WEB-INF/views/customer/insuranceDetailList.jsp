<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="views" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sc2" uri="/WEB-INF/tld/sc2.tld"%>

<views:script src="json2.js"/>
<style>
.ins_title {
	background-color : black;
    color: white;
    font-size : 30px;
    margin-left: 30px;
    padding : 5px 10px;
} 
#tbl_insurance_detail th, #tbl_insurance_detail td{
    width: 150px;
    border: solid black 1px;
}
#tblBox { min-height: 100px; }
#tblBox td {
	width: 200px;
	min-height: 100px;
	padding: 1px;
}
</style>
<script language="javascript" type="text/javascript">
(function($){
	
});
</script>


<div class="" style="margin-top: 5px;margin-left:5px;" >
	<h1><spring:message code="Label.title.detail"/></h1>
	
	<table id="tbl_insurance_detail">
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.name"/></th>
	    <td>${customerInfo.customerName}</td>
	  </tr>
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.tel"/></th>
	    <td>${customerInfo.tel}</td>
	  </tr>
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.email"/></th>
	    <td>${customerInfo.email}</td>
	  </tr>
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.brand"/></th>
	    <td>${customerInfo.brand}</td>
	  </tr>
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.province"/></th>
	    <td>${customerInfo.province}</td>
	  </tr>
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.model"/></th>
	    <td>${customerInfo.model}</td>
	  </tr>
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.type"/></th>
	    <td>${customerInfo.insuranceName}</td>
	  </tr>
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.expiredate"/></th>
	    <td>${customerInfo.expireDate}</td>
	  </tr>
	</table>
	
	<hr/>
	<h1><spring:message code="Label.title.insurancelist"/></h1>
	
	
	<c:forEach items="${insuranceList}" var="insurance">
		<div class="insurance_panel">
			<span class="ins_title"><c:out value="${insurance.insuranceName}"/></span>
			<br/><br/>
			
			<table id="tblBox">
			  <tr>
			    <td align="center" style="background-color : black;color: white;"><c:out value="${insurance.box1}"/></td>
			    <td align="center" style="margin-left: 5px;background-color : lightgray;"><c:out value="${insurance.box2}"/></td>
			    <td align="center" style="background-color : lightgray;"><c:out value="${insurance.box3}"/></td>
			    <td align="center" style="background-color : lightgray;"><c:out value="${insurance.box4}"/></td>
			  </tr>
			</table>
			<br/>
			<div>
				<span><c:out value="${insurance.remark}"/></span>
			</div>
		</div>

		<hr/>
	</c:forEach>
	
	<br/>
	<div>
		<input style="padding: 3px;background-color: red;color: white;" type="button" value='<spring:message code="Label.button1"/>'/>
	    <input style="padding: 3px;background-color: red;color: white;" type="button" value='<spring:message code="Label.button2"/>'/>
	    <input style="padding: 3px;background-color: red;color: white;" type="button" value='<spring:message code="Label.button3"/>'/>
	</div>
</div>