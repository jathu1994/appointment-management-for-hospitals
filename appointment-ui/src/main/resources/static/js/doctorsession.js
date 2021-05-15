$(document).ready(function() {
	changeActiveNavItem("#navSession");
	$('#sessionDate').datepicker({
		format: 'yyyy-mm-dd',
		uiLibrary: 'bootstrap4',
		minDate: function() {
			var date = new Date();
			date.setDate(date.getDate());
			return new Date(date.getFullYear(), date.getMonth(), date.getDate());
		},
		maxDate: function() {
			var date = new Date();
			date.setDate(date.getDate() + 10);
			return new Date(date.getFullYear(), date.getMonth(), date.getDate());
		}
	});
	$('#expectedArrivalPicker').timepicker({ format: 'HH:MM', uiLibrary: 'bootstrap4' });
});



$(document).ready(function() {
	$.ajax({
		url: "/aptservice/staffs",
		success: function(response) {
			console.log(response);
			$("#hospitalRegNo").val(response[0]['hosRegNo']);
			hosRegNo = response[0]['hosRegNo'];
			$("#hospitalRegNo").trigger("change");

		},
		error: function(jqxhr) {
			var t1 = "<table class='table'><thead><tr><th scope='col'>Error Code</th><th scope='col'>Info</th></tr></thead><tbody><tr><td><span>" + jqxhr.status + "</span></td><td><span>" + jqxhr.responseText + "</span></td></tr></tbody></table>"
			$("#infoTableSpace").empty();
			$("#infoTableSpace").append(t1);

		}
	});

});



$("#hospitalRegNo").change(function() {
	var hosRegNo = $("#hospitalRegNo").val();
	$.ajax({
		url: "/aptservice/doctors?hosRegNo=" + hosRegNo,
		success: function(response) {
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
	var docRegNo = $("#doctorRegNo").val();
	$.ajax({
		url: "/aptservice/doctors?docRegNo=" + docRegNo,
		success: function(response) {
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
});

$("#sessionDate").change(function() {
	var hosRegNo = $("#hospitalRegNo").val();
	var docRegNo = $("#doctorRegNo").val();
	var sDate = $("#sessionDate").val();
	$.ajax({
		url: "/aptservice/sessions?hosRegNo=" + hosRegNo + "&docRegNo=" + docRegNo + "&sDate=" + sDate,
		success: function(response) {
			console.log(response);
			var len = response.length;

			if (len > 0) {
				var t1 = "<table class='table'><thead><tr><th scope='col'>Date</th><th scope='col'>Session</th><th scope='col'>No of Appointment</th><th scope='col'>Cancel</th></tr></thead><tbody>";
				var t2 = "";
				for (var i = 0; i < len; i++) {
					var sId = response[i]['id']; 
					var date = response[i]['date'];
					var session = response[i]['session'];
					var totalBookings = response[i]['currentAppointmentNumber'];
					var expectedArrival = response[i]['expectedArrival'];

					var t3 = "<tr><td><span>" + date + "</span></td><td><span>" 
					+ session + "</span></td><td><span>" 
					+ totalBookings + "</span></td><td><span><button class='btn btn-danger' id="+ sId +" onclick='cancelSession(this.id)'>Cancel</button></span></td></tr>";
					t2 = t2.concat(t3);
					
					/*<button class="btn btn-danger" id="btnCancelSession">Cancel</button>*/

				}
				var t4 = "</tbody></table>";

				var ft = t1.concat(t2).concat(t4);
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

$("#expectedArrivalPicker").change(function() {
	var expTime = $("#expectedArrivalPicker").val();
	expTime = expTime + ':00';
	$("#expectedArrival").val(expTime);
});

function cancelSession(id) {
	console.log("++++++++++++++++++ id" + id);
	$("#sessionId").val(id);
	$("#status").val("canceled");
	$.ajax({
		url: "/sessionservice/session?sessionId=" + id,
		success: function(response) {
			console.log(response);
		},
		error: function(jqxhr) {
			var t1 = "<table class='table'><thead><tr><th scope='col'>Error Code</th><th scope='col'>Info</th></tr></thead><tbody><tr><td><span>" + jqxhr.status + "</span></td><td><span>" + jqxhr.responseText + "</span></td></tr></tbody></table>"
			$("#infoTableSpace").empty();
			$("#infoTableSpace").append(t1);

		}
	});
	
}