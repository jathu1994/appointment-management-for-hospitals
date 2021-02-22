
$(document).ready(function() {
	$.ajax({
		url: "/aptservice/patients",
		success: function(response) {
			console.log(response);
			var len = response.length;
			for (var i = 0; i < len; i++) {
				var nicnumber = response[i]['nicnumber'];
				var firstName = response[i]['firstName'];
				var phoneNumber = response[i]['phoneNumber'];

				$("#patientList").append("<option value='" + nicnumber + "'>" + firstName + "  " + phoneNumber + "</option>");

			}

		},
		error: function(jqxhr) {
			var t1 = "<table class='table'><thead><tr><th scope='col'>Error Code</th><th scope='col'>Info</th></tr></thead><tbody><tr><td><span>" + jqxhr.status + "</span></td><td><span>" + jqxhr.responseText + "</span></td></tr></tbody></table>"
			$("#infoTableSpace").empty();
			$("#infoTableSpace").append(t1);

		}
	});
});


$(document).ready(function() {
	$.ajax({
		url: "/aptservice/hospitals",
		success: function(response) {
			console.log(response);
			var len = response.length;
			for (var i = 0; i < len; i++) {
				var hosRegNo = response[i]['hosRegNo'];
				var hosName = response[i]['hosName'];

				$("#hospitalList").append("<option value='" + hosRegNo + "'>" + hosName + "</option>");

			}

		},
		error: function(jqxhr) {
			var t1 = "<table class='table'><thead><tr><th scope='col'>Error Code</th><th scope='col'>Info</th></tr></thead><tbody><tr><td><span>" + jqxhr.status + "</span></td><td><span>" + jqxhr.responseText + "</span></td></tr></tbody></table>"
			$("#infoTableSpace").empty();
			$("#infoTableSpace").append(t1);

		}
	});
});

$("#patientNIC").change(function() {
	console.log("reached");
	var patientNIC = $("#patientNIC").val();
	console.log(patientNIC);
	$.ajax({
		url: "/aptservice/patients?NICNumber=" + patientNIC,
		success: function(response) {
			console.log("success");
			console.log(response);
			$("#patientName").val('');
			$("#patientName").val(response[0]['firstName']);
		},
		error: function(jqxhr) {
			var t1 = "<table class='table'><thead><tr><th scope='col'>Error Code</th><th scope='col'>Info</th></tr></thead><tbody><tr><td><span>" + jqxhr.status + "</span></td><td><span>" + jqxhr.responseText + "</span></td></tr></tbody></table>"
			$("#infoTableSpace").empty();
			$("#infoTableSpace").append(t1);

		}
	});
});


$("#hospitalRegNo").change(function() {
	console.log("reached");
	var hosRegNo = $("#hospitalRegNo").val();
	console.log(hosRegNo);
	$.ajax({
		url: "/aptservice/doctors?hosRegNo=" + hosRegNo,
		success: function(response) {
			console.log("success");
			console.log(response);
			var len = response.length;
			$("#doctorRegNo").val('');
			$("#doctorList").empty();

			for (var i = 0; i < len; i++) {
				var regNo = response[i]['regNo'];
				var firstName = response[i]['firstName'];
				$("#doctorList").append("<option value='" + regNo + "'>" + firstName + "</option>");
				$("#doctorRegNo").prop("disabled", false);

			}

		},
		error: function(jqxhr) {
			var t1 = "<table class='table'><thead><tr><th scope='col'>Error Code</th><th scope='col'>Info</th></tr></thead><tbody><tr><td><span>" + jqxhr.status + "</span></td><td><span>" + jqxhr.responseText + "</span></td></tr></tbody></table>"
			$("#infoTableSpace").empty();
			$("#infoTableSpace").append(t1);

		}
	});

	$.ajax({
		url: "/aptservice/hospitals?hosRegNo=" + hosRegNo,
		success: function(response) {
			console.log("success");
			console.log(response);
			$("#hospitalName").val('');
			$("#hospitalName").val(response[0]['hosName']);
		},
		error: function(jqxhr) {
			var t1 = "<table class='table'><thead><tr><th scope='col'>Error Code</th><th scope='col'>Info</th></tr></thead><tbody><tr><td><span>" + jqxhr.status + "</span></td><td><span>" + jqxhr.responseText + "</span></td></tr></tbody></table>"
			$("#infoTableSpace").empty();
			$("#infoTableSpace").append(t1);

		}
	});
});

