<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Forgot Password</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">
<link rel="icon" href="images/agile.png" type="image/x-icon" />
   
  </head>
  <body class="login-bg">
<div class="wrapper">
	
	<div class="login-triangle"></div>
	
	<div class="header-wrap-login">
	<div class="container-fluid">
		<div class="col-sm-6 col-xs-8">
		
		</div>
	</div>
	</div>
	
	<div class="container">
		<div class="login-input-wrap">
			<div class="login-input-border-wrap">
			<form name="ChangePassword" action="resetPassword" method="post" onSubmit="return confirmValidate()">		
				<div class="row">
					<div class="col-sm-12">
						<h6 class="text-regular text-uppercase">Forgot Password</h6>
						
						<input type="text" name="email" id="email" placeholder="Registered Email ID" class="form-control login-fields username mar-top-20" />
						
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-6 mar-top-20 text-right">
						<input type="submit" class="btn btn-blue" value="Submit"/>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
	
	<div class="login-footer">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-9 text-12 mar-top-10">
					<p>Note: Best viewed in Google Chrome 48.0 and above at resolution 1024 X 768</p>
					<p class="">� Mighty: All Rights Reserved: 2016 Unizen Technologies Pvt. Ltd.</p></div>
				<div class="col-sm-3 text-right mar-top-10">
					<img src="images/atom_logo.png" alt="" />
				</div>
			</div>
		</div>
	</div>
	
	
</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
	<script src="http://maps.googleapis.com/maps/api/js"></script>
	<script>
	
	var docHeight = $(window).height();
	//alert(docHeight);
	var footerHeight = $(".login-footer").outerHeight();
	var headerHeight = $(".header-wrap-login").outerHeight() + 50;
	var contentheight = $(".login-bg .container").outerHeight();
	
	
	
	$(window).on('resize', function () {	
		$(".wrapper").css({
			"min-height" : $(window).height(),
			"padding-bottom" : (footerHeight + 30)
		});				
		var marginValue = ($(window).height() - footerHeight - headerHeight - contentheight)/2;		
		function loginMargin() {
			if (marginValue > 0) {
				$(".login-bg .container").css({
					"margin-top": marginValue
				});
			}
		}
		loginMargin();
	});			
	$( document ).ready(function() {		
		$(window).trigger('resize');		
	});	
</script>
<script type="text/javascript">
function confirmValidate() {
	var flag = true;
	var email=document.getElementById("email").value;
	if(email==null || email==""){
		alert("please enter email address");
		flag=false;
	}
	return flag;
		}
		
		</script>
  </body>
</html>