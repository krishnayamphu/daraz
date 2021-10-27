<c:if test="${sessionScope.err!=null}">
    ${sessionScope.err}
    <c:set var="err" value="" scope="session"/>
</c:if>
