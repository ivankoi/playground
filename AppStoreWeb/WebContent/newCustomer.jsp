<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<html>
<body>
<f:view>
   <style type="text/css">  
			@import url("css/appstore.css");
   </style>

	<h:form id="newCustomerForm">
		<h:panelGrid columns="2" border="1" styleClass="spring">
			<f:facet name="header">
				<h:outputText value="Insert new Customer" />
			</f:facet>
			<h:outputText value="Name" />
			<h:inputText value="#{manager.customerName}" />  
			<h:outputText value="Country" />
			<h:inputText value="#{manager.customerCountry}" />

			<h:commandButton action="#{manager.insertCustomer}"  
				value="Insert Customer" />
			<h:commandButton action="#{manager.home}" value="Back" />
		</h:panelGrid>
		<h:messages />

	</h:form>
</f:view>
</body>
</html>
