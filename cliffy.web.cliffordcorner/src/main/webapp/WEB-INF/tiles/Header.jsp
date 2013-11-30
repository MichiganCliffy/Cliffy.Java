<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row">
<div class="col-xs-12 navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">CliffordCorner</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
				<s:iterator value="FeaturedAlbums">
				<li><a href="${pageContext.request.contextPath}/album?id=<s:property value="Id" />"><s:property value="Title" /></a></li>
				</s:iterator>
				<li>
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">More <b class="caret"></b></a>
					<ul class="dropdown-menu"><s:iterator value="OtherAlbums">
		                <li><a href="${pageContext.request.contextPath}/album?id=<s:property value="Id" />"><s:property value="Title" /></a></li>
					</s:iterator>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>
</div>
