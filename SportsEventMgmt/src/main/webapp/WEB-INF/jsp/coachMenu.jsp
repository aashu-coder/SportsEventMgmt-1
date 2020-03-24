
<%
	Integer cid = (Integer) session.getAttribute("cid");
	if (cid == null) {
		response.sendRedirect("indexPage");
	}
%>


<!-- 
<script type="text/javascript">
	function view() {
		alert("hi");
		alert(document.getElementById("eventname").value);
	}
</script>
//String eventname=(String)session.getAttribute("eventname");
	Cookie cookies[]=request.getCookies();
	String value=null;
	for(Cookie c:cookies){
		out.println(c.getName());
	String key=c.getName();
	if(key.equals("eventname")){
	value=c.getValue();
	}
	}
	
	<input type="text" id="eventname" value="">
 -->

<header>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand js-scroll-trigger" href="coachPage">Sportathon</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a href="addPlayer"
					class="nav-link js-scroll-trigger">Add Player</a></li>
				<li class="nav-item"><a href="viewPlayer"
					class="nav-link js-scroll-trigger">View Player</a></li>
					<li class="nav-item"><a href="eventParticipation"
					class="nav-link js-scroll-trigger">Event Participation</a></li>
				<li class="nav-item"><a href="requestSignOut"
					class="nav-link js-scroll-trigger">Log out</a></li>
			</ul>
		</div>
	</nav>
</header>
