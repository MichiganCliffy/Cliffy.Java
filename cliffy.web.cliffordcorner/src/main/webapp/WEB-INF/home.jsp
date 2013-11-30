<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="content" style="float: none;">

<s:iterator value="posts">

<div class="post">
<h2><s:property value="Title" /></h2>
<s:property escapeHtml="false" value="Description" />
<br style="clear: both;" />
</div>

</s:iterator>

</div>
