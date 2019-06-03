$(window).on("load", function() {
	$(".load").delay(1000).fadeOut();
});
$(document).ready(function(){
	$('.menu a').click(function(e){
		new Menu().Redirect(e, this);
	})
	new HelpFAQ('.help-faq', '.help-answers');
	$('.profile nav a').click(function(e) {
		new Menu().ProfileRedirect(e, this);
	})
	$('.help-faq p').click(function(){
		$('.help-faq p').removeClass("active");
		$(this).addClass("active");
		$('.help-answers p').removeClass('active');
		$('.help-answers p:nth-child(' + ($(this).index() + 1) + ')').addClass('active');
	});

	$('.help-back').click(function(){
		$('.help').removeClass('active');
		$('.main-menu').addClass('active');
	});

	$('.topic-back').click(function(){
		$('.theory').removeClass('active');
		$('.main-menu').addClass('active');
	});	

	$('.reg-click').click(function(){
		$('.unlogged').removeClass('active');
		$('.registration').addClass('active');
	});

	$('.enter-click').click(function(){
		$('.unlogged').removeClass('active');
		$('.login').addClass('active');
	});

	$('.back-to-guest').click(function(){
		$('.login').removeClass('active');
		$('.registration').removeClass('active');
		$('.unlogged').addClass('active');
	});

	$('.share-back').click(() => {
		$('.share').fadeOut();
	});

	$('.share-result').click(() => {
		$('.share').fadeIn();
	});

	$('.contact-back').click(() => {
		$('.contact-us').fadeOut();
	});
	
	$('.contact-us-but').click(() => {
		$('.contact-us').fadeIn();
	});

	$('.topic').click(function(e) {
		$('.theory').removeClass('active');
		$('.theory-topic').addClass('active');
	});
	new Profile(userStatistic);
	new Theory(0);
});
