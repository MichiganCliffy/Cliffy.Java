<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%-- Show usage; Used in Header --%>
<tiles:importAttribute name="title" scope="request"/>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    	<title>CliffordCorner - <tiles:getAsString name="title"/></title>
	    <link href='//fonts.googleapis.com/css?family=Yesteryear' rel='stylesheet' type='text/css'>
	    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
   	</head>
<body>

	<div class="container wrapper">
	    
	    <tiles:insertAttribute name="header"/>
    	<tiles:insertAttribute name="body"/>
		<tiles:insertAttribute name="footer" />
		
	</div>
	
	<script src="${pageContext.request.contextPath}/scripts/jquery-1.10.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/offcanvas.js"></script>

</body>
</html>