$("#doctorRegNo").change(function() {
	$("#appointmentDate").val('');
	$("#dateList").empty();
	var hosRegNo = $("#hospitalRegNo").val();
	var docRegNo = $("#doctorRegNo").val();
	console.log(hosRegNo);
	console.log(docRegNo);
	console.log("reached");
	$.ajax({
		url: "/aptservice/sessionDates?hosRegNo=" + hosRegNo + "&docRegNo=" + docRegNo,
		success: function(response) {
			console.log("success");
			console.log(response);
			var len = response.length;
			for (var i = 0; i < len; i++) {
				var date = response[i]['date'];

				$("#dateList").append("<option value='" + date + "'></option>");
				$("#appointmentDate").prop("disabled", false);

			}

			if (len > 0) {
				var t1 = "<table class='table'><thead><tr><th scope='col'>Date</th><th scope='col'>Session</th><th scope='col'>No of Appointment</th><th scope='col'>Expected Arrival</th></tr></thead><tbody>";
				var t2 = "";
				for (var i = 0; i < len; i++) {
					var date = response[i]['date'];
					var session = response[i]['session'];
					var totalBookings = response[i]['totalBookings'];
					var expectedArrival = response[i]['expectedArrival'];

					var t3 = "<tr><td><span>" + date + "</span></td><td><span>" + session + "</span></td><td><span>" + totalBookings + "</span></td><td><span>" + expectedArrival + "</span></td></tr>";
					t2 = t2.concat(t3);

				}
				var t4 = "</tbody></table>";

				var ft = t1.concat(t2).concat(t4);
				console.log(ft);
				$("#infoTableSpace").empty();
				$("#infoTableSpace").append(ft);

			}

		},
		error: function(jqxhr) {
			var t1 = "<table class='table'><thead><tr><th scope='col'>Error Code</th><th scope='col'>Info</th></tr></thead><tbody><tr><td><span>" + jqxhr.status + "</span></td><td><span>" + jqxhr.responseText + "</span></td></tr></tbody></table>"
			$("#infoTableSpace").empty();
			$("#infoTableSpace").append(t1);

		}

	});


	$.ajax({
		url: "/aptservice/doctors?docRegNo=" + docRegNo,
		success: function(response) {
			console.log("success");
			console.log(response);
			$("#doctorName").val('');
			$("#doctorName").val(response[0]['firstName']);
		},
		error: function(jqxhr) {
			var t1 = "<table class='table'><thead><tr><th scope='col'>Error Code</th><th scope='col'>Info</th></tr></thead><tbody><tr><td><span>" + jqxhr.status + "</span></td><td><span>" + jqxhr.responseText + "</span></td></tr></tbody></table>"
			$("#infoTableSpace").empty();
			$("#infoTableSpace").append(t1);

		}
	});

	$.ajax({
		url: "/aptservice/visits?hosRegNo=" + hosRegNo + "&docRegNo=" + docRegNo,
		success: function(response) {
			console.log("success");
			console.log(response);
			$("#visitId").val('');
			$("#visitId").val(response[0]['id']);
		},
		error: function(jqxhr) {
			var t1 = "<table class='table'><thead><tr><th scope='col'>Error Code</th><th scope='col'>Info</th></tr></thead><tbody><tr><td><span>" + jqxhr.status + "</span></td><td><span>" + jqxhr.responseText + "</span></td></tr></tbody></table>"
			$("#infoTableSpace").empty();
			$("#infoTableSpace").append(t1);

		}
	});
});

