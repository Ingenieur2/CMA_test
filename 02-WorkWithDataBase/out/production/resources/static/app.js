let stompClient = null;

const setConnected = (connected) => {
    $('#connect').prop("disabled", connected);
    $('#disconnect').prop("disabled", !connected);
    if (connected) {
        $('#studentsList').show();
        $('#firstName')[0].disabled = false;
        $('#secondName')[0].disabled = false;
        $('#middleName')[0].disabled = false;
        $('#dateOfBirth')[0].disabled = false;
        $('#studentGroup')[0].disabled = false;
        $('#sendRegister')[0].disabled = false;
        $('#sendShowAll')[0].disabled = false;
        $('#sendUpdate')[0].disabled = false;
        $('#sendDelete')[0].disabled = false;
        $('#deleteStudentById')[0].disabled = false;
    } else {
        $('#studentsList').hide();
        $('#create-form')[0].reset();
        $('#firstName')[0].disabled = true;
        $('#secondName')[0].disabled = true;
        $('#middleName')[0].disabled = true;
        $('#dateOfBirth')[0].disabled = true;
        $('#studentGroup')[0].disabled = true;
        $('#sendRegister')[0].disabled = true;
        $('#sendShowAll')[0].disabled = true;
        $('#sendUpdate')[0].disabled = true;
        $('#sendDelete')[0].disabled = true;
        $('#deleteStudentById')[0].disabled = true;
    }
    $('#studentsTable > tbody').empty();
}

const connect = () => {
    stompClient = Stomp.over(new SockJS('/websocket'));
    stompClient.connect({}, (frame) => {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/getAllStudents', (message) => showAllStudents(JSON.parse(message.body)));
        stompClient.subscribe('/topic/students', (message) => showMessage(JSON.parse(message.body)));
    });
}

const disconnect = () => {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMsgRegister() {
    stompClient.send("/app/chat.addStudent", {}, JSON.stringify({
        id: $('#studentId').val(),
        firstName: $('#firstName').val(),
        secondName: $('#secondName').val(),
        middleName: $('#middleName').val(),
        dateOfBirth: $('#dateOfBirth').val(),
        studentGroup: $('#studentGroup').val()
    }));
}

function sendMsgUpdate() {
    stompClient.send("/app/chat.updateStudent", {}, JSON.stringify({
        id: $('#deleteStudentById').val(),
        firstName: $('#firstName').val(),
        secondName: $('#secondName').val(),
        middleName: $('#middleName').val(),
        dateOfBirth: $('#dateOfBirth').val(),
        studentGroup: $('#studentGroup').val()
    }));
}

function sendMsgDelete() {
    stompClient.send("/app/chat.deleteStudent", {}, JSON.stringify({
        id: $('#deleteStudentById').val(),
        firstName: $('#firstName').val(),
        secondName: $('#secondName').val(),
        middleName: $('#middleName').val(),
        dateOfBirth: $('#dateOfBirth').val(),
        studentGroup: $('#studentGroup').val()
    }));
}

function sendMsgAll() {
    stompClient.send("/app/chat.getAllStudents", {}, {});
}

const showMessage = (student) => {
    if ((student.id === 0) ||
        (student.firstName === "") ||
        (student.secondName === "") ||
        (student.middleName === "") ||
        (student.dateOfBirth === "")) {
        $('#studentsStr').append();
    } else {
        $('#studentsStr').append('<tr>' +
            '<td>' + student.id + '</td>' +
            '<td>' + student.firstName + '</td>' +
            '<td>' + student.secondName + '</td>' +
            '<td>' + student.middleName + '</td>' +
            '<td>' + student.dateOfBirth + '</td>' +
            '<td>' + student.studentGroup + '</td>' +
            '</tr>');
    }
}

const showAllStudents = (students) => {
    $('#studentsTable > tbody').empty();
    if (students.length > 0) {
        for (let i = 0; i < students.length; i++) {
            let student = students[i];
            $('#studentsStr').append('<tr>' +
                '<td >' + student.id + '</td>' +
                '<td>' + student.firstName + '</td>' +
                '<td>' + student.secondName + '</td>' +
                '<td>' + student.middleName + '</td>' +
                '<td>' + student.dateOfBirth + '</td>' +
                '<td>' + student.studentGroup + '</td>' +
                '</tr>')
        }
    }
}