<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="praveen.airline.bstatus_database" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="main.css">

<link rel="stylesheet" href="w3.css">
<link rel="stylesheet" href="date.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<body>

<font face="Bauhaus">AirLine</font> 
<a href="Login.jsp" style="float:right"><i class="fa fa-home" style="font-size:30px;"></i></a>
<a href="" class="upper" style="float:right">Contact Us</a>
<a href="login.jsp" class="upper" style="float:right">Login/SignUp</a>

<div class="w3-container">

  <div class="tab" >
    <button class="w3-button tablink w3-indigo" onclick="load(event,'fbook')">Book Ticket</button>
    <button class=" w3-button tablink" onclick="load(event,'fstatus')">Flight Status</button>
    <button class="w3-bar-item w3-button tablink" onclick="load(event,'bstatus')">Booking Status</button>
  </div>
  
  
  
   <div class="background"> 
	 <div class="transbox">
		<center>
			<form id="fbook"  class="job" action="Flight_book" method="POST"><label>FLIGHT ID :
						<input type="text" list="flight_id" style="width:150px" placeholder="FLIGHT ID" name="flight_id"></label>
					<datalist id="flight_id">
				<option>BLRPUN</option>
				<option>PLRPTN</option>
			</datalist>
			
				<div id="number">
				<center>No. of person :
				<input type="number" min="1" max="6" style="width:100px" value="1" name="numofperson"></center>
				</div>
			<div  class="ws-validate">
				
				<div id="date" class="form-row show-inputbtns">
					Date<br><input type="date" name="date"/>
				</div>
				
				<div class="form-row">
					<input type="submit" />
				</div>
			</div>
			
			<%Object pnr2=request.getAttribute("status2");
			if(pnr2==null){
				out.println("");
			}
			else if(pnr2=="daymismatch")
			{
				out.print("Invalid date");
			}
			else if(pnr2!="false"&&pnr2!=null)
			{%><label>Your ticket confirm your PNR number is :<% out.println(pnr2); %></label>
			<%} else if(pnr2=="false")
			{%>
				<label>Process failed</label>
			<%}
				
			%>
			</form>
		</center>
		
		
		<form id="fstatus" class=" job" style="display:none" action="flight_status" method="post">
			<center><input type="text" list="city" style="width:235px" placeholder="From" name="source">
					<datalist id="city">
				<option>Bangalore</option>
				<option>Pune</option>
				<option>Ranchi</option>
				<option>Patna</option>
				<option>Mumbai</option>
				<option>Delhi</option>
				<option>Goa</option>
				
				
			</datalist>
			<input type="text" list="city" style="width:235px" placeholder="To" name="destination"> 
		
				
				<div class="ws-validate">
				
					<div id="date" class="form-row show-inputbtns">
						<br>Date<br><input type="date" name="date"/>
					</div>
				
					<div class="form-row">
						<input  type="submit" />
					</div>
				</div></center>
				
				<%Object flight_id=request.getAttribute("flight_id");
				Object distance=request.getAttribute("distance");
				Object source1=request.getAttribute("source1");
				 Object destination1=request.getAttribute("destination1");
				 Object hours=request.getAttribute("hours");
				 Object day=request.getAttribute("day");
				 Object status = request.getAttribute("status");
				 
				 if(status=="true")
				 {
				 %>
				 <body onload='myfunction("fstatus")'>
			<label><h6>Flight Id : <%= flight_id %></h6></label>	
			<label>Distance :<%= distance %> Km</label>
			<label>Source :<%= source1%></label>
			<label>Destination :<%= destination1 %></label>	
			<label> Hours :<%= hours %></label>
			<label> Day :<%= day %></label>
				<%}else if(status=="false"){%>
				<body onload='myfunction("fstatus")'>
					<% out.println("No Flight found");}
				%>
		</form>
		

		<form id="bstatus" class=" job" style="display:none" action="book_status" method="POST">
			<center><input type="number" style="width:235px" placeholder="PNR No." name="pnr">
				<div class="submit">
					<input type="submit"  />
				</div></center>
				<%Object dbpnr=request.getAttribute("dbpnr");
				 Object source=request.getAttribute("source");
				 Object destination=request.getAttribute("destination");
				 Object numofperson=request.getAttribute("numofperson");
				 Object date=request.getAttribute("date");
				 Object day1 =  request.getAttribute("day");
				 Object hours1 = request.getAttribute("hours");
				 Object distance1 = request.getAttribute("distance");
				 Object status1=request.getAttribute("status1");
				 if(status1=="true"){
				 %>
				
				 <body onload='myfunction("bstatus")'>
				 


				 
				 
	
			<label>PNR :<%= dbpnr %></label>
			<label>Source :<%= source%></label>
			<label>Destination :<%= destination %></label>	
			<label> Number of Person :<%= numofperson %></label>
			<label>Date of journey :<%= date %></label>
			<label>Day : <%= day1 %></label>
			<label>Hours : <%=hours1 %></label>
			<label>Distance : <%=distance1 %>Km</label>
			<%} else if(status1=="false")
			{%>
			<body onload='myfunction("bstatus")'>
				
				<label style="color:red"><% out.println("Invalid PNR");
			}
			%></label>		
		</form>
  

  
	 </div>
  </div>
</div>

<script>
function load(evt, cityName) {
  var i, x, tablinks;
  x = document.getElementsByClassName("job");
  for (i = 0; i < x.length; i++) 
  {
      x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < x.length; i++) 
  {
      tablinks[i].className = tablinks[i].className.replace(" w3-indigo", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " w3-indigo";
}
</script>
<script>

function myfunction(Name) {
	  var i, x, tablinks;
	  x = document.getElementsByClassName("job");
	  for (i = 0; i < x.length; i++) 
	  {
	      x[i].style.display = "none";
	  }
	 tablinks = document.getElementsByClassName("tablink");
	  for (i = 0; i < x.length; i++) 
	  {
	      tablinks[i].className = tablinks[i].className.replace(" w3-indigo", "");
	  }
	  document.getElementById(Name).style.display = "block";
	  evt.currentTarget.className += " w3-indigo";
	}


//document.getElementById("demo").innerHTML = myfunction("bstatus"); 
</script>


</body>
</html>
