<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@attribute name="messagesList" type="java.util.List" required="true" %>
<%@attribute name="type" type="java.lang.String" required="true" %>
<c:if test="${not empty messagesList}">
    <div class="alert alert-${type}" role="alert">
        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <ul>
            <c:forEach var="message" items="${messagesList}">
                <li class="message ${message.category}">${message.message}</li>
                </c:forEach>
        </ul>
    </div>
</c:if>