$("#appointmentDate").change(function() {
	$("#session").val('');
	$("#sessionList").empty();
	var hosRegNo = $("#hospitalRegNo").val();
	var docRegNo = $("#doctorRegNo").val();
	var sDate = $("#appointmentDate").val();
	console.log(hosRegNo);
	console.log(docRegNo);
	console.log(sDate);
	console.log("reached");
	$.ajax({
		url: "/aptservice/sessions?hosRegNo=" + hosRegNo + "&docRegNo=" + docRegNo + "&sDate=" + sDate,
		success: function(response) {
			console.log("success");
			console.log(response);
			var len = response.length;
			console.log(len);
			for (var i = 0; i < len; i++) {
				var session = response[i]['session'];
				console.log(session);

				$("#sessionList").append("<option value='" + session + "'></option>");
				$("#session").prop("disabled", false);

			}

			if (len > 0) {
				var t1 = "<table class='table'><thead><tr><th scope='col'>Date</th><th scope='col'>Session</th><th scope='col'>No of Appointment</th><th scope='col'>Expected Arrival</th></tr></thead><tbody>";
				var t2 = "";
				for (var i = 0; i < len; i++) {
					var date = response[i]['date'];
					var session = response[i]['session'];
					var totalBookings = response[i]['totalBookings'];
					var expectedArrival = response[i]['expectedArrival'];

					var t3 = "<tr><td><span>" + date + "</span></td><td><span>" + session + "</span></td><td><span>" + totalBookings + "</span></td><td><span>" + expectedArrival + "</span></td></tr>";
					t2 = t2.concat(t3);

				}
				var t4 = "</tbody></table>";

				var ft = t1.concat(t2).concat(t4);
				console.log(ft);
				$("#infoTableSpace").empty();
				$("#infoTableSpace").append(ft);

			}

		},
		error: function(jqxhr) {
			var t1 = "<table class='table'><thead><tr><th scope='col'>Error Code</th><th scope='col'>Info</th></tr></thead><tbody><tr><td><span>" + jqxhr.status + "</span></td><td><span>" + jqxhr.responseText + "</span></td></tr></tbody></table>"
			$("#infoTableSpace").empty();
			$("#infoTableSpace").append(t1);

		}
	});
});


$("#session").change(function() {

	var hosRegNo = $("#hospitalRegNo").val();
	var docRegNo = $("#doctorRegNo").val();
	var sDate = $("#appointmentDate").val();
	var sSession = $("#session").val();
	console.log(hosRegNo);
	console.log(docRegNo);
	console.log(sDate);
	console.log(sSession);
	console.log("reached");
	$.ajax({
		url: "/aptservice/sessions?hosRegNo=" + hosRegNo + "&docRegNo=" + docRegNo + "&sDate=" + sDate + "&sSession=" + sSession, 
		success: function(response) {
			console.log("success");
			console.log(response);
			var len = response.length;

			$("#sessionId").val('');
			$("#sessionId").val(response[0]['id']);
			$("#appointmentNumber").val('');
			$("#appointmentNumber").val(response[0]['totalBookings'] + 1);
			$("#appointmentStatus").val('');
			$("#appointmentStatus").val('active');

			if (len > 0) {
				var t1 = "<table class='table'><thead><tr><th scope='col'>Date</th><th scope='col'>Session</th><th scope='col'>No of Appointment</th><th scope='col'>Expected Arrival</th></tr></thead><tbody>";
				var t2 = "";
				for (var i = 0; i < len; i++) {
					var date = response[i]['date'];
					var session = response[i]['session'];
					var totalBookings = response[i]['totalBookings'];
					var expectedArrival = response[i]['expectedArrival'];

					var t3 = "<tr><td><span>" + date + "</span></td><td><span>" + session + "</span></td><td><span>" + totalBookings + "</span></td><td><span>" + expectedArrival + "</span></td></tr>";
					t2 = t2.concat(t3);

				}
				var t4 = "</tbody></table>";

				var ft = t1.concat(t2).concat(t4);
				console.log(ft);
				$("#infoTableSpace").empty();
				$("#infoTableSpace").append(ft);
				$("#btnBookAppointment").prop("disabled", false);

			}


		},
		error: function(jqxhr) {
			var t1 = "<table class='table'><thead><tr><th scope='col'>Error Code</th><th scope='col'>Info</th></tr></thead><tbody><tr><td><span>" + jqxhr.status + "</span></td><td><span>" + jqxhr.responseText + "</span></td></tr></tbody></table>"
				$("#infoTableSpace").empty();
				$("#infoTableSpace").append(t1);

		}
	});
});

