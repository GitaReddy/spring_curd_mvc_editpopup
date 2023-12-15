<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Register Form </title>
    <!-- Include Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
 
<div class="container mt-5">
    <h1>Laptop Form</h1>
    <form action="/save" method="post">
        <div class="form-group">
            <label for="id">ID</label>
            <input type="number" class="form-control" id="id" name="id" placeholder="Enter ID">
        </div>
        <div class="form-group">
            <label for="brand">BRAND</label>
            <input type="text" class="form-control" id="brand" name="brand" placeholder="Enter brand">
        </div>
        <div class="form-group">
            <label for="price">PRICE</label>
            <input type="text" class="form-control" id="price" name="price" placeholder="Enter price">
        </div>
        
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
 
 
 
</body>
</html>
 