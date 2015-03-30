<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<html>
<body>
<f:view>
   <style type="text/css">  
			@import url("css/appstore.css");
   </style>
	<h:form id="newOrderForm">

		<h:panelGrid columns="2" border="1" styleClass="spring">
			<f:facet name="header">
				<h:outputText value="Insert new Order" />
			</f:facet>
			<h:outputText value="Product" />
			<h:inputText value="#{manager.orderProduct}" />

			<h:outputText value="Quantity" />
			<h:inputText value="#{manager.orderQuantity}" />

			<h:outputText value="Price" />
			<h:inputText value="#{manager.orderPrice}" />

			<h:outputText value="Customer" />
			<h:selectOneMenu id="selectCustomerforOrder"
				value="#{manager.customerId}" styleClass="buttons">
				<f:selectItems value="#{manager.listCustomers}" />
			</h:selectOneMenu>
			<h:commandButton action="#{manager.saveOrder}" value="Save Order" />
			<h:commandButton action="#{manager.home}" value="Back" />
		</h:panelGrid>
		<h:messages />
	</h:form>
</f:view>
</body>
</html>
