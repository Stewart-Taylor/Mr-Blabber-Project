	
	<script language = "Javascript">
maxL=140;
var bName = navigator.appName;
function taLimit(taObj) {
	if (taObj.value.length==maxL) return false;
	return true;
}

function taCount(taObj,Cnt) { 
	objCnt=createObject(Cnt);
	objVal=taObj.value;
	if (objVal.length>maxL) objVal=objVal.substring(0,maxL);
	if (objCnt) {
		if(bName == "Netscape"){	
			objCnt.textContent=maxL-objVal.length;}
		else{objCnt.innerText=maxL-objVal.length;}
	}
	return true;
}
function createObject(objId) {
	if (document.getElementById) return document.getElementById(objId);
	else if (document.layers) return eval("document." + objId);
	else if (document.all) return eval("document.all." + objId);
	else return eval("document." + objId);
}
</script>
	
	
	
	
	<div id="createMessageBox">
	 
	
	
	
	<div id="messageWriteBox">
	 <h2>What's on your mind?</h2>
	<form name="login" action="/stewarttaylor/post" >
	
	<textarea onKeyPress="return taLimit(this)" onKeyUp="return taCount(this,'myCounter')" name="msg" class ="tb4" cols="30" rows="5"></textarea>
	<p><SPAN id=myCounter>140</SPAN></B> characters remaining</p>
	<input type="submit"   class="btn2" value="Post" />
	</form>
	
	</div>
	
	</div>

	
	
	
	
	
	
	
