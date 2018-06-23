var stompClient = null;
var myName = '';
var windowId = 0;
var connectionId = 0;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#my-name").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS("/gs-guide-websocket");
    myName = $("#my-name").val();
    console.log(myName);
    stompClient = Stomp.over(socket);
    $.ajax({
        url: "/chat/connection?window=" + windowId,
        method: "GET",
        done: function (results) {
            connectionId = JSON.parse(results).id;

        },
        fail: function (jqXHR, textStatus, errorThrown) {
            console.log('Could not get posts, server response: ' + textStatus + ': ' + errorThrown);
        }
    });
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/ws/' + myName, function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello/" + myName, {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

