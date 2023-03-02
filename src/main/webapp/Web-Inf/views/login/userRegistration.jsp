<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" charset="UTF-8">
    <title>User Registration</title>
    <!-- css link bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <!-- javascript link -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body
    <div class="row mt-5">
        <div class="col-md-4">
            <div class="card shadow border-0">
                <div class="card-body">
                    <h3 class="text-center my-4">Create your account</h3>
                    <form action="registerUser" method="post">
                        <div class="row mb-3 ">
                        <label for="exampleInputEmail1">Full name</label>
                            <div class="col">
                                <input type="text" name="firstName" value="" class="form-control" id="" placeholder="First name" required>
                            </div>
                            <div class="col">
                                <input type="text" name="firstName" value="" class="form-control" id="" placeholder="Last name" required>
                            </div>
                        </div>
                        <div class="form-group mb-3">
                          <label for="exampleInputEmail1">Email address</label>
                          <input type="email" name="email" value="" class="form-control" id="" aria-describedby="emailHelp" placeholder="Enter email" required>
                        </div>
                        <div class="form-group mb-3">
                          <label for="exampleInputPassword1">Password</label>
                          <input type="password" name="password" value="" class="form-control" id="" placeholder="Password" required>
                          <small id="emailHelp" class="form-text text-muted">We will never share your email with anyone else.</small>
                        </div>
                        <div class="form-group">
                          <label for="exampleInputPassword1">Password</label>
                          <input type="password" name="confirmPassword" value="" class="form-control" id="" placeholder="Confirm Password" required>
                        </div>
                        <button type="submit" value="register" class="btn btn-primary w-100 my-3  ">Register User</button>
                    </form>
                    <p>Already have an account?<a href="login"> Login</a></p>
                </div>
            </div>
        </div>

    </div>
</body>
</html>