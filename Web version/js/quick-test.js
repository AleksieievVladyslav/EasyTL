class Quick {
	Close(type) {
		if (type === true) {
			// remove answers buttons
			$('.q-a').off().removeClass('active').removeClass('passed');

			// stop the clock
			this.quickClock.Stop();
			$('.clock').empty();
		}
		$('.progress').show();
		$('.q-result').hide();
		$('.q-content').show();
		$('.q-progress-bar').css({'width' : '0%'});
		$('.quick').removeClass('active');
		$('.main-menu').addClass('active');
	}
	End() {
		// remove answers buttons
		$('.q-a').off().removeClass('active').removeClass('passed');

		// stop the clock
		this.quickClock.Stop();
		$('.clock').empty();

		// reset Display
		$('#q-title').html('Результат');
		$('.progress').hide();
		$('#q-formulation').html('');
		$('.q-progress-bar').css({'width' : '100%'});
		$('.q-prev').hide();
		$('.q-content').hide();

		// show Result
		$('.q-result').show();
		$('#q-state-value-result').html(this.score);

		// set Exit Button
		$('.q-next span').html('Выйти в меню<i class="fas fa-long-arrow-alt-right"></i>')
			.click(() => {this.Close(false)});
	}
	PrevQ() {
		this.currentQ--;
		this.__initQ();
	}
	NextQ() {
		this.currentQ++;
		this.__initQ();
	}
	Check(answer) {
		if (this.qList[this.currentQ].isPassed === true) {
			return;
		}
 		this.qList[this.currentQ].isPassed = true;
		let gif = this.qList[this.currentQ].answers[answer].gif;
		$('#img > img').attr({src : gif});
		this.qList[this.currentQ].resultGif = gif;
		if (this.qList[this.currentQ].answers[answer].isCorrect) this.score++;
		$('.q-a').addClass('passed');
	}
	GenerateQList() {
		this.qList = [];
		for (let i = 0; i < 20; i++) this.qList.push(new Question(QUESTIONS[0]));
	}
	__initQ() {
		let question = this.qList[this.currentQ];

		// init Display
		$('#img > img').attr({src : question.initGif});
		$('#progress').show().html(this.currentQ + 1);
		$('#q-title').html(question.theme);
		$('#q-formulation').html(question.title);
		$('.q-progress-bar').css({'width' : this.currentQ / this.qList.length * 100 + '%'});

		// init "prev" button
		if (this.currentQ == 0) {
			$('.q-prev span').off()
				.html('<i class="fas fa-long-arrow-alt-left"></i>Выйти в меню')
				.click(() => {this.Close(true)});
		} else {
			$('.q-prev span').off()
				.html('<i class="fas fa-long-arrow-alt-left"></i>Предыдущий вопрос')
				.click(() => {this.PrevQ()});
		}

		// init "next" button
		if (this.currentQ == this.qList.length - 1) {
			$('.q-next span').off()
				.html('Закончить тест<i class="fas fa-long-arrow-alt-right"></i>')
				.click(() => {this.End()});
		} else {
			$('.q-next span').off()
				.html('Следующий вопрос<i class="fas fa-long-arrow-alt-right"></i>')
				.click(() => {this.NextQ()});
		}

		// init answers buttons
		for (let i = 0; i < question.answers.length; i++) {
			$('#answer-' + i).addClass('active').removeClass('passed')
				.html(question.answers[i].text)
				.click(() => {
					this.Check(i);
				});
		}
	}
	constructor() {
		this.quickClock = new Clock('.clock');
		this.GenerateQList();
		this.currentQ = 0;
		this.score = 0;
		$('.q-prev').show();
		this.__initQ();
	}
}