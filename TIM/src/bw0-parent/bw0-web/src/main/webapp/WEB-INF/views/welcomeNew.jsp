<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="views" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sc2" uri="/WEB-INF/tld/sc2.tld"%>

<views:script src="json2.js"/>
<views:script src="jquery-ui-1.9.1/jquery.dataTables.js"/>
<views:style src="jquery.dataTables.css"/>
<style>
</style>

<script type="text/javascript">
$( document ).ready(function() {

	$('#btnLogin').click(function(){
		
		$.ajax({
		  url: _mappingPath+"/login",
		  data: { username: $('#username').val(), password: $('#password').val() },
		}).done(function(datas) {
		  alert( "done" );
		  searchFinish(datas);
		});
		
	});
	window.searchFinish =
		function searchFinish(datas, loading){
			alert('a');
			window.location.href = 'customer/customerExpireList';
	}
});
</script>

<spring:message code="imagepath" var="imagepath" />
<spring:message code="BW0.menu.group.NewCarInsurance" var="NewCarInsuranceLabel" />
<spring:message code="BW0.menu.group.InsuranceRenewal" var="InsuranceRenewalLabel" />
<spring:message code="BW0.menu.group.InsuranceCompany" var="InsuranceCompanyLabel" />
<spring:message code="BW0.menu.group.Management" var="ManagementLabel" />
<div class="limiter" style="width: 10%; margin: auto;">
		<div class="container-login100">
			<div class="wrap-login100">
				<!--div class="login100-pic js-tilt" data-tilt>
					<img src="images/img-01.png" alt="IMG">
				</div>-->

				<form:form method="post" id="search-form" action="${_mappingPath}/login" ajax="searchFinish" 
		ajax-loading-target="#result_wrapper" validate-error="clearResult">
					<span class="login100-form-title">
						Member Login
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" value="prathan" name="username" id="username" placeholder="Username">
						<span class="focus-input100"></span>						
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<input class="input100" type="password" value="3Nj0Y8319" name="password" id="password" placeholder="Password">
						<span class="focus-input100"></span>						
					</div>
					
					<div class="container-login100-form-btn">
						<button id="btnLogin" type="button">
							Login
						</button>
						<button >
							Cancel
						</button>
					</div>
					

					<div class="text-center p-t-12">						
					</div>

					<div class="text-center p-t-136">						
					</div>
				</form:form>
			</div>
		</div>
	</div>
 <div class="container-fluid">
	<div class="row"> 
		<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
	 		<div class="form-row center">
	 			<sc2nav:menuImage type="groupId" groupId="BW0300" styleColDiv="pt-3 pb-1 col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6" style="my-1 textMenuImage"
	 				href="NewCarInsuranceMenu" title="${NewCarInsuranceLabel}" src="${imagepath}images/tim/New_Car_Insurance.png">
	 			</sc2nav:menuImage>
	 			<sc2nav:menuImage type="groupId" groupId="BW0400" styleColDiv="pt-3 pb-1 col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6" style="my-1 textMenuImage"
	 				href="InsuranceRenewalMenu" title="${InsuranceRenewalLabel}" src="${imagepath}images/tim/Insurance_Renewal.png">
	 			</sc2nav:menuImage>
	 			<sc2nav:menuImage type="groupId" groupId="BW0500" styleColDiv="pt-3 pb-1 col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6" style="my-1 textMenuImage"
	 				href="InsuranceCompany" title="${InsuranceCompanyLabel}" src="${imagepath}images/tim/Insurance_Company.png">
	 			</sc2nav:menuImage>
	 			<sc2nav:menuImage type="groupId" groupId="BW0600" styleColDiv="pt-3 pb-1 col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6" style="my-1 textMenuImage"
	 				href="ManagementMenu" title="${ManagementLabel}" src="${imagepath}images/tim/Management.png">
	 			</sc2nav:menuImage>
            </div>
		</div>  
	</div>
</div> 