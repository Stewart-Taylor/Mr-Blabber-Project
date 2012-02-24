
<script language="javascript">


function passResponse2()
 {

 
 
document.hform2.username.value = document.register.username.value;
document.hform2.password.value = MD5(document.register.password.value);
document.hform2.password2.value = MD5(document.register.password2.value);
document.register.password.value = "";
document.register.password2.value = "";



document.hform2.submit();


}


</script>




<div id="signup_box">
			
	<h4>Join Today</h4>
			
			<form name="hform2" action="/stewarttaylor/signup/" method="post" >
<input type="hidden" name="username">
<input type="hidden" name="password">
<input type="hidden" name="password2">
			</form>
			
	<form name="register"  method="Post">
			
			<div id="signup_item">
				Username  <input type="text"  class ="tb3" name="username" maxlength="30" />
			</div>
				
			<div id="signup_item">
				Password  <input type="password"  class ="tb3" name="password" maxlength="30" />
			</div>
				
			<div id="signup_item">
				Password Again  <input type="password"  class ="tb3" name="password2" maxlength="30" />
			</div>
	
		<input type="submit"    onClick="passResponse2(); return false;"  class="btn1" value="Sign Up" />
	</form>	
</div>


