class Profile {

	constructor(input) {
		this.name = input.name;
		this.stars = input.stars;
		this.questions = input.questions;
		this.tests = input.tests;
		this.averages = input.averages;
		this.passedTopics = input.passedTopics;

		this.InitFields();
		this.SetProgressTopics();
	}

	SetProgressTopics() {
		let i;
		for (i = 0; i < this.passedTopics; i++) {
			$('.topic:eq(' + i + ')').removeClass('closed-topic').addClass('passed-topic');
		}
		$('.topic:eq(' + i + ')').removeClass('closed-topic').addClass('opened-topic');
	}
	InitFields() {
		this.InitStars();
		this.InitTextFields();
	}
	InitTextFields() {
		$('.profile-header').html(this.name);
		$('#correctanswers').html(this.questions.correct);
		$('#totalanswers').html(this.questions.total);
		$('#passedtests').html(this.tests.passed);
		$('#totaltests').html(this.tests.total);
		$('#averageanswers').html(this.averages.correctAnswers);
		$('#averagetime').html(this.averages.time);
	}
	InitStars() {
		let res = [0, 0, 0, 0, 0];
		let i = 0;
		let stars = this.stars;
		while (stars > 1) {
			stars -= 2;
			res[i++] = 2;
		}
		if (stars == 1) {
			res[i] = 1;
		}

		let starsContainer = $('.profile .stars');
		starsContainer.empty();
		for (let j = 0; j < res.length; j++) {
			switch (res[j]) {
				case 0:
					starsContainer.append('<i class="far fa-star">');
					break;
				case 1:
					starsContainer.append('<i class="fas fa-star-half-alt">');
					break;
				case 2:
					starsContainer.append('<i class="fas fa-star">');
					break;
			}
		} 
	}
}