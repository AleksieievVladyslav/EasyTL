$(document).ready(function() {
	firebase.auth().onAuthStateChanged(function(user) {
		if (user) {
			// User is signed in.
			var displayName = user.displayName;
			var email = user.email;
			var emailVerified = user.emailVerified;
			var photoURL = user.photoURL;
			var isAnonymous = user.isAnonymous;
			var uid = user.uid;
			var providerData = user.providerData;

			console.log('Welcome, ' + displayName);
			// ...
		} else {
			// User is signed out.
			// ...
			console.log('There is nobody');
		}
	});
	$('.login .submit').click(function() {
		var email = $('#email-login').val();
		var password = $('#pass-login').val();
		firebase.auth().signInWithEmailAndPassword(email, password).catch(function(error) {
		  // Handle Errors here.
		  var errorCode = error.code;
		  var errorMessage = error.message;
		  alert('Erorr:\n' + errorMessage);
		  // ...
		});
	})
});
