<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="empty">
{"repCode":"111111","repMsg":"查询无数据!"}
</s:if>
<s:elseif test="!message.isEmpty()">
{"repCode":"999999","repMsg":"<s:property value='message' escape='false' />"}
</s:elseif>
<s:else>
{"data":<s:property value='json' escape='false' />,"repCode":"000000","repMsg":"操作成功!"}
</s:else>