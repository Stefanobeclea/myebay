<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
  <!-- Fixed navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
	
		<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"><img id="MDB-logo"
        src="https://mdbcdn.b-cdn.net/wp-content/uploads/2018/06/logo-mdb-jquery-small.png" alt="MDB Logo"
        draggable="false" height="30" /></a>
      
      
      <div class="collapse navbar-collapse" id="navbarsExample07">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/index.jsp">Home</a>
          </li>
          
          
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown07" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</a>
            <ul class="dropdown-menu" aria-labelledby="dropdown07">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/home">Home</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/PrepareSearchAnnuncioServlet">Ricerca Annunci</a></li>
              <c:if test="${userInfo.isAdmin()}">
              	<li><a class="dropdown-item" href="${pageContext.request.contextPath}/admin/PrepareSearchUtenteServlet">Ricerca Utenti</a></li>
              	<li><a class="dropdown-item" href="${pageContext.request.contextPath}/admin/PrepareInsertUtenteServlet">Inserisci Utenti</a></li>
              </c:if>              
            </ul> 
          </li>
          </ul>   
          
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <form class="d-flex align-items-center w-100 form-search" method="post" action="${pageContext.request.contextPath}/ExecuteSearchsAnnuncioServlet">
        	
          <input type="hidden" name="prezzo" value="0">
          <input type="search" class="form-control" name="testoAnnuncio" placeholder="Search" aria-label="Search" />
          <a href="#!" class="text-white"><i class="fas fa-search ps-3"></i></a>
      </form>
      </div>
      
      <div class="col-md-3 text-end">
        <p class="navbar-text">${userInfo.username } | Credito Residuo: ${userInfo.creditoResiduo}$ |
     	<c:if test="${userInfo.isUser()}">
     		<a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></p>
     	</c:if>
     	<c:if test="${!userInfo.isUser()}">
     		<a href="${pageContext.request.contextPath}/login.jsp">Login</a></p>
     	</c:if>
      </div> 
    </div>
             
     </div>
  </nav>

  
  
</header>