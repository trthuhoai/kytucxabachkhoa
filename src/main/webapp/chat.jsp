<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script>
	var $messages = $('.messages-content'),
    d, h, m,
    i = 0;

		$(window).load(function() {
		  $messages.mCustomScrollbar();
		  setTimeout(function() {
		    fakeMessage();
		  }, 100);
		});
		
		
		function updateScrollbar() {
		  $messages.mCustomScrollbar("update").mCustomScrollbar('scrollTo', 'bottom', {
		    scrollInertia: 10,
		    timeout: 0
		  });
		}
		
		function setDate(){
		  d = new Date()
		  if (m != d.getMinutes()) {
		    m = d.getMinutes();
		    $('<div class="timestamp">' + d.getHours() + ':' + m + '</div>').appendTo($('.message:last'));
		    $('<div class="checkmark-sent-delivered">&check;</div>').appendTo($('.message:last'));
		    $('<div class="checkmark-read">&check;</div>').appendTo($('.message:last'));
		  }
		}
		
		function insertMessage() {
		  msg = $('.message-input').val();
		  if ($.trim(msg) == '') {
		    return false;
		  }
		  $('<div class="message message-personal">' + msg + '</div>').appendTo($('.mCSB_container')).addClass('new');
		  setDate();
		  $('.message-input').val(null);
		  updateScrollbar();
		  setTimeout(function() {
		    fakeMessage();
		  }, 1000 + (Math.random() * 20) * 100);
		}
		
		$('.message-submit').click(function() {
		  insertMessage();
		});
		
		$(window).on('keydown', function(e) {
		  if (e.which == 13) {
		    insertMessage();
		    return false;
		  }
		})
		
		var Fake = [
		  'Hi there, I\'m Jesse and you?',
		  'Nice to meet you',
		  'How are you?',
		  'Not too bad, thanks',
		  'What do you do?',
		  'That\'s awesome',
		  'Codepen is a nice place to stay',
		  'I think you\'re a nice person',
		  'Why do you think that?',
		  'Can you explain?',
		  'Anyway I\'ve gotta go now',
		  'It was a pleasure chat with you',
		  'Time to make a new codepen',
		  'Bye',
		  ':)'
		]
		
		function fakeMessage() {
		  if ($('.message-input').val() != '') {
		    return false;
		  }
		  $('<div class="message loading new"><figure class="avatar"><img src="http://askavenue.com/img/17.jpg" /></figure><span></span></div>').appendTo($('.mCSB_container'));
		  updateScrollbar();
		
		  setTimeout(function() {
		    $('.message.loading').remove();
		    $('<div class="message new"><figure class="avatar"><img src="http://askavenue.com/img/17.jpg" /></figure>' + Fake[i] + '</div>').appendTo($('.mCSB_container')).addClass('new');
		    setDate();
		    updateScrollbar();
		    i++;
		  }, 1000 + (Math.random() * 20) * 100);
		
		}
		
		$('.button').click(function(){
		  $('.menu .items span').toggleClass('active');
		   $('.menu .button').toggleClass('active');
		});
	</script>
	<section class="avenue-messenger">
	  <div class="menu">
	   <div class="items"><span>
	     <a href="#" title="Minimize">&mdash;</a><br>
	<!--     
	     <a href="">enter email</a><br>
	     <a href="">email transcript</a><br>-->
	     <a href="#" title="End Chat">&#10005;</a>
	     
	     </span></div>
	    <div class="button">...</div>
	  </div>
	  <div class="agent-face">
	    <div class="half">
	     <img class="agent circle" src="http://askavenue.com/img/17.jpg" alt="Jesse Tino"></div>
	  </div>
	<div class="chat">
	  <div class="chat-title">
	    <h1>Jesse Tino</h1>
	    <h2>RE/MAX</h2>
	  <!--  <figure class="avatar">
	      <img src="http://askavenue.com/img/17.jpg" /></figure>-->
	  </div>
	  <div class="messages">
	    <div class="messages-content"></div>
	  </div>
	  <div class="message-box">
	    <textarea type="text" class="message-input" placeholder="Type message..."></textarea>
	    <button type="submit" class="message-submit">Send</button>
	  </div>
	</div>
	  </div>
	  <style>
	  	/*-------------------- Body --------------------*/
		 *, *::before, *::after {
			 box-sizing: border-box;
		}
		 html, body {
			 height: 100%;
		}
		 body {
			 background: linear-gradient(135deg, #044f48, #345093);
			 background-size: cover;
			 background: #fff;
			 font-family: 'Avenir', 'Open Sans', sans-serif;
			 font-size: 14px;
			 line-height: 1.3;
			 overflow: hidden;
		}
		 .bg {
			 width: 100%;
			 height: 100%;
			 top: 0;
			 left: 0;
			 z-index: 1;
			/* background: url('https://images.unsplash.com/photo-1451186859696-371d9477be93?crop=entropy&fit=crop&fm=jpg&h=975&ixjsv=2.1.0&ixlib=rb-0.3.5&q=80&w=1925') no-repeat 0 0;
			*/
			 filter: blur(80px);
			 transform: scale(1.2);
			 background: #fff;
		}
		/*-------------------- Chat --------------------*/
		 .chat {
			 position: relative;
			/* top: 50%;
			 left: 50%;
			 transform: translate(-50%, -50%);
			*/
			 width: 100%;
			 height: calc(100% - 15px);
			 max-height: 500px;
			 z-index: 10;
			 overflow: hidden;
			/*box-shadow: 0 5px 30px rgba(0, 0, 0, .2);
			*/
			/* background: rgba(0, 0, 0, .5);
			*/
			 background: transparent;
			 border-radius: 20px;
			 -webkit-border-radius: 20px;
			 -moz-border-radius: 20px;
			 display: flex;
			 justify-content: space-between;
			 flex-direction: column;
		}
		/*-------------------- Chat Title --------------------*/
		 .chat-title {
			 flex: 0 1 45px;
			 position: relative;
			 z-index: 2;
			 width: 100%;
			 border-bottom: 1px solid #ccc;
			 color: #777;
			 padding-top: 50px;
			 padding-bottom: 5px;
			 background-color: #fff;
			 text-transform: uppercase;
			 text-align: center;
		}
		 .chat-title h1, .chat-title h2 {
			 font-weight: normal;
			 font-size: 14px;
			 margin: 0;
			 padding: 0;
		}
		 .chat-title h2 {
			/* color: rgba(255, 255, 255, .8);
			*/
			 font-size: 11px;
			 letter-spacing: 1px;
		}
		 .chat-title .avatar {
			 position: absolute;
			 z-index: 1;
			 top: 8px;
			 left: 9px;
			 -webkit-border-radius: 30px;
			 -moz-border-radius: 30px;
			 border-radius: 30px;
			 width: 60px;
			 height: 60px;
			 overflow: hidden;
			 margin: 0;
			 padding: 0;
			 border: 1px solid #fff;
		}
		 .chat-title .avatar img {
			 width: 100%;
			 height: auto;
		}
		/*-------------------- Messages --------------------*/
		 .messages {
			 flex: 1 1 auto;
			/* color: rgba(255, 255, 255, .5);
			 color: #fff;
			*/
			 overflow: hidden;
			 position: relative;
			 width: 100%;
		}
		 .messages .messages-content {
			 position: absolute;
			 top: 0;
			 left: 0;
			 height: 101%;
			 width: 100%;
		}
		 .messages .message {
			 clear: both;
			 float: left;
			 padding: 6px 10px 7px;
			 -webkit-border-radius: 20px 20px 20px 0;
			 -moz-border-radius: 20px 20px 20px 0;
			 border-radius: 20px 20px 20px 0;
			 background: #eee;
			/*rgba(0, 0, 0, 0.1);
			*/
			 margin: 8px 0;
			 font-size: 14px;
			 line-height: 1.4;
			 margin-left: 35px;
			 position: relative;
			 border: 1px solid #ccc;
			/* color: rgba(255, 255, 255, .7);
			*/
		}
		 .messages .message .timestamp {
			/*text-shadow: 0 1px 1px rgba(0, 0, 0, .2);
			*/
			 position: absolute;
			 bottom: -15px;
			 font-size: 10px;
			 color: #555;
			 right: 30px;
		}
		 .messages .message .checkmark-sent-delivered {
			 position: absolute;
			 bottom: -15px;
			 right: 10px;
			 font-size: 12px;
			 color: #999;
		}
		 .messages .message .checkmark-read {
			 color: blue;
			 position: absolute;
			 bottom: -15px;
			 right: 16px;
			 font-size: 12px;
		}
		 .messages .message::before {
			/* content: '';
			 position: absolute;
			 bottom: -6px;
			 border-top: 6px solid rgba(0, 0, 0, 0.1);
			 left: 0;
			 border-right: 7px solid transparent;
			*/
		}
		 .messages .message .avatar {
			 position: absolute;
			 z-index: 1;
			 bottom: -15px;
			 left: -35px;
			 -webkit-border-radius: 30px;
			 -moz-border-radius: 30px;
			 border-radius: 30px;
			 width: 30px;
			 height: 30px;
			 overflow: hidden;
			 margin: 0;
			 padding: 0;
			 border: 2px solid rgba(255, 255, 255, 0.5);
		}
		 .messages .message .avatar img {
			 width: 100%;
			 height: auto;
		}
		 .messages .message.message-personal {
			 float: right;
			 text-align: right;
			/* background: linear-gradient(120deg, #ddd, #eee);
			*/
			 background: #fff;
			 border: 1px solid #ccc;
			/*#4A90E2*/
			 -webkit-border-radius: 20px 20px 0 20px;
			 -moz-border-radius: 20px 20px 0 20px;
			 border-radius: 20px 20px 0 20px;
		}
		 .messages .message.message-personal::before {
			/* content:"";
			 border-color:#4A90E2 transparent;
			 width:0;
			 border-style:solid;
			*/
			/* left: auto;
			 right: 0;
			 border-right: none;
			 border-left: 8px solid transparent;
			 border-top: 9px solid #fff;
			 bottom: -8px;
			*/
		}
		 .messages .message:last-child {
			 margin-bottom: 30px;
		}
		 .messages .message.new {
			 transform: scale(0);
			 transform-origin: 0 0;
			 animation: bounce 500ms linear both;
		}
		 .messages .message.loading::before {
			 position: relative;
			/* top: 50%;
			 left: 50%;
			 transform: translate(-50%, -50%);
			*/
			 content: '';
			 display: block;
			 width: 5px;
			 height: 5px;
			 border-radius: 50%;
			/* background: rgba(255, 255, 255, .5);
			*/
			 background: #888;
			 z-index: 2;
			 margin-top: 4px;
			 animation: ball 0.45s cubic-bezier(0, 0, 0.15, 1) alternate infinite;
			 border: none;
			 animation-delay: 0.15s;
		}
		 .messages .message.loading span {
			 display: block;
			 font-size: 0;
			 width: 20px;
			 height: 10px;
			 position: relative;
		}
		 .messages .message.loading span::before {
			 position: relative;
			/* top: 50%;
			 left: 50%;
			 transform: translate(-50%, -50%);
			*/
			 content: '';
			 display: block;
			 width: 5px;
			 height: 5px;
			 border-radius: 50%;
			/* background: rgba(255, 255, 255, .5);
			*/
			 background: #888;
			 z-index: 2;
			 margin-top: 4px;
			 animation: ball 0.45s cubic-bezier(0, 0, 0.15, 1) alternate infinite;
			 margin-left: -7px;
		}
		 .messages .message.loading span::after {
			 position: relative;
			/* top: 50%;
			 left: 50%;
			 transform: translate(-50%, -50%);
			*/
			 content: '';
			 display: block;
			 width: 5px;
			 height: 5px;
			 border-radius: 50%;
			/* background: rgba(255, 255, 255, .5);
			*/
			 background: #888;
			 z-index: 2;
			 margin-top: 4px;
			 animation: ball 0.45s cubic-bezier(0, 0, 0.15, 1) alternate infinite;
			 margin-left: 7px;
			 animation-delay: 0.3s;
		}
		/*-------------------- Message Box --------------------*/
		 .message-box {
			 flex: 0 1 42px;
			 width: 90%;
			 background: #fff;
			 margin: 2px auto;
			 padding: 10px;
			/*-webkit-box-shadow: 0px 1px 1px 1px rgba(0,0,0,0.4);
			 -moz-box-shadow: 0px 1px 1px 1px rgba(0,0,0,0.4);
			 box-shadow: 0px 1px 1px 1px rgba(0,0,0,0.4);
			*/
			/*background: rgba(0, 0, 0, 0.3);
			 border-top:1px solid #e3e3e3;
			*/
			 position: relative;
			 -webkit-border-radius: 20px;
			 -moz-border-radius: 20px;
			 border-radius: 20px;
			 height: 14px;
			 border: 1px solid #ccc;
		}
		 .message-box .message-input {
			 background: none;
			 border: none;
			 outline: none !important;
			 resize: none;
			/* color: rgba(255, 255, 255, .8);
			*/
			 font-size: 15px;
			 height: 24px;
			 margin: 0;
			 padding-right: 20px;
			 width: 265px;
			 color: #444;
		}
		 .message-box textarea:focus:-webkit-placeholder {
			 color: transparent;
		}
		 .message-box .message-submit {
			 position: absolute;
			 z-index: 1;
			 top: 9px;
			 right: 10px;
			 color: #4a90e2;
			 border: none;
			/* background: #c29d5f;
			*/
			 background: #fff;
			 font-size: 12px;
			 text-transform: uppercase;
			 line-height: 1;
			 padding: 6px 10px;
			 border-radius: 5px;
			 outline: none !important;
			 transition: background 0.2s ease;
			 cursor: pointer;
		}
		 .message-box .message-submit:hover {
			 background: #fff;
			 color: #333;
		}
		/*-------------------- Custom Srollbar --------------------*/
		 .mCSB_scrollTools {
			 margin: 1px -3px 1px 0;
			 opacity: 0;
		}
		 .mCSB_inside > .mCSB_container {
			 margin-right: 0px;
			 padding: 0 10px;
		}
		 .mCSB_scrollTools .mCSB_dragger .mCSB_dragger_bar {
			 background-color: rgba(0, 0, 0, 0.5) !important;
		}
		/*-------------------- Bounce --------------------*/
		 @keyframes bounce {
			 0% {
				 transform: matrix3d(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
			}
			 4.7% {
				 transform: matrix3d(0.45, 0, 0, 0, 0, 0.45, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
			}
			 9.41% {
				 transform: matrix3d(0.883, 0, 0, 0, 0, 0.883, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
			}
			 14.11% {
				 transform: matrix3d(1.141, 0, 0, 0, 0, 1.141, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
			}
			 18.72% {
				 transform: matrix3d(1.212, 0, 0, 0, 0, 1.212, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
			}
			 24.32% {
				 transform: matrix3d(1.151, 0, 0, 0, 0, 1.151, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
			}
			 29.93% {
				 transform: matrix3d(1.048, 0, 0, 0, 0, 1.048, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
			}
			 35.54% {
				 transform: matrix3d(0.979, 0, 0, 0, 0, 0.979, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
			}
			 41.04% {
				 transform: matrix3d(0.961, 0, 0, 0, 0, 0.961, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
			}
			 52.15% {
				 transform: matrix3d(0.991, 0, 0, 0, 0, 0.991, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
			}
			 63.26% {
				 transform: matrix3d(1.007, 0, 0, 0, 0, 1.007, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
			}
			 85.49% {
				 transform: matrix3d(0.999, 0, 0, 0, 0, 0.999, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
			}
			 100% {
				 transform: matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
			}
		}
		 @keyframes ball {
			 from {
				 transform: translateY(0) scaleY(0.8);
			}
			 to {
				 transform: translateY(-10px);
			}
		}
		 .avenue-messenger {
			 opacity: 1;
			 -webkit-border-radius: 20px;
			 -moz-border-radius: 20px;
			 border-radius: 20px;
			 height: calc(100% - 60px) !important;
			 max-height: 460px !important;
			 min-height: 220px !important;
			 width: 320px;
			/* transform: translateY(0);
			 -webkit-transform: translateY(0);
			 -moz-transform: translateY(0);
			 */
			 background: rgba(255, 255, 255, 0.9);
			 position: fixed;
			 right: 20px;
			 bottom: 20px;
			 margin: auto;
			 z-index: 10;
			 box-shadow: 2px 10px 40px rgba(22, 20, 19, 0.4);
			/* transform: translateX(300px);
			*/
			 -webkit-transition: 0.3s all ease-out 0.1s, transform 0.2s ease-in;
			 -moz-transition: 0.3s all ease-out 0.1s, transform 0.2s ease-in;
		}
		 .avenue-messenger div.agent-face {
			 position: absolute;
			 left: 0;
			 top: -50px;
			 right: 0;
			 margin: auto;
			 width: 101px;
			 height: 50px;
			 background: transparent;
			 z-index: 12;
		}
		 .avenue-messenger div {
			 font-size: 14px;
			 color: #232323;
		}
		 .close {
			 display: block;
			 width: 100px;
			 height: 100px;
			 margin: 1em auto;
			 background-size: cover;
			 background-repeat: no-repeat;
			 background-position: center center;
			 -webkit-border-radius: 99em;
			 -moz-border-radius: 99em;
			 border-radius: 99em;
			 opacity: 0.5;
			/*border: 1px solid #ccc;
			 color:#ccc;
			*/
			/* -webkit-box-shadow: 0px -1px 2px 0px rgba(0, 0, 0, 0.5);
			 -moz-box-shadow: 0px -1px 2px 0px rgba(0, 0, 0, 0.5);
			 box-shadow: 0px -1px 2px 0px rgba(0, 0, 0, 0.5);
			*/
		}
		 .close:hover {
			/* -webkit-box-shadow: 0 1px 1px rgba(0,0,0,0.3);
			 -moz-box-shadow: 0 1px 1px rgba(0,0,0,0.3);
			 box-shadow: 0 1px 1px rgba(0,0,0,0.3);
			*/
			 opacity: 0.9;
		}
		 .circle {
			 display: block;
			 width: 80px;
			 height: 80px;
			 margin: 1em auto;
			 background-size: cover;
			 background-repeat: no-repeat;
			 background-position: center center;
			 -webkit-border-radius: 99em;
			 -moz-border-radius: 99em;
			 border-radius: 99em;
			 border: 2px solid #fff;
			/*#4A90E2;
			*/
			/* -webkit-box-shadow: 0px 0px 10px rgba(0,0,0,.8);
			 -moz-box-shadow: 0px 0px 10px rgba(0,0,0,.8);
			 box-shadow: 0px 0px 10px rgba(0,0,0,.8);
			*/
		}
		 .contact-icon .circle:hover {
			 box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
			 -webkit-box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
			 -moz-box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
			 transition: 0.2s all ease-out 0.2s;
			 -webkit-transition: 0.2s all ease-out 0.2s;
			 -moz-transition: 0.2s all ease-out 0.2s;
		}
		 .arrow_box:after {
			 border-color: rgba(255, 255, 255, 0);
			 border-left-color: #fff;
			 border-width: 5px;
			 margin-top: -5px;
		}
		 .arrow_box {
			 position: relative;
			 background: #fff;
			 border: 1px solid #4a90e2;
		}
		 .arrow_box:after, .arrow_box:before {
			 left: 100%;
			 top: 50%;
			 border: solid transparent;
			 content: " ";
			 height: 0;
			 width: 0;
			 position: absolute;
			 pointer-events: none;
		}
		 .menu div.items {
			/* height: 140px;
			 width: 180px;
			 overflow: hidden;
			 position: absolute;
			 left: -130px;
			 z-index: 2;
			 top: 20px;
			*/
		}
		 .menu .items span {
			 color: #111;
			 z-index: 12;
			 font-size: 14px;
			 text-align: center;
			 position: absolute;
			 right: 0;
			 top: 40px;
			 height: 86px;
			 line-height: 40px;
			 background: #fff;
			 border-left: 1px solid #ccc;
			 border-bottom: 1px solid #ccc;
			 border-right: 1px solid #ccc;
			 width: 48px;
			 opacity: 0;
			 border-bottom-left-radius: 20px;
			 border-bottom-right-radius: 20px;
			 transition: 0.3s all ease-in-out;
			 -webkit-transition: 0.3s all ease-in-out;
			 -moz-transition: 0.3s all ease-in-out;
		}
		 .menu .button {
			 font-size: 30px;
			 z-index: 12;
			 text-align: right;
			 color: #333;
			 content: "...";
			 display: block;
			 width: 48px;
			 line-height: 25px;
			 height: 40px;
			 border-top-right-radius: 20px;
			/* border-top-left-radius:20px;
			*/
			 position: absolute;
			 right: 0;
			 padding-right: 10px;
			 cursor: pointer;
			 transition: 0.3s all ease-in-out;
			 -webkit-transition: 0.3s all ease-in-out;
			 -moz-transition: 0.3s all ease-in-out;
		}
		 .menu .button.active {
			 background: #ccc;
		}
		/* .menu .button:hover .menu .items span {
			 display: block;
			 left: -2px;
			 opacity: 1;
		}
		*/
		 .menu .items span.active {
			 opacity: 1;
		}
		/*border-radius:10px;
		 height: 180px;
		 width: 400px;
		 transform:translateY(0);
		 -webkit-transform:translateY(0);
		 -moz-transform:translateY(0);
		*/
		 .menu .items a {
			 color: #111;
			 text-decoration: none;
		}
		 .menu .items a:hover {
			 color: #777;
		}
		 @media only screen and (max-device-width: 667px), screen and (max-width: 450px) {
			/* left:initial !important;
			*/
			 .avenue-messenger {
				 z-index: 2147483001 !important;
				 width: 100% !important;
				 height: 100% !important;
				 max-height: none !important;
				 top: 0 !important;
				 left: 0 !important;
				 right: 0 !important;
				 bottom: 0 !important;
				 -webkit-border-radius: 0 !important;
				 -moz-border-radius: 0 !important;
				 border-radius: 0 !important;
				 background: #fff;
			}
			 .avenue-messenger div.agent-face {
				 top: -10px !important;
			}
			 .chat {
				 -webkit-border-radius: 0 !important;
				 -moz-border-radius: 0 !important;
				 border-radius: 0 !important;
				 max-height: initial !important;
			}
			 .chat-title {
				 padding: 20px 20px 15px 10px !important;
				 text-align: left;
			}
			 .circle {
				 width: 80px;
				 height: 80px;
				 border: 1px solid #fff;
			}
			 .menu .button {
				 border-top-right-radius: 0;
			}
		}
		 @media only screen and (min-device-width: 667px) {
			 div.half {
				 margin: auto;
				 width: 80px;
				 height: 40px;
				 background-color: #fff;
				 border-top-left-radius: 60px;
				 border-top-right-radius: 60px;
				 border-bottom: 0;
				 box-shadow: 1px 4px 20px rgba(22, 20, 19, 0.6);
				 -webkit-box-shadow: 1px 4px 20px rgba(22, 20, 19, 0.6);
				 -moz-box-shadow: 1px 4px 20px rgba(22, 20, 19, 0.6);
			}
		}
 
	  
	  </style>
</body>
</html>