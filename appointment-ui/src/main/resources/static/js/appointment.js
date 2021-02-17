
$(document).ready(function() {
	console.log("reached");
	$.ajax({
		url: "/aptservice/patients", success: function(response) {
			console.log("success");
			console.log(response);
			var len = response.length;
			for (var i = 0; i < len; i++) {
				var nicnumber = response[i]['nicnumber'];
				var firstName = response[i]['firstName'];
				var phoneNumber = response[i]['phoneNumber'];

				$("#patientList").append("<option value='" + nicnumber + "'>" + firstName + "  " + phoneNumber + "</option>");

			}

		}
	});
});


$(document).ready(function() {
	console.log("reached");
	$.ajax({
		url: "/aptservice/hospitals", success: function(response) {
			console.log("success");
			console.log(response);
			var len = response.length;
			for (var i = 0; i < len; i++) {
				var hosRegNo = response[i]['hosRegNo'];
				var hosName = response[i]['hosName'];

				$("#hospitalList").append("<option value='" + hosRegNo + "'>" + hosName + "</option>");

			}

		}
	});
});

$("#patientNIC").change(function() {
	console.log("reached");
	var patientNIC = $("#patientNIC").val();
	console.log(patientNIC);
	$.ajax({
		url: "/aptservice/patients?NICNumber=" + patientNIC, success: function(response) {
			console.log("success");
			console.log(response);
			$("#patientName").val('');
			$("#patientName").val(response[0]['firstName']);
		}
	});
});


$("#hospitalRegNo").change(function() {
	console.log("reached");
	var hosRegNo = $("#hospitalRegNo").val();
	console.log(hosRegNo);
	$.ajax({
		url: "/aptservice/doctors?hosRegNo=" + hosRegNo, success: function(response) {
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

		}
	});

	$.ajax({
		url: "/aptservice/hospitals?hosRegNo=" + hosRegNo, success: function(response) {
			console.log("success");
			console.log(response);
			var len = response.length;
			$("#hospitalName").val('');
			$("#hospitalName").val(response[0]['hosName']);
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
		url: "/aptservice/sessionDates?hosRegNo=" + hosRegNo + "&docRegNo=" + docRegNo, success: function(response) {
			console.log("success");
			console.log(response);
			var len = response.length;
			for (var i = 0; i < len; i++) {
				var date = response[i]['date'];

				$("#dateList").append("<option value='" + date + "'></option>");
				$("#appointmentDate").prop("disabled", false);

			}

		}
	});


	$.ajax({
		url: "/aptservice/doctors?docRegNo=" + docRegNo, success: function(response) {
			console.log("success");
			console.log(response);
			$("#doctorName").val('');
			$("#doctorName").val(response[0]['firstName']);
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
		url: "/aptservice/sessions?hosRegNo=" + hosRegNo + "&docRegNo=" + docRegNo + "&sDate=" + sDate, success: function(response) {
			console.log("success");
			console.log(response);
			var len = response.length;
			for (var i = 0; i < len; i++) {
				var session = response[i]['session'];
				console.log(session);

				$("#sessionList").append("<option value='" + session + "'></option>");
				$("#session").prop("disabled", false);

			}

		}
	});
});

