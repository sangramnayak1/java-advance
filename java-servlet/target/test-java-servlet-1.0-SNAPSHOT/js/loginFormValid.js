function validateLoginForm() {
	var myForm = document.forms[0];

	var uid = myForm.username;
	if (uid.value.length == 0) {
		alert("Please enter username.");
		uid.focus();
		return false;
	}

	var pwd = myForm.password;
	if (pwd.value.length == 0) {
		alert("Please enter password.");
		pwd.focus();
		return false;
	}

	return true;
}