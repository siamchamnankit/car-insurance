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
} 
#tbl_insurance_detail th, #tbl_insurance_detail td{
    width: 150px;
}
#tblBox td {
	width: 200px;
	min-height: 100px;
}
</style>
<div class="" style="margin-top: 5px;margin-left:5px;" >
	<h1><spring:message code="Label.title.detail"/></h1>
	
	<table id="tbl_insurance_detail" border="1">
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.name"/></th>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.tel"/></th>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.email"/></th>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.brand"/></th>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.province"/></th>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.model"/></th>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.type"/></th>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <th align="left"><spring:message code="Label.title.customer.expiredate"/></th>
	    <td>&nbsp;</td>
	  </tr>
	</table>
	
	<hr/>
	<h1><spring:message code="Label.title.insurancelist"/></h1>
	
	<div class="insurance_panel">
		<span class="ins_title">{insurance Type}</span>
		<br/><br/>
		
		<table id="tblBox" border="1">
		  <tr>
		    <td align="center" style="background-color : black;color: white;">{BOX1}</td>
		    <td align="center" style="margin-left: 5px;background-color : lightgray;">{BOX2}</td>
		    <td align="center" style="background-color : lightgray;">{BOX3}</td>
		    <td align="center" style="background-color : lightgray;">{BOX4}</td>
		  </tr>
		</table>
		<br/>
		<div>
			<span>remark</span>
		</div>
	</div>
	
	<hr/>
	
	<div class="insurance_panel">
		<span class="ins_title">{insurance Type}</span>
		<br/><br/>
		
		<table id="tblBox" border="1">
		  <tr>
		    <td align="center" style="background-color : black;color: white;">{BOX1}</td>
		    <td align="center" style="margin-left: 5px;background-color : lightgray;">{BOX2}</td>
		    <td align="center" style="background-color : lightgray;">{BOX3}</td>
		    <td align="center" style="background-color : lightgray;">{BOX4}</td>
		  </tr>
		</table>
		<br/>
		<div>
			<span>remark</span>
		</div>
	</div>
	
	<hr/>
	
	<div class="insurance_panel">
		<span class="ins_title">{insurance Type}</span>
		<br/><br/>
		
		<table id="tblBox" border="1">
		  <tr>
		    <td align="center" style="background-color : black;color: white;">{BOX1}</td>
		    <td align="center" style="margin-left: 5px;background-color : lightgray;">{BOX2}</td>
		    <td align="center" style="background-color : lightgray;">{BOX3}</td>
		    <td align="center" style="background-color : lightgray;">{BOX4}</td>
		  </tr>
		</table>
		<br/>
		<div>
			<span>remark</span>
		</div>
	</div>
	
	<br/>
	<div>
		<input type="button" value='<spring:message code="Label.button1"/>'/>
	    <input type="button" value='<spring:message code="Label.button2"/>'/>
	    <input type="button" value='<spring:message code="Label.button3"/>'/>
	</div>
</div>