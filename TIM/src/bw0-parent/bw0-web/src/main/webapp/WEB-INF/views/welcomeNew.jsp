<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sc2nav" uri="/WEB-INF/tld/sc2nav.tld"%>
<style>
</style>

<script type="text/javascript">
</script>
	
<c:if test="${isApplicationUser == false }">
	<script type="text/javascript">
	(function($){
		$(document).ready(function() {
			var realConfirm = window.confirm;
			window.confirm = null;
			
			function UnPopIt()  { /* nothing to return */ }
			
			var dialogOption = {
					width		: 450,
					buttons		: 
						[{
					        text: '<spring:message code="STD.dialog.ok" />' ,
					        click: function() {
					        	var self = $(this);
					        	self.siblings('.ui-dialog-buttonpane').find('input,button').prop('disabled', true);
								self.dialog('close');
								
								window.onbeforeunload = null;
								$("#left-menu-panel").remove();
								var win=open("","_self", "");
								win.close();
					        }
					    }]	
				};
			ST3Lib.dialog.confirm('<spring:message code="MSTD0012AERR" arguments="Employee No. of User login, Employee Master." />', 'MSTD0012AERR', dialogOption);
		});
	})(ST3Lib.$);;
	</script>
</c:if>

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

				<form class="login100-form validate-form">
					<span class="login100-form-title">
						Member Login
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="username" id="username" placeholder="Username">
						<span class="focus-input100"></span>						
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<input class="input100" type="password" name="Password" id="Password" placeholder="Password">
						<span class="focus-input100"></span>						
					</div>
					
					<div class="container-login100-form-btn">
						<button >
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
				</form>
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