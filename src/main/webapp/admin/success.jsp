<c:if test="${sessionScope.success!=null}">
    ${sessionScope.success}
    <c:set var="success" value="" scope="session"/>
</c:if>
