<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 3/8/2019
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
    <script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
    <link rel="stylesheet" type="text/css" href="css/styleRegistration.css">
</head>
<body>

<section class="testimonial py-5" id="testimonial">
    <div class="container">
        <div class="row ">
            <div class="col-md-4 py-5 bg-primary text-white text-center ">
                <div class=" ">
                    <div class="card-body">
                        <img src="img/addStu.jpg" style="width:30%">
                        <h2 class="py-3">Registration</h2>
                        <p>Create an account so you can join fantastic courses</p>
                    </div>
                </div>
            </div>

            <div class="col-md-8 py-5 border">
                <h4 class="pb-4">Personal data</h4>
                <form action="Registration" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input id="First Name" name="name" placeholder="First Name *" class="form-control" type="text">
                        </div>
                        <div class="form-group col-md-6">
                            <input id="Last Name" name="lastName" class="form-control" placeholder="Last Name *" type="text">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input id="dni" name="dni" placeholder="DNI *" class="form-control" type="text">
                        </div>
                        <div class="form-group col-md-6">
                            <input id="Birthdate" name="birthdate" class="form-control" placeholder="Birthdate (MM--DD--AAAA) *" type="text">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input id="Phone" name="phone" placeholder="Phone *" class="form-control" type="text">
                        </div>
                        <div class="form-group col-md-6">
                            <input id="Address" name="address" class="form-control" placeholder="Address *" type="text">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <select id="inputState" name="gender" class="form-control">
                                <option selected>Gender ...</option>
                                <option> Male</option>
                                <option> Female</option>
                            </select>
                        </div>
                    </div>

                    <!-- Espaciado. Buenas practicas? -->
                    <div class="col-xs-12" style="height:50px;"></div>

                    <h4 class="pb-4">Account details</h4>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input id="Username" name="userName" placeholder="Username *" class="form-control" type="text">
                        </div>
                        <div class="form-group col-md-6">
                            <input id="password" name="password" class="form-control" placeholder="Password *" type="password">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input id="Email" name="email" placeholder="E-mail *" class="form-control" type="email">
                        </div>
                        <div class="form-group col-md-6">
                            <input id="Confirm Password" name="confirmPassword" class="form-control" placeholder="Confirm Password *" type="password">
                        </div>
                    </div>

                    <div class="form-row">
                        <button type="submit" class="btn btn-danger">Submit</button>
                    </div>
                </form>
                <div class="col-12 forgot">
                    <a href="index.jsp">Already have an account? Click here</a>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
