<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row row-offcanvas row-offcanvas-right">
<div class="content col-xs-12 col-sm-9">

<p class="pull-right visible-xs">
	<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
</p>

<h1><s:property value="model.Title" /></h1>

<s:property escapeHtml="false" value="model.Description" />

<p></p>

<div class="row">
<s:iterator value="model.Photographs">
<div class="col-xs-3 col-md-2"><a href="#" class="thumbnail"><img src="<s:property value="Thumbnail" />" title="<s:property value="Title" />" /></a></div>
</s:iterator>
</div>

</div>

<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
<div class="list-group">
<s:iterator value="model.Tags">
<a href="#" class="list-group-item"><s:property /></a>
</s:iterator>
</div>
</div><!--/span-->
</div>
