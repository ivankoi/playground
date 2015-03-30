<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>  
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<html>
<body>
<f:view>  
   <style type="text/css">  
			@import url("css/appstore.css");
   </style>
<h:panelGrid columns="1" border="1" styleClass="spring">  
  <f:facet name="header">
    <h:outputText value="Welcome to the EJB 3 Store sample"/>
  </f:facet>

	<h:form id="listOrdersForm">  
	<h:outputText value="Select Customer:" />  
     <h:selectOneMenu id="selectCustomer"
        value="#{manager.customerId}" styleClass="buttons">  
          <f:selectItems
             value="#{manager.listCustomers}" />
     </h:selectOneMenu> 
     <h:commandButton action="#{manager.findOrders}" value="ListOrders" styleClass="buttons"/>  
     
		<h:dataTable value="#{manager.listOrders}" var="orders"
			border="1" rowClasses="row1, row2" headerClass="header">  
			<h:column>
				<f:facet name="header">
                    <h:outputText value="Product" />
                </f:facet>
				<h:outputText value="#{orders.product}" />
			</h:column>
			<h:column>
				<f:facet name="header">
                    <h:outputText value="Price" />
                </f:facet>
				<h:outputText value="#{orders.price}" />
			</h:column>
			<h:column>
				<f:facet name="header">
                    <h:outputText value="Quantity" />
                </f:facet>
				<h:outputText value="#{orders.quantity}" />
			</h:column>

		</h:dataTable>

		<h:commandButton action="#{manager.newCustomer}" value="Insert Customer" styleClass="buttons" />  
		<h:commandButton action="#{manager.newOrder}" value="Insert Order" styleClass="buttons" />  
       </h:form>	
	  </h:panelGrid> 
	  	   
</f:view>
</body>
</html>
