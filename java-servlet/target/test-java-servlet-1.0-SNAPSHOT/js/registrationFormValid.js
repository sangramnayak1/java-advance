function validateRegistrationForm() {
	var regdForm = document.forms[0];
	var fn = regdForm.firstName;
	if (fn.value.length == 0) {
		alert("Please enter First Name.");
		fn.focus();
		return false;
	}
	var ln = regdForm.lastName;
	if (ln.value.length == 0) {
		alert("Please enter Last Name.");
		ln.focus();
		return false;
	}
	var age = regdForm.age;
	if (age.value.length == 0) {
		alert("Please enter Age.");
		age.focus();
		return false;
	}
	var addr = regdForm.address;
	if (addr.value.length == 0) {
		alert("Please enter Address.");
		addr.focus();
		return false;
	}
	var cont = regdForm.contact;
	if (cont.value.length == 0) {
		alert("Please enter Contact No.");
		cont.focus();
		return false;
	}
	var em = regdForm.email;
	if (em.value.length == 0) {
		alert("Please enter Email.");
		em.focus();
		return false;
	}
	var un = regdForm.username;
	if (un.value.length == 0) {
		alert("Please enter Username.");
		un.focus();
		return false;
	}
	var pw = regdForm.Password;
	if (pw.value.length == 0) {
		alert("Please enter Password.");
		pw.focus();
		return false;
	}
	return true;
}
