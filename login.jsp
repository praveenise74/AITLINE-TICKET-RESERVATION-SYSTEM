<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="main.css">
<link rel="stylesheet" href="w3.css">
<body>
<font face="Bauhaus">AirLine</font> 
<a href="#" style="float:right"><i class="fa fa-home" style="font-size:30px;"></i></a>
<a href="#" class="upper" style="float:right">Contact Us</a>
<%!  %>
<div class="w3-container">

  <div class="tab" >
    <button class=" w3-button tablink w3-indigo" onclick="load(event,'login')">LogIn</button>
    <button class=" w3-button tablink" onclick="load(event,'signup')">SignUp</button>
    
  </div>




   <div class="background">
   
	 <div class="transbox">
		<center><form id="login" class=" job" action="login" method="POST">
					<input type="text" style="width:235px" placeholder="User ID" name="user_name"><br>
					<input type="password" style="width:235px" placeholder="Password" name="password">
					
			
					<div class="form-row">
						<input type="submit" value="LogIn"/>
						
						
					</div>
					<% 
					Object status1=request.getAttribute("status1");
					if(status1=="login_unsuccessful"){
					%><label style="color:red"><% out.print("Invalid Username or Password");%></label><%} %>
				</form><center>
		
		<center><form id="signup" class=" job" style="display:none" action="Register" method="POST">
					<%
					Object status=request.getAttribute("status");
					if(status=="User Already Exists"){
					 %><body onload='myfunction("signup")'>
					 <label style="color:red"><%= status %></label><%} %><br>
					<input type="text" style ="width:235px" placeholder =" Full Name" name="name">
					<input type="number" style="width:235px" placeholder = "Phone no." name ="phon_no."><br>
					<input type="text" style="width:235px" placeholder="User ID" name="uid">
					<input type="password" id="pass1" style="width:235px" placeholder="Password" name="pass"><br>
					<input type="password" id="pass2" style="width:235px" placeholder=" Verify Password" name="pass1">
					
			
					<div class="form-row">
						<input type="submit" onclick="myFunction()" value="SignUP"/>
					</div>
					<%
					if(status=="Password Missmatch"){
					 %><body onload='myfunction("signup")'>
					 <label style="color:red"><%= status %></label><%} %>
					
				</form></center>
			</div>
		</div>	
</div>			


</body>

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

function myfunction(cityName) {
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

    function myFunction() {
        var pass1 = document.getElementById("pass1").value;
        var pass2 = document.getElementById("pass2").value;
        if (pass1 != pass2) {
           alert("Passwords Do not match");
            document.getElementById("pass1").style.borderColor = "#E34234";
            document.getElementById("pass2").style.borderColor = "#E34234";
           
            
        }
       /* else {
            alert("Passwords Match!!!");
            window.location.href="main.jsp";
        }*/
    }
</script>

</html>
