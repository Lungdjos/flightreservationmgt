<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" charset="UTF-8">
    <title>Complete Reservation</title>
    <!-- css link bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- javascript link -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body class="m-5">
    <h1 class="my-4">Complete Reservation</h1>

    <h2 class="my-4">Flight Details</h2>
    <p><label>Airlines:</label>    ${flight.operatingAirlines}</p>
    <p><label>From:</label>        ${flight.departureCity}</p>
    <p><label>To:</label>          ${flight.arrivalCity}</p>
    <p><label>Airlines:</label>    ${flight.operatingAirlines}</p>
    <hr>

    <form action="completeReservation" method="post">
        <h2 class="my-4">Passenger Details:</h2>
        <div class="form-group mb-3">
          <label for="from">First Name:</label>
          <input type="text" name="passengerFirstName" value="" class="form-control" id="" placeholder="First Name" required>
        </div>
        <div class="form-group mb-3">
          <label for="to">Last Name:</label>
          <input type="text" name="passengerLastName" value="" class="form-control" id="" placeholder="Last Name" required>
        </div>
        <div class="form-group mb-3">
          <label for="from">Email:</label>
          <input type="email" name="passengerEmail" value="" class="form-control" id="" placeholder="Email Address" required>
        </div>
        <div class="form-group mb-3">
          <label for="from">Phone:</label>
          <input type="text" name="passengerPhone" value="" class="form-control" id="" placeholder="Phone" required>
        </div>
        <hr>

        <h2 class="my-4">Card Details:</h2>
        <div class="form-group mb-3">
            <label for="from">Name on Card:</label>
            <input type="text" name="nameOnCard" value="" class="form-control" id="" placeholder="Name on the Card" >
          </div>
          <div class="form-group mb-3">
            <label for="to">Card No.:</label>
            <input type="text" name="cardNumber" value="" class="form-control" id="" placeholder="Card Number" >
          </div>
          <div class="form-group mb-3">
            <label for="from">Expiry Date:</label>
            <input type="text" name="expiryDate" value="" class="form-control" id="" placeholder="Expiry Date" >
          </div>
          <div class="form-group mb-3">
            <label for="from">Three Digit Security Code:</label>
            <input type="text" name="securityCode" value="" class="form-control" id="" placeholder="Three Digit Security Code" >
          </div>
          <div class="form-group mb-3">
            <!-- <label for="from">Three Digit Security Code:</label> -->
            <input type="hidden" name="flightId" value="${flight.id}" class="form-control" id="">
          </div>
        <button type="submit" value="confirm" class="btn btn-primary">Confirm Reservation</button>
      </form>
</body>
</html>