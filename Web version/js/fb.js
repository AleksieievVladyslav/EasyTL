$(document).ready(function() {
	firebase.auth().onAuthStateChanged(function(user) {
		if (user) {
			// User is signed in.
			var uid = user.uid;
			userStatistic = _getUserStat(uid);
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
	$('.sub_with_google').click(function(e) {
		e.preventDefault();
		// firebase.database().ref('GN3bp7QdKoTWEXmjmzENkzVtk4n1').set({
		//     Name: 'VladTest'
		// });
		var username = "";
		// var userId = firebase.auth().currentUser.uid;
		// firebase.database().ref(userId).once('value').then(function(snapshot) {
		// 	username = (snapshot.val().Name) ? snapshot.val().Name : 'Anonymous';
		// 	console.log(username);
		// })
	})
});
function _setUserStat(uid, stat) {
	firebase.database().ref(uid).set({
		Name: stat.name,
		Stars: stat.stars,
		passedTopics: stat.passedTopics,
		questions: stat.questions,
		tests: stat.tests,
		averages: stat.averages
	});
}
function _getUserStat(uid) {
	let res = {};
	firebase.database().ref(uid).once('value').then(function(snapshot) {
		if (snapshot.val()) {
			res.name = (snapshot.val().Name) ? snapshot.val().Name : 'Anonymous';
			res.stars = (snapshot.val().Stars) ? snapshot.val().Stars : '0';
			res.passedTopics = (snapshot.val().passedTopics) ? +snapshot.val().passedTopics : 0;
			res.questions = (snapshot.val().questions) ? snapshot.val().questions : { correct: 0, total: 0};
			res.tests = (snapshot.val().tests) ? snapshot.val().tests : { passed: 0, total: 0};
			res.averages = (snapshot.val().averages) ? snapshot.val().averages : { correctAnswers: 0, time: 0};
		} else {
			res = userStatistic;
		}

		new Profile(res);
		$('.unlogged').removeClass('active');
		$('.logged').addClass('active');
		_setUserStat(uid, res);
		return res;
	});
